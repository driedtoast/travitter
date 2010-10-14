package org.driedtoast.travel.data;

import java.util.Collection;
import java.util.List;

import junit.framework.Assert;

import org.driedtoast.travel.models.DestinationMap;
import org.driedtoast.travel.models.Hop;
import org.driedtoast.travel.models.Point;
import org.junit.Test;

public class MapFileLoaderTest {

	
	@Test
	public void testInputFile() throws Exception {
		String filename = "/data/simplemap.map";
		MapFileLoader loader = new MapFileLoader();
		DestinationMap map = loader.parse(filename);
		Assert.assertNotNull(map);
		Collection<Point> points = map.getPoints();
		Assert.assertTrue(points.size() > 0);
		
		Point starter = null;
		for(Point pt: points) {
			if(pt.isStartingPoint()) {
				starter = pt;
				// not breaking to make sure there is only one
			}
		}
	
		Assert.assertNotNull(starter);
		System.out.println(starter.getName());
		Assert.assertTrue(starter.getName().equals("ATL"));
		
		List<Hop> hops = starter.getOutgoing();
		Assert.assertTrue(hops.size() == 2);
		
		for(Hop hop:hops) {
			System.out.println(hop.getMarker() + " -> "  + hop.getTarget().getName());
			Assert.assertTrue(hop.getTarget().getOutgoing().size() == 2);	
			long count = followPath(hop.getTarget().getOutgoing(),hop.getMarker());
			System.out.println(" COUNT IS " + count);
			
		}
		
	}
	
	public long followPath(List<Hop> hops,String marker) {
		if(hops.size() == 0 ) { 
			return 0;
		}
		long count = 0;
		for(Hop hop:hops) {
			if(hop.getMarker().equals(marker)) {
				System.out.println(hop.getSource().getName() + " -> "  + hop.getTarget().getName());
				count += followPath(hop.getTarget().getOutgoing(),marker);
				count += hop.getLength();
				break;
			}
			
		}
		return count;
	}
}
