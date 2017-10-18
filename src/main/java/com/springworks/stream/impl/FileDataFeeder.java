/**********************************************************************
 *  Copyright (c) 2017, Springworks, All right reserved.
 *  
 **********************************************************************/
package com.springworks.stream.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.springworks.models.BasicEvent;
import com.springworks.models.WayPoint;
import com.springworks.stream.api.QueuedDataFeeder;

/**
 * The Class FileDataFeeder.
 *
 * @author Ashraf Sarhan <ashraf.sar7an@gmail.com>
 */
public class FileDataFeeder extends QueuedDataFeeder {
	
	private final static Logger logger = Logger.getLogger(FileDataFeeder.class);
	private File file;

	/**
	 * Instantiates a new file data feeder.
	 *
	 * @param file the file
	 */
	public FileDataFeeder(File file) {
		super();
		this.file = file;
	}

	@Override
	public void feed() {
		try(JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
		    Gson gson = new GsonBuilder().create();		 
		    jsonReader.beginArray();
		    while (jsonReader.hasNext()){
		        WayPoint wayPoint = gson.fromJson(jsonReader, WayPoint.class);
		        addIncomingDataEvent(wayPoint);
		    }
		    addIncomingDataEvent(new BasicEvent(true));
		    return;
		}
		catch (UnsupportedEncodingException e) {
			logger.error("Fatal error: UnsupportedEncodingException", e);
		    e.printStackTrace();
		} catch (FileNotFoundException e) {
			logger.error("Fatal error: FileNotFoundException", e);
		} catch (IOException e) {
			logger.error("Fatal error: IOException was occurred", e);
		}
	}

}
