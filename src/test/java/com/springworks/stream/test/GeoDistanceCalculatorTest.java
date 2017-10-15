/**
 * 
 */
package com.springworks.stream.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.springworks.common.GeoDistanceCalculator;
import com.springworks.models.Position;

/**
 * @author assar
 *
 */
public class GeoDistanceCalculatorTest {

	@Test
	public void testDistanceCalculatorBetweenTwoWayPoints() {
		Position x = new Position(32.9697, -96.80322);
		Position y = new Position(29.46786, -98.53506);
		double dist = GeoDistanceCalculator.getDistanceInKm(x, y);
		//Getting the expected distance between the two points via https://www.geodatasource.com/distance-calculator
		assertEquals("Test Fails (Not the expected distance between x and y)", 422.74, dist, 0.02d);
	}

}
