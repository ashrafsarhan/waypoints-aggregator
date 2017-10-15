/**
 * 
 */
package com.springworks.models;

/**
 * @author assar
 *
 */
public class WayPoint extends BasicEvent {

	private Position position;
	private double speed;
	private double speedLimit;
	
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
		return speedLimit;
	}
	
	@Override
	public String toString() {
		return "WayPoint [timestamp=" + getTimestamp() +", position=" + position + ", speed=" + speed + ", speedLimit=" + speedLimit + "]";
	}
}
