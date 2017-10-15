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
	private long deltaDuration;
	private long deltaDistance;
	private double actualSpeed;
	private double speedLimit;
	private long accumlatedDuration;
	private long accumlatedDistance;

	public PointToPointMetric(int id, long deltaDuration, long deltaDistance, double actualSpeed, double speedLimit,
			long accumlatedDuration, long accumlatedDistance) {
		super(false);
		this.id = id;
		this.deltaDuration = deltaDuration;
		this.deltaDistance = deltaDistance;
		this.actualSpeed = actualSpeed;
		this.speedLimit = speedLimit;
		this.accumlatedDuration = accumlatedDuration;
		this.accumlatedDistance = accumlatedDistance;
	}

	public int getId() {
		return id;
	}

	public long getDeltaDuration() {
		return deltaDuration;
	}

	public long getDeltaDistance() {
		return deltaDistance;
	}

	public double getActualSpeed() {
		return actualSpeed;
	}

	public double getSpeedLimit() {
		return speedLimit;
	}

	public long getAccumlatedDuration() {
		return accumlatedDuration;
	}

	public long getAccumlatedDistance() {
		return accumlatedDistance;
	}

}
