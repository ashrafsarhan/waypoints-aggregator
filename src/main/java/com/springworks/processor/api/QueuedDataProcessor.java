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
		dataFeeder.streamIncomingDataEvent().forEach(e -> {
            process(e).ifPresent(this::addOutgoingDataEvent);
		});
	}

	public boolean addOutgoingDataEvent(BasicEvent e) {
		return outgoingDataEvents.add(e);
	}

	@Override
	public Stream<BasicEvent> streamOutgoingDataEvents() {
		return outgoingDataEvents.stream();
	}

}
