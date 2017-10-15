/**
 * 
 */
package com.springworks.processor.api;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Stream;

import com.springworks.models.BasicEvent;
import com.springworks.stream.api.IDataFeeder;

/**
 * @author assar
 *
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
			while(!dataFeeder.isAvailableStream()) {
			}
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
	
	@Override
	public boolean isAvailableStream() {
		return !outgoingDataEvents.isEmpty();
	}

	public boolean addOutgoingDataEvent(BasicEvent e) {
		return outgoingDataEvents.add(e);
	}

	@Override
	public Stream<BasicEvent> streamOutgoingDataEvents() {
		return outgoingDataEvents.stream();
	}

}
