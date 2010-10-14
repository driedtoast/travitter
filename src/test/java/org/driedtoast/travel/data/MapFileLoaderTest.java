package org.driedtoast.travel.data;

import java.util.Collection;

import junit.framework.Assert;

import org.driedtoast.travel.models.DestinationMap;
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
		
		
	}
}
