/**********************************************************************
 *  Copyright (c) 2017, Springworks, All right reserved.
 *  
 **********************************************************************/
package com.springworks.bootstrap;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * The Class WayPointsAggregatorApp.
 *
 * @author Ashraf Sarhan <ashraf.sarhan@gmail.com>
 */
public class WayPointsAggregatorApp {
	
	private final static Logger logger = Logger.getLogger(WayPointsAggregatorApp.class);

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String inputfilePath = args[0];
		File file = new File(inputfilePath);
		if (file.exists())
			new AppInitializer(file);
		else
			logger.error("File not found in " + inputfilePath);
	}

}
