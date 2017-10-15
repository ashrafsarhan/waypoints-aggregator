/**
 * 
 */
package com.springworks.stream.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.springworks.common.TimeCalculator;

/**
 * @author assar
 *
 */
public class TimeCalculatorTest {

	@Test
	public void testTimeDiffCalculatorBetweenTwoWayPoints() {
		String t1 = "2016-06-21T12:00:00.000Z";
		String t2 = "2016-06-21T12:00:05.000Z";
		assertEquals("Test Fails (Not the expected time difference between x and y)", 5000, TimeCalculator.getDeltaEpochMillis(t1, t2));
	}
	
	@Test
	public void testZeroTimeDiffCalculatorBetweenTwoWayPoints() {
		String t1 = "";
		String t2 = "2016-06-21T12:00:05.000Z";
		assertEquals("Test Fails (Not the expected time difference between x and y)", 0, TimeCalculator.getDeltaEpochMillis(t1, t2));
	}

}
