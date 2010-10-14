package org.driedtoast.travel.data;

import junit.framework.Assert;

import org.driedtoast.travel.models.DestinationMap;
import org.junit.Test;

public class MapFileLoaderTest {

	
	@Test
	public void testInputFile() throws Exception {
		String filename = "/data/simplemap.map";
		MapFileLoader loader = new MapFileLoader();
		DestinationMap map = loader.parse(filename);
		Assert.assertNotNull(map);
		
		// TODO test based on an input file
	}
}
