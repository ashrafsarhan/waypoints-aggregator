/**
 * 
 */
package com.springworks.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
    private List<PointToPointMetric> pointToPointMetrics;
    private AtomicInteger counter;
    
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		counter = new AtomicInteger(0);
		//Set initial expected PointToPointMetrics
		pointToPointMetrics = new ArrayList<>();
		pointToPointMetrics.add(new PointToPointMetric(1, 5000, 0.04, 6.3889, 8.33, 5000, 0.04));
		pointToPointMetrics.add(new PointToPointMetric(2, 5000, 0.07, 9.4, 8.33, 10000, 0.11));
		pointToPointMetrics.add(new PointToPointMetric(3, 5000, 0.04, 11.1, 8.33, 15000, 0.15));
		pointToPointMetrics.add(new PointToPointMetric(4, 5000, 0.04, 8.32, 8.33, 20000, 0.19));
		//Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("waypoints.json").getFile());
		wayPointsAggregator = new WayPointsAggregator(new FileDataFeeder(file));
		wayPointsAggregator.start();
	}

	@Test
	public void testTheResultedPointToPointMetrics() {
		wayPointsAggregator.streamOutgoingDataEvents().filter(e -> !e.isEnd()).forEach(e -> {
			System.out.println(e);
			//Assert on the resulted PointToPointMetric from the WayPointsAggregator processor
			assertEquals("Test Fails (Not the expected pointToPointMetric " + counter.get() + ")", pointToPointMetrics.get(counter.getAndIncrement()), e);	
		});
	}

}
