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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(accumlatedDistanceInKm);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (accumlatedDurationInSec ^ (accumlatedDurationInSec >>> 32));
		temp = Double.doubleToLongBits(actualSpeed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(deltaDistanceInKm);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (deltaDurationInSec ^ (deltaDurationInSec >>> 32));
		result = prime * result + id;
		temp = Double.doubleToLongBits(speedLimit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PointToPointMetric other = (PointToPointMetric) obj;
		if (Double.doubleToLongBits(accumlatedDistanceInKm) != Double.doubleToLongBits(other.accumlatedDistanceInKm))
			return false;
		if (accumlatedDurationInSec != other.accumlatedDurationInSec)
			return false;
		if (Double.doubleToLongBits(actualSpeed) != Double.doubleToLongBits(other.actualSpeed))
			return false;
		if (Double.doubleToLongBits(deltaDistanceInKm) != Double.doubleToLongBits(other.deltaDistanceInKm))
			return false;
		if (deltaDurationInSec != other.deltaDurationInSec)
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(speedLimit) != Double.doubleToLongBits(other.speedLimit))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PointToPointMetric [id=" + id + ", deltaDurationInSec=" + deltaDurationInSec + ", deltaDistanceInKm="
				+ deltaDistanceInKm + ", actualSpeed=" + actualSpeed + ", speedLimit=" + speedLimit
				+ ", accumlatedDurationInSec=" + accumlatedDurationInSec + ", accumlatedDistanceInKm="
				+ accumlatedDistanceInKm + "]";
	}
	
}
