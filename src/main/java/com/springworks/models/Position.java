/**********************************************************************
 *  Copyright (c) 2017, Springworks, All right reserved.
 *  
 **********************************************************************/
package com.springworks.models;

/**
 * The Class Position.
 *
 * @author Ashraf Sarhan <ashraf.sar7an@gmail.com>
 */
public class Position {

	private double latitude;
	private double longitude;
	
	/**
	 * Instantiates a new position.
	 *
	 * @param latitude the latitude
	 * @param longitude the longitude
	 */
	public Position(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	
	@Override
	public String toString() {
		return "Position [latitude=" + latitude + ", longitude=" + longitude + "]";
	} 
	
}
