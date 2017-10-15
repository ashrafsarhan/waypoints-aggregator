/**
 * 
 */
package com.springworks.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author assar
 *
 */
public class TimeCalculator {
	
	private static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
	private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT_PATTERN);
	
	public static long getDeltaEpochMillis(String priorTimestamp, String currentTimestamp) {
		long deltaEpochMillis = getEpochMillis(currentTimestamp) - getEpochMillis(priorTimestamp);
		return deltaEpochMillis;
	}
	
	public static long getEpochMillis(String timestamp) {
		long epochMillis = 0;
		try {
			epochMillis = SIMPLE_DATE_FORMAT.parse(timestamp).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return epochMillis;
	}
}
