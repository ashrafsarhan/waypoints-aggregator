/**
 * 
 */
package com.springworks.bootstrap;

import java.io.File;

/**
 * @author assar
 *
 */
public class WayPointsAggregatorApp {

	/**
	 * @param args
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
