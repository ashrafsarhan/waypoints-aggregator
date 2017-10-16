/**********************************************************************
 *  Copyright (c) 2017, Springworks, All right reserved.
 *  
 **********************************************************************/
package com.springworks.processor.api;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Stream;

import com.springworks.models.BasicEvent;
import com.springworks.stream.api.IDataFeeder;

/**
 * The Class QueuedDataProcessor.
 *
 * @author Ashraf Sarhan <ashraf.sar7an@gmail.com>
 */
public abstract class QueuedDataProcessor implements IDataProcessor {

	private ConcurrentLinkedQueue<BasicEvent> outgoingDataEvents = new ConcurrentLinkedQueue<BasicEvent>();
	private IDataFeeder dataFeeder;

	@Override
	public void setDataFeeder(IDataFeeder dataFeeder) {
		this.dataFeeder = dataFeeder;
	}

	@Override
	public void start() {
		new Thread(() -> {
			dataFeeder.start();
			dataFeeder.streamIncomingDataEvent().forEach(e -> {
				if (!e.isEnd()) {
					process(e).ifPresent(this::addOutgoingDataEvent);
				} else {
					addOutgoingDataEvent(new BasicEvent(true));
					return;
				}
			});
		}).start();
	}
	
	/**
	 * Checks if is available stream.
	 *
	 * @return true, if is available stream
	 */
	private boolean isAvailableStream() {
		return !outgoingDataEvents.isEmpty();
	}

	/**
	 * Adds the outgoing data event.
	 *
	 * @param e the e
	 * @return true, if successful
	 */
	public boolean addOutgoingDataEvent(BasicEvent e) {
		return outgoingDataEvents.add(e);
	}

	@Override
	public Stream<BasicEvent> streamOutgoingDataEvents() {
		while(!isAvailableStream()) {
		}
		return outgoingDataEvents.stream();
	}

}
