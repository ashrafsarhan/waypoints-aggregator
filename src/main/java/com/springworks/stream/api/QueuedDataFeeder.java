/**********************************************************************
 *  Copyright (c) 2017, Springworks, All right reserved.
 *  
 **********************************************************************/
package com.springworks.stream.api;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Stream;

import com.springworks.models.BasicEvent;

/**
 * The Class QueuedDataFeeder.
 *
 * @author Ashraf Sarhan <ashraf.sar7an@gmail.com>
 */
public abstract class QueuedDataFeeder implements IDataFeeder {

	private ConcurrentLinkedQueue<BasicEvent> incomingDataEvents = new ConcurrentLinkedQueue<BasicEvent>();

	/**
	 * Adds the incoming data event.
	 *
	 * @param e the e
	 * @return true, if successful
	 */
	public boolean addIncomingDataEvent(BasicEvent e) {
		return incomingDataEvents.add(e);
	}

	@Override
	public Stream<BasicEvent> streamIncomingDataEvent() {
		while(!isAvailableStream()) {
		}
		return incomingDataEvents.stream();
	}

	/**
	 * Checks if is available stream.
	 *
	 * @return true, if is available stream
	 */
	private boolean isAvailableStream() {
		return !incomingDataEvents.isEmpty();
	}
	
	@Override
	public void start() {
		new Thread(() -> {
			feed();
		}).start();
	}

}
