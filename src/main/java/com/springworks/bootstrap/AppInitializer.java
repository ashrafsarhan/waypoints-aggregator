/**********************************************************************
 *  Copyright (c) 2017, Springworks, All right reserved.
 *  
 **********************************************************************/
package com.springworks.bootstrap;

import java.io.File;
import java.io.IOException;

import com.springworks.common.CsvFileWriter;
import com.springworks.processor.api.IDataProcessor;
import com.springworks.processor.impl.WayPointsAggregator;
import com.springworks.stream.impl.FileDataFeeder;

/**
 * The Class AppInitializer.
 *
 * @author Ashraf Sarhan <ashraf.sarhan@gmail.com>
 */
public class AppInitializer {

	// CSV file header
	private static final String CSV_FILE_HEADER = "id,deltaDurationInSec,deltaDistanceInKm,actualSpeed,speedLimit,accumlatedDurationInSec,accumlatedDistanceInKm";
	private IDataProcessor wayPointsAggregator;

	/**
	 * Instantiates a new app initializer.
	 *
	 * @param file the file
	 */
	public AppInitializer(File file) {
		wayPointsAggregator = new WayPointsAggregator(new FileDataFeeder(file));
		wayPointsAggregator.start();
		saveWayPointsMetricsDataToCsvFile();
	}

	/**
	 * Save way points metrics data to csv file.
	 */
	private void saveWayPointsMetricsDataToCsvFile() {
		try {
			CsvFileWriter.writeCsvFile("waypoints_metrics.csv", CSV_FILE_HEADER,
					wayPointsAggregator.streamOutgoingDataEvents());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
