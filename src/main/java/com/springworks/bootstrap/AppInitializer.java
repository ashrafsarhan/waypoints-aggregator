/**********************************************************************
 *  Copyright (c) 2017, Springworks, All right reserved.
 *  
 **********************************************************************/
package com.springworks.bootstrap;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.springworks.common.CsvFileWriter;
import com.springworks.models.BasicEvent;
import com.springworks.processor.api.IDataProcessor;
import com.springworks.processor.impl.WayPointsAggregator;
import com.springworks.stream.impl.FileDataFeeder;

/**
 * The Class AppInitializer.
 *
 * @author Ashraf Sarhan <ashraf.sarhan@gmail.com>
 */
public class AppInitializer {

	private final static Logger logger = Logger.getLogger(AppInitializer.class);
	// CSV file header
	private static final String CSV_FILE_HEADER = "id,deltaDurationInSec,deltaDistanceInKm,actualSpeed,speedLimit,accumlatedDurationInSec,accumlatedDistanceInKm";
	private IDataProcessor wayPointsAggregator;
	private CsvFileWriter csvFileWriter;

	/**
	 * Instantiates a new app initializer.
	 *
	 * @param file the file
	 * @throws IOException 
	 */
	public AppInitializer(File file) throws IOException {
		wayPointsAggregator = new WayPointsAggregator(new FileDataFeeder(file));
		wayPointsAggregator.start();
		csvFileWriter = new CsvFileWriter("waypoints_metrics.csv", CSV_FILE_HEADER);
		saveWayPointsMetricsDataToCsvFile();
	}

	/**
	 * Save way points metrics data to csv file.
	 */
	private void saveWayPointsMetricsDataToCsvFile() {
		new Thread(() -> {
			while (true) {
				BasicEvent event = wayPointsAggregator.getOutgoingDataEvent();
				if (!event.isEnd()) {
					csvFileWriter.writeCsvFile(event);
				} else {
					csvFileWriter.close();
					logger.debug(wayPointsAggregator.getClass().getSimpleName() + " output CSV file was created successfully.");
					return;
				}
			}
		}).start();
	}

}
