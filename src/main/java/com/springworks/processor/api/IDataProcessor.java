/**********************************************************************
 *  Copyright (c) 2017, Springworks, All right reserved.
 *  
 **********************************************************************/
package com.springworks.processor.api;

import java.util.Optional;
import java.util.stream.Stream;

import com.springworks.models.BasicEvent;
import com.springworks.stream.api.IDataFeeder;

/**
 * The Interface IDataProcessor.
 *
 * @author Ashraf Sarhan <ashraf.sar7an@gmail.com>
 */
public interface IDataProcessor {
	
	/**
	 * Sets the data feeder.
	 *
	 * @param dataFeeder the new data feeder
	 */
	public void setDataFeeder(IDataFeeder dataFeeder);
	
	/**
	 * Process.
	 *
	 * @param e the e
	 * @return the optional
	 */
	public Optional<BasicEvent> process(BasicEvent e);
	
	/**
	 * Start.
	 */
	public void start();

	/**
	 * Stream outgoing data events.
	 *
	 * @return the stream
	 */
	public Stream<BasicEvent> streamOutgoingDataEvents();

}
