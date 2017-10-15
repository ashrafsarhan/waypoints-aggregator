/**
 * 
 */
package com.springworks.models;

/**
 * @author assar
 *
 */
public class PointToPointMetric extends BasicEvent {

	private int id;
	private long deltaDurationInSec;
	private long deltaDistanceInKm;
	private double actualSpeed;
	private double speedLimit;
	private long accumlatedDurationInSec;
	private long accumlatedDistanceInKm;

	public PointToPointMetric(int id, long deltaDurationInSec, long deltaDistanceInKm, double actualSpeed,
			double speedLimit, long accumlatedDurationInSec, long accumlatedDistanceInKm) {
		super(false);
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

	public long getDeltaDistanceInKm() {
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

	public long getAccumlatedDistanceInKm() {
		return accumlatedDistanceInKm;
	}

}
