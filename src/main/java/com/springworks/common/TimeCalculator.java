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
		long deltaEpochMillis = 0;
		try {
			deltaEpochMillis = getEpochMillis(currentTimestamp) - getEpochMillis(priorTimestamp);
		} catch (ParseException e) {
			System.out.println("Invalid given DateTime format");
			return 0;
		}
		return deltaEpochMillis;
	}

	public static long getEpochMillis(String timestamp) throws ParseException {
		return SIMPLE_DATE_FORMAT.parse(timestamp).getTime();
	}

}
