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
	
	public void setup();
	
	public boolean addDataEvent(BasicEvent e);

	public Stream<BasicEvent> streamDataEvent();

}
