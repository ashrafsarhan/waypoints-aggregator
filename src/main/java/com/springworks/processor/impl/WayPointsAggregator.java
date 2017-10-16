/**********************************************************************
 *  Copyright (c) 2017, Springworks, All right reserved.
 *  
 **********************************************************************/
package com.springworks.processor.impl;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import com.springworks.common.GeoDistanceCalculator;
import com.springworks.common.NumberUtils;
import com.springworks.common.TimeCalculator;
import com.springworks.models.BasicEvent;
import com.springworks.models.PointToPointMetric;
import com.springworks.models.WayPoint;
import com.springworks.processor.api.QueuedDataProcessor;
import com.springworks.stream.api.IDataFeeder;

/**
 * The Class WayPointsAggregator.
 *
 * @author Ashraf Sarhan <ashraf.sar7an@gmail.com>
 */
public class WayPointsAggregator extends QueuedDataProcessor {

	private AtomicInteger pointToPointMetricCounter = new AtomicInteger(0);
	private WayPoint priorWayPoint = null;
	private PointToPointMetric priorPointToPointMetric = null;

	/**
	 * Instantiates a new way points aggregator.
	 *
	 * @param dataFeeder the data feeder
	 */
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

	/**
	 * Gets the point to point metric.
	 *
	 * @param currentWayPoint the current way point
	 * @return the point to point metric
	 */
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
		double accumlatedDistanceInKm = NumberUtils.roundDoubleToTwoDecimalPoints(priorAccumlatedDistanceInKm + deltaDistanceInKm);

		PointToPointMetric newPointToPointMetric = new PointToPointMetric(pointToPointMetricCounter.incrementAndGet(),
				deltaDurationInSec, deltaDistanceInKm, actualSpeed, speedLimit, accumlatedDurationInSec,
				accumlatedDistanceInKm);

		return newPointToPointMetric;
	}

}
