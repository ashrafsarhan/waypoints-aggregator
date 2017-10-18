/**
 * 
 */
package com.springworks.test;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.springworks.models.BasicEvent;
import com.springworks.stream.api.IDataFeeder;
import com.springworks.stream.impl.FileDataFeeder;

/**
 * @author assar
 *
 */
public class FileDataFeederTest {

	private IDataFeeder wayPointsDataFeeder;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("waypoints.json").getFile());
		wayPointsDataFeeder = new FileDataFeeder(file);
		wayPointsDataFeeder.start();
	}

	@Test
	public void testTheIncomingDataEvent() {
		BasicEvent incomingDataEvent = wayPointsDataFeeder.getIncomingDataEvent();
		assertEquals("Test Fails (Not the expected first event)", true,
				(!incomingDataEvent.isEnd() && incomingDataEvent.getTimestamp().equals("2016-06-21T12:00:00.000Z")));
		incomingDataEvent = wayPointsDataFeeder.getIncomingDataEvent();
		assertEquals("Test Fails (Not the expected second event)", true,
				(!incomingDataEvent.isEnd() && incomingDataEvent.getTimestamp().equals("2016-06-21T12:00:05.000Z")));
		incomingDataEvent = wayPointsDataFeeder.getIncomingDataEvent();
		assertEquals("Test Fails (Not the expected third event)", true,
				(!incomingDataEvent.isEnd() && incomingDataEvent.getTimestamp().equals("2016-06-21T12:00:10.000Z")));
		incomingDataEvent = wayPointsDataFeeder.getIncomingDataEvent();
		assertEquals("Test Fails (Not the expected fourth event)", true,
				(!incomingDataEvent.isEnd() && incomingDataEvent.getTimestamp().equals("2016-06-21T12:00:15.000Z")));
		incomingDataEvent = wayPointsDataFeeder.getIncomingDataEvent();
		assertEquals("Test Fails (Not the expected fifth event)", true,
				(!incomingDataEvent.isEnd() && incomingDataEvent.getTimestamp().equals("2016-06-21T12:00:20.000Z")));
		incomingDataEvent = wayPointsDataFeeder.getIncomingDataEvent();
		assertEquals("Test Fails (Not the expected end event)", true, incomingDataEvent.isEnd());
	}

}
