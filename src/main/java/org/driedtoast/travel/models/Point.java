package org.driedtoast.travel.models;

import java.util.List;

/**
 * Represents a point in a graph
 * 
 * @author driedtoast
 *
 */
public interface Point {
	
	
	public String getName();
	
	/**
	 * Starting point 
	 * 
	 * @return
	 */
	public boolean isStartingPoint();
	
	/**
	 * No hops associated with it
	 * @return
	 */
	public boolean isEmpty();
	
	/**
	 * Get incoming edges
	 * 
	 * @return
	 */
	public List<Hop> getIncoming();
	
	/**
	 * Get outgoing edges
	 * 
	 * @return
	 */
	public List<Hop> getOutgoing();
	
}
