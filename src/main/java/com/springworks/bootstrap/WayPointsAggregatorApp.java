/**********************************************************************
 *  Copyright (c) 2017, Springworks, All right reserved.
 *  
 **********************************************************************/
package com.springworks.bootstrap;

import java.io.File;

/**
 * The Class WayPointsAggregatorApp.
 *
 * @author Ashraf Sarhan <ashraf.sarhan@gmail.com>
 */
public class WayPointsAggregatorApp {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		String inputfilePath = args[0];
		File file = new File(inputfilePath);
		if (file.exists())
			new AppInitializer(file);
		else
			System.out.println("Could not find the give file: " + inputfilePath);
	}

}
