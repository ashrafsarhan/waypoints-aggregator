/**
 * 
 */
package com.springworks.stream.api;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Stream;

import com.springworks.models.BasicEvent;

/**
 * @author assar
 *
 */
public abstract class QueuedDataFeeder implements IDataFeeder {

	private ConcurrentLinkedQueue<BasicEvent> incomingDataEvents = new ConcurrentLinkedQueue<BasicEvent>();

	public boolean addIncomingDataEvent(BasicEvent e) {
		return incomingDataEvents.add(e);
	}

	@Override
	public Stream<BasicEvent> streamIncomingDataEvent() {
		return incomingDataEvents.stream();
	}

}
