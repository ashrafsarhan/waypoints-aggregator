/**********************************************************************
 *  Copyright (c) 2017, Springworks, All right reserved.
 *  
 **********************************************************************/
package com.springworks.common;

import java.text.DecimalFormat;

/**
 * The Class NumberUtils.
 *
 * @author Ashraf Sarhan <ashraf.sar7an@gmail.com>
 */
public class NumberUtils {

	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###.##");

	/**
	 * Round double to two decimal points.
	 *
	 * @param d the d
	 * @return the double
	 */
	public static double roundDoubleToTwoDecimalPoints(double d) {
		return Double.valueOf(DECIMAL_FORMAT.format(d));
	}

}
