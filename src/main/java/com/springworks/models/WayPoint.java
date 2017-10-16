/**********************************************************************
 *  Copyright (c) 2017, Springworks, All right reserved.
 *  
 **********************************************************************/
package com.springworks.models;

/**
 * The Class WayPoint.
 *
 * @author Ashraf Sarhan <ashraf.sar7an@gmail.com>
 */
public class WayPoint extends BasicEvent {

	private Position position;
	private double speed;
	private double speed_limit;
	
	public WayPoint() {
		super(false);
	}
	
	public Position getPosition() {
		return position;
	}
	public double getSpeed() {
		return speed;
	}
	public double getSpeedLimit() {
		return speed_limit;
	}
	
	@Override
	public String toString() {
		return "WayPoint [timestamp=" + getTimestamp() +", position=" + position + ", speed=" + speed + ", speedLimit=" + speed_limit + "]";
	}
}
