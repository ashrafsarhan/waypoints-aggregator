/**********************************************************************
 *  Copyright (c) 2017, Springworks, All right reserved.
 *  
 **********************************************************************/
package com.springworks.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * The Class TimeCalculator.
 *
 * @author Ashraf Sarhan <ashraf.sar7an@gmail.com>
 */
public class TimeCalculator {

	private static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
	private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT_PATTERN);

	/**
	 * Gets the delta epoch millis.
	 *
	 * @param priorTimestamp the prior timestamp
	 * @param currentTimestamp the current timestamp
	 * @return the delta epoch millis
	 */
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

	/**
	 * Gets the epoch millis.
	 *
	 * @param timestamp the timestamp
	 * @return the epoch millis
	 * @throws ParseException the parse exception
	 */
	public static long getEpochMillis(String timestamp) throws ParseException {
		return SIMPLE_DATE_FORMAT.parse(timestamp).getTime();
	}

}
