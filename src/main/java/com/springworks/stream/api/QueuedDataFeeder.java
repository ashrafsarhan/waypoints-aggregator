/**********************************************************************
 *  Copyright (c) 2017, Springworks, All right reserved.
 *  
 **********************************************************************/
package com.springworks.stream.api;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

import com.springworks.models.BasicEvent;

/**
 * The Class QueuedDataFeeder.
 *
 * @author Ashraf Sarhan <ashraf.sar7an@gmail.com>
 */
public abstract class QueuedDataFeeder implements IDataFeeder {

	private final static Logger logger = Logger.getLogger(QueuedDataFeeder.class);
	private BlockingQueue<BasicEvent> incomingDataEvents = new LinkedBlockingQueue<BasicEvent>();

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
	public BasicEvent getIncomingDataEvent() {
		try {
            return incomingDataEvents.take();
        } catch (InterruptedException ie) {
        	logger.debug("QueuedDataFeeder thread is interrupted", ie);
            return new BasicEvent(true);
        }
	}
	
	@Override
	public void start() {
		new Thread(() -> {
			feed();
		}).start();
	}

}
