/**********************************************************************
 *  Copyright (c) 2017, Springworks, All right reserved.
 *  
 **********************************************************************/
package com.springworks.common;

import java.io.FileWriter;
import java.io.IOException;

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
	private final FileWriter fileWriter;

	public CsvFileWriter(String fileName, String csvHeader) throws IOException {
		super();
		this.fileWriter = new FileWriter(fileName);
		// Write the CSV file header
		fileWriter.append(csvHeader);
		// Add a new line separator after the header
	    fileWriter.append(NEW_LINE_SEPARATOR);
	}

	
	/**
	 * Write csv file.
	 *
	 * @param event the event
	 */
	public void writeCsvFile(BasicEvent event) {
		try {
			// Write events to the CSV file
			fileWriter.append(event.toString());
			fileWriter.append(NEW_LINE_SEPARATOR);

		} catch (Exception e) {
			close();
			logger.error("Error occured in CsvFileWriter: ", e);
		}
	}

	/**
	 * Close.
	 */
	public void close() {
		try {
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			logger.error("Error occured while flushing/closing fileWriter: ", e);
		}
	}
}
