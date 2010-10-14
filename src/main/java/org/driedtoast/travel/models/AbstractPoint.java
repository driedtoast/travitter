package org.driedtoast.travel.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an point in the graph Base attributes for any point
 * 
 * @author driedtoast
 * 
 */
public abstract class AbstractPoint implements Point {

	private List<Hop> incoming;
	private List<Hop> outgoing;
	private long lat = -1;
	private long lon = -1;

	private String name;

	public List<Hop> getIncoming() {
		if (incoming == null) {
			incoming = new ArrayList<Hop>();
		}
		return incoming;
	}

	public void setIncoming(List<Hop> incoming) {
		this.incoming = incoming;
	}

	public List<Hop> getOutgoing() {
		if (outgoing == null) {
			outgoing = new ArrayList<Hop>();
		}
		return outgoing;
	}

	public void setOutgoing(List<Hop> outgoing) {
		this.outgoing = outgoing;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getLat() {
		return lat;
	}

	public void setLat(long lat) {
		this.lat = lat;
	}

	public long getLon() {
		return lon;
	}

	public void setLon(long lon) {
		this.lon = lon;
	}

	
	/**
	 * A point is empty if there are no hops 0
	 */
	public boolean isEmpty() {
		return (this.getOutgoing().isEmpty() && this.getIncoming().isEmpty());
	}
	
	/**
	 * Starting point is represented as a no incoming only outgoing
	 */
	public boolean isStartingPoint() {
		return (this.getIncoming().isEmpty() && !this.getOutgoing().isEmpty());
	}
	
	

}
