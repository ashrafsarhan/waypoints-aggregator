/**
 * 
 */
package com.springworks.models;

import java.time.LocalDateTime;

/**
 * @author assar
 *
 */
public class PointToPointMetric extends BasicEvent {

	private int id;
	private long deltaDurationInSec;
	private double deltaDistanceInKm;
	private double actualSpeed;
	private double speedLimit;
	private long accumlatedDurationInSec;
	private double accumlatedDistanceInKm;

	public PointToPointMetric(int id, long deltaDurationInSec, double deltaDistanceInKm, double actualSpeed,
			double speedLimit, long accumlatedDurationInSec, double accumlatedDistanceInKm) {
		super(false);
		this.timestamp = LocalDateTime.now().toString();
		this.id = id;
		this.deltaDurationInSec = deltaDurationInSec;
		this.deltaDistanceInKm = deltaDistanceInKm;
		this.actualSpeed = actualSpeed;
		this.speedLimit = speedLimit;
		this.accumlatedDurationInSec = accumlatedDurationInSec;
		this.accumlatedDistanceInKm = accumlatedDistanceInKm;
	}

	public int getId() {
		return id;
	}

	public long getDeltaDurationInSec() {
		return deltaDurationInSec;
	}

	public double getDeltaDistanceInKm() {
		return deltaDistanceInKm;
	}

	public double getActualSpeed() {
		return actualSpeed;
	}

	public double getSpeedLimit() {
		return speedLimit;
	}

	public long getAccumlatedDurationInSec() {
		return accumlatedDurationInSec;
	}

	public double getAccumlatedDistanceInKm() {
		return accumlatedDistanceInKm;
	}

	@Override
	public String toString() {
		return "PointToPointMetric [id=" + id + ", deltaDurationInSec=" + deltaDurationInSec + ", deltaDistanceInKm="
				+ deltaDistanceInKm + ", actualSpeed=" + actualSpeed + ", speedLimit=" + speedLimit
				+ ", accumlatedDurationInSec=" + accumlatedDurationInSec + ", accumlatedDistanceInKm="
				+ accumlatedDistanceInKm + "]";
	}
	
}
