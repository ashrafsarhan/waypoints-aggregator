/**
 * 
 */
package com.springworks.common;

import java.text.DecimalFormat;

/**
 * @author assar
 *
 */
public class NumberUtils {

	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###.##");

	public static double roundDoubleToTwoDecimalPoints(double d) {
		return Double.valueOf(DECIMAL_FORMAT.format(d));
	}

}
