/**
 * 
 */
package com.springworks.bootstrap;

import java.io.File;
import java.io.IOException;

import com.springworks.common.CsvFileWriter;
import com.springworks.processor.api.IDataProcessor;
import com.springworks.processor.impl.WayPointsAggregator;
import com.springworks.stream.impl.FileDataFeeder;

/**
 * @author assar
 *
 */
public class AppInitializer {

	// CSV file header
	private static final String CSV_FILE_HEADER = "id,deltaDurationInSec,deltaDistanceInKm,actualSpeed,speedLimit,accumlatedDurationInSec,accumlatedDistanceInKm";
	private IDataProcessor wayPointsAggregator;

	public AppInitializer(File file) {
		wayPointsAggregator = new WayPointsAggregator(new FileDataFeeder(file));
		wayPointsAggregator.start();
		while (!wayPointsAggregator.isAvailableStream()) {
		}
		saveWayPointsMetricsDataToCsvFile();
	}

	private void saveWayPointsMetricsDataToCsvFile() {
		try {
			CsvFileWriter.writeCsvFile("waypoints_metrics.csv", CSV_FILE_HEADER,
					wayPointsAggregator.streamOutgoingDataEvents());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
