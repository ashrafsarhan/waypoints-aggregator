/**
 * 
 */
package com.springworks.stream.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.springworks.models.BasicEvent;
import com.springworks.models.WayPoint;
import com.springworks.stream.api.QueuedDataFeeder;

/**
 * @author assar
 *
 */
public class FileDataFeeder extends QueuedDataFeeder {
	
	private File file;

	public FileDataFeeder(File file) {
		super();
		this.file = file;
	}

	public void setup() {
		try(JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
		    Gson gson = new GsonBuilder().create();		 
		    jsonReader.beginArray();
		    while (jsonReader.hasNext()){
		        WayPoint wayPoint = gson.fromJson(jsonReader, WayPoint.class);
		        addIncomingDataEvent(wayPoint);
		    }
		    System.out.println("Add end event to the IncomingDataEvent Queue ...");
		    addIncomingDataEvent(new BasicEvent(true));
		}
		catch (UnsupportedEncodingException e) {
		    e.printStackTrace();
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
}
