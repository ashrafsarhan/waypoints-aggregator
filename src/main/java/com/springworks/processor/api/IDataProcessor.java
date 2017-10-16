/**
 * 
 */
package com.springworks.processor.api;

import java.util.Optional;
import java.util.stream.Stream;

import com.springworks.models.BasicEvent;
import com.springworks.stream.api.IDataFeeder;

/**
 * @author assar
 *
 */
public interface IDataProcessor {
	
	public void setDataFeeder(IDataFeeder dataFeeder);
	
	public Optional<BasicEvent> process(BasicEvent e);
	
	public void start();

	public Stream<BasicEvent> streamOutgoingDataEvents();

}
