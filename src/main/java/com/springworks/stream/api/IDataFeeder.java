/**
 * 
 */
package com.springworks.stream.api;

import java.util.stream.Stream;

import com.springworks.models.BasicEvent;

/**
 * @author assar
 *
 */
public interface IDataFeeder {
	
	public void start();

	public Stream<BasicEvent> streamIncomingDataEvent();

}
