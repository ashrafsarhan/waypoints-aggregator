/**********************************************************************
 *  Copyright (c) 2017, Springworks, All right reserved.
 *  
 **********************************************************************/
package com.springworks.common;

import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Stream;

import com.springworks.models.BasicEvent;

/**
 * The Class CsvFileWriter.
 * 
 * @author Ashraf Sarhan <ashraf.sarhan@gmail.com>
 */
public class CsvFileWriter {

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

			System.out.println("CSV file was created successfully !!!");

		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {

			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}

		}
	}
}
