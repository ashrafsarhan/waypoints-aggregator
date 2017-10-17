/**********************************************************************
 *  Copyright (c) 2017, Springworks, All right reserved.
 *  
 **********************************************************************/
package com.springworks.common;

import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import com.springworks.models.BasicEvent;

/**
 * The Class CsvFileWriter.
 * 
 * @author Ashraf Sarhan <ashraf.sarhan@gmail.com>
 */
public class CsvFileWriter {

	private final static Logger logger = Logger.getLogger(CsvFileWriter.class);
	private static final String NEW_LINE_SEPARATOR = "\n";

	/**
	 * Write csv file.
	 *
	 * @param fileName the file name
	 * @param csvHeader the csv header
	 * @param events the events
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void writeCsvFile(String fileName, String csvHeader, Stream<BasicEvent> events) throws IOException {
		final FileWriter fileWriter = new FileWriter(fileName);
		try {
			// Write the CSV file header
			fileWriter.append(csvHeader);

			// Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);

			// Write events to the CSV file
			events.filter(e -> !e.isEnd()).forEach(e -> {
				try {
					fileWriter.append(e.toString());
					fileWriter.append(NEW_LINE_SEPARATOR);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			});

			logger.debug("CSV file was created successfully!");

		} catch (Exception e) {
			logger.error("Error occured in CsvFileWriter: ", e);
		} finally {

			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				logger.error("Error occured while flushing/closing fileWriter: ", e);
				e.printStackTrace();
			}

		}
	}
}
