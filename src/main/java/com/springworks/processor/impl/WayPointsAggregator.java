/**
 * 
 */
package com.springworks.processor.impl;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import com.springworks.common.GeoDistanceCalculator;
import com.springworks.common.TimeCalculator;
import com.springworks.models.BasicEvent;
import com.springworks.models.PointToPointMetric;
import com.springworks.models.WayPoint;
import com.springworks.processor.api.QueuedDataProcessor;
import com.springworks.stream.api.IDataFeeder;

/**
 * @author assar
 *
 */
public class WayPointsAggregator extends QueuedDataProcessor {

	private AtomicInteger pointToPointMetricCounter = new AtomicInteger(0);
	private WayPoint priorWayPoint = null;
	private PointToPointMetric priorPointToPointMetric = null;

	public WayPointsAggregator(IDataFeeder dataFeeder) {
		super();
		setDataFeeder(dataFeeder);
	}

	@Override
	public Optional<BasicEvent> process(BasicEvent e) {
		
		if (priorWayPoint == null) {
			priorWayPoint = (WayPoint) e;
			return Optional.ofNullable(null);
		} else {
			WayPoint newWayPoint = (WayPoint) e;
			PointToPointMetric newPointToPointMetric = getPointToPointMetric(newWayPoint);
			priorWayPoint = newWayPoint;
			priorPointToPointMetric = newPointToPointMetric;
			return Optional.of(newPointToPointMetric);
		}

	}

	private PointToPointMetric getPointToPointMetric(WayPoint currentWayPoint) {
		long deltaDurationInSec = TimeCalculator.getDeltaEpochMillis(priorWayPoint.getTimestamp(),
				currentWayPoint.getTimestamp());
		double deltaDistanceInKm = GeoDistanceCalculator.getDistanceInKm(priorWayPoint.getPosition(),
				currentWayPoint.getPosition());
		double actualSpeed = priorWayPoint.getSpeed();
		double speedLimit = priorWayPoint.getSpeedLimit();
		long priorAccumlatedDurationInSe = (priorPointToPointMetric != null)
				? priorPointToPointMetric.getAccumlatedDurationInSec() : 0;
		long accumlatedDurationInSec = priorAccumlatedDurationInSe + deltaDurationInSec;
		double priorAccumlatedDistanceInKm = (priorPointToPointMetric != null)
				? priorPointToPointMetric.getAccumlatedDistanceInKm() : 0.0d;
		double accumlatedDistanceInKm = priorAccumlatedDistanceInKm + deltaDistanceInKm;

		PointToPointMetric newPointToPointMetric = new PointToPointMetric(pointToPointMetricCounter.incrementAndGet(),
				deltaDurationInSec, deltaDistanceInKm, actualSpeed, speedLimit, accumlatedDurationInSec,
				accumlatedDistanceInKm);

		return newPointToPointMetric;
	}

}
