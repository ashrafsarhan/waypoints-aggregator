/**
 * 
 */
package com.springworks.stream.test;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.springworks.models.PointToPointMetric;
import com.springworks.processor.api.IDataProcessor;
import com.springworks.processor.impl.WayPointsAggregator;
import com.springworks.stream.impl.FileDataFeeder;

/**
 * @author assar
 *
 */
public class WayPointsAggregatorTest {

    private IDataProcessor wayPointsAggregator;
    
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		//Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("waypoints.json").getFile());
		wayPointsAggregator = new WayPointsAggregator(new FileDataFeeder(file));
		wayPointsAggregator.start();
		while(!wayPointsAggregator.isAvailableStream()) {
		}
	}

	@Test
	public void testTheFirstDataEvent() {
		//Assert on the first data event time diff
		assertEquals("Test Fails (Not the expected first event)", 5000, ((PointToPointMetric)wayPointsAggregator.streamOutgoingDataEvents().findFirst().get()).getDeltaDurationInSec());	
	}
	
	@Test
	public void testTheLastDataEvent() {
		//Assert on the last data event (end event)
		assertEquals("Test Fails (Not the expected end event)", true, wayPointsAggregator.streamOutgoingDataEvents().filter(e -> e.isEnd()).findFirst().isPresent());	
	}

}
