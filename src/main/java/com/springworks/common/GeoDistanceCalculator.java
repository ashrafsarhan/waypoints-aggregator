/**
 * 
 */
package com.springworks.common;

import java.text.DecimalFormat;

import com.springworks.models.Position;

/**
 * @author assar
 *
 */
public class GeoDistanceCalculator {
	
	private static final int EARTH_RADIUS = 6371; // Radius of the earth in km
	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###.##");

	//https://stackoverflow.com/questions/27928/calculate-distance-between-two-latitude-longitude-points-haversine-formula
	//http://www.igismap.com/haversine-formula-calculate-geographic-distance-earth
	public static double getDistanceInKm(Position origin, Position destination) {
		double lat1 = origin.getLatitude();
		double lon1 = origin.getLongitude();
		double lat2 = destination.getLatitude();
		double lon2 = destination.getLongitude();
		double dLat = deg2rad(lat2-lat1);  // deg2rad below
		double dLon = deg2rad(lon2-lon1); 
		double a = 
			    Math.sin(dLat/2) * Math.sin(dLat/2) +
			    Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * 
			    Math.sin(dLon/2) * Math.sin(dLon/2); 
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
		double d = EARTH_RADIUS * c; // Distance in km
		return Double.valueOf(DECIMAL_FORMAT.format(d));
	}
	
	public static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

}
