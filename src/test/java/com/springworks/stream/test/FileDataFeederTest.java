/**
 * 
 */
package com.springworks.stream.test;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.springworks.stream.api.IDataFeeder;
import com.springworks.stream.impl.FileDataFeeder;

/**
 * @author assar
 *
 */
public class FileDataFeederTest {

	private IDataFeeder dataFeed;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		//Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("waypoints.json").getFile());
		dataFeed = new FileDataFeeder(file);
		dataFeed.start();
		while(!dataFeed.isAvailable()) {
		}
	}

	@Test
	public void testTheFirstDataEvent() throws InterruptedException {
		dataFeed.streamIncomingDataEvent().forEach(System.out::println);
		//Assert on the first data event timestamp (first line in the file)
		assertEquals("Test Fails (Not the expected first event)", "2016-06-21T12:00:00.000Z", dataFeed.streamIncomingDataEvent().findFirst().get().getTimestamp());	
	}
	
	@Test
	public void testTheLastDataEvent() throws InterruptedException {
		dataFeed.streamIncomingDataEvent().forEach(System.out::println);
		//Assert on the last data event (end event)
		assertEquals("Test Fails (Not the expected end event)", true, dataFeed.streamIncomingDataEvent().filter(e -> e.isEnd()).findFirst().isPresent());	
	}

}
