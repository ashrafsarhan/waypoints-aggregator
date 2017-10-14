/**
 * 
 */
package com.springworks.models;

/**
 * @author assar
 *
 */
public class Position {

	private double latitude;
	private double longitude;
	
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
