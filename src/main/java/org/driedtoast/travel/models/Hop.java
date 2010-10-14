package org.driedtoast.travel.models;


/**
 * Represents an edge in a graph
 * 
 * @author driedtoast
 *
 */
public class Hop {

	private long length = -1;
	private DistanceType distanceType = DistanceType.MILEAGE;
	private HopType type = HopType.HIGHWAY;
	private double weight = 0.0;
	private String name = "hop";
	private Point target;
	private Point source;
	// TODO define weight logic
	
	
	public long getLength() {
		return length;
	}
	public void setLength(long length) {
		this.length = length;
	}
	public DistanceType getDistanceType() {
		return distanceType;
	}
	public void setDistanceType(DistanceType distanceType) {
		this.distanceType = distanceType;
	}
	public HopType getType() {
		return type;
	}
	public void setType(HopType type) {
		this.type = type;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Point getTarget() {
		return target;
	}
	public void setTarget(Point target) {
		if(target == null) {
			return;
		}
		target.getIncoming().add(this);
		this.target = target;
	}
	public Point getSource() {
		return source;
	}
	public void setSource(Point source) {
		if(source == null) {
			return;
		}
		source.getOutgoing().add(this);
		this.source = source;
	}
	
	
}
