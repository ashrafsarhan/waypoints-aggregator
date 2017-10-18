/**********************************************************************
 *  Copyright (c) 2017, Springworks, All right reserved.
 *  
 **********************************************************************/
package com.springworks.processor.api;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

import com.springworks.models.BasicEvent;
import com.springworks.stream.api.IDataFeeder;
import com.springworks.stream.api.QueuedDataFeeder;

/**
 * The Class QueuedDataProcessor.
 *
 * @author Ashraf Sarhan <ashraf.sar7an@gmail.com>
 */
public abstract class QueuedDataProcessor implements IDataProcessor {

	private final static Logger logger = Logger.getLogger(QueuedDataFeeder.class);
	private BlockingQueue<BasicEvent> outgoingDataEvents = new LinkedBlockingQueue<BasicEvent>();
	private IDataFeeder dataFeeder;

	@Override
	public void setDataFeeder(IDataFeeder dataFeeder) {
		this.dataFeeder = dataFeeder;
	}

	@Override
	public void start() {
		new Thread(() -> {
			dataFeeder.start();
			while (true) {
				BasicEvent e = dataFeeder.getIncomingDataEvent();
				if (!e.isEnd()) {
					process(e).ifPresent(this::addOutgoingDataEvent);
				} else {
					addOutgoingDataEvent(e);
					return;
				}
			}
		}).start();
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
	public BasicEvent getOutgoingDataEvent() {
		try {
			return outgoingDataEvents.take();
		} catch (InterruptedException ie) {
			logger.debug("QueuedDataProcessor thread is interrupted", ie);
			return new BasicEvent(true);
		}
	}

}
