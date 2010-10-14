package org.driedtoast.travel.models;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Test the model connections 
 * 
 * @author driedtoast
 *
 */
public class ConnectionTest {

	@Test
	public void testSimpleDestinationMapping() throws Exception {
	
		Destination to = new Destination("SFO");
		Destination from = new Destination("ATL");
		DestinationMap map = new DestinationMap(DistanceType.METERS);
		map.getDestinations().add(from);
		map.getDestinations().add(to);
		
		Assert.assertTrue(to.isEmpty());
		Assert.assertTrue(from.isEmpty());
	
		map.addHop(from, to);
		
		Assert.assertTrue(from.isStartingPoint());
		Assert.assertFalse(to.isEmpty());
		
		Assert.assertTrue(to.getIncoming().size() == 1);
		Assert.assertTrue(to.getOutgoing().size() == 0);
		
		Assert.assertTrue(from.getOutgoing().size() == 1);
		Assert.assertTrue(from.getIncoming().size() == 0);
	
		Assert.assertTrue(map.getPoints().size() == 2);
		
		
		List<Hop> hops = map.getHops();
		for(Hop hop: hops) {
			Assert.assertSame(hop.getDistanceType(), DistanceType.METERS);
		}
		
	}
	
	
	
	
}
