package org.driedtoast.travel.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The point and edge map container
 * 
 * @author driedtoast
 * 
 */
public class DestinationMap {

	
	private List<Destination> destinations;
	private List<Hop> hops;
	private DistanceType distanceType = DistanceType.MILEAGE;
	private Map<String,Point> points = new HashMap<String,Point>();
	
	public DistanceType getDistanceType() {
		return distanceType;
	}

	public void setDistanceType(DistanceType distanceType) {
		this.distanceType = distanceType;
	}

	public DestinationMap() {
		
	}
	
	public DestinationMap(DistanceType type) {
		this.distanceType = type;
	}
	
	
	
	
	
	public List<Destination> getDestinations() {
		if (destinations == null) {
			destinations = new ArrayList<Destination>();
		}
		return destinations;
	}

	public void setDestinations(List<Destination> destinations) {
		this.destinations = destinations;
	}

	public List<Hop> getHops() {
		if (hops == null) {
			hops = new ArrayList<Hop>();
		}
		return hops;
	}

	public void setHops(List<Hop> hops) {
		this.hops = hops;
	}

	public Hop addHop(Point source, Point target) {
		return this.addHop(source,target,0,HopType.HIGHWAY);
	}
	
	/**
	 * Gets a particular points
	 * @param name
	 * @return
	 */
	public Point getPoint(String name) {
		return this.points.get(name);
	}
	
	/**
	 * Adds point
	 * @param pt
	 */
	public void addPoint(Point pt) {
		if(pt.getName() == null || pt.getName().trim().length() == 0) {
			return;
		}
		this.points.put(pt.getName(), pt);
	}
	
	/**
	 * Gets a list of all points
	 * 
	 * @return
	 */
	public Collection<Point> getPoints() {
		return this.points.values();
	}
	
	/**
	 * Adds an edge to the map 
	 * 
	 * @param source
	 * @param target
	 * @param distance
	 * @param type
	 * @return
	 */
	public Hop addHop(Point source, Point target, long distance, HopType type) {
		this.addPoint(source);
		this.addPoint(target);
		Hop hop = new Hop();
		hop.setSource(source);
		hop.setTarget(target);
		hop.setType(type);
		hop.setDistanceType(distanceType);
		hop.setLength(distance);
		this.getHops().add(hop);
		return hop;
	}
	
	
	
	
}
