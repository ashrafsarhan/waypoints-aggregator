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
	
	private ConcurrentLinkedQueue<BasicEvent> events = new ConcurrentLinkedQueue<BasicEvent>();

	public boolean addDataEvent(BasicEvent e) {
		return events.add(e);
	}

	public Stream<BasicEvent> streamDataEvent() {
		return events.stream();
	}
	
}
