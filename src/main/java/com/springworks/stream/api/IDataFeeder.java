/**********************************************************************
 *  Copyright (c) 2017, Springworks, All right reserved.
 *  
 **********************************************************************/
package com.springworks.stream.api;

import java.util.stream.Stream;

import com.springworks.models.BasicEvent;

/**
 * The Interface IDataFeeder.
 *
 * @author Ashraf Sarhan <ashraf.sar7an@gmail.com>
 */
public interface IDataFeeder {
	
	/**
	 * Start.
	 */
	public void start();
	
	/**
	 * Feed.
	 */
	public void feed();

	/**
	 * Stream incoming data event.
	 *
	 * @return the stream
	 */
	public Stream<BasicEvent> streamIncomingDataEvent();

}
