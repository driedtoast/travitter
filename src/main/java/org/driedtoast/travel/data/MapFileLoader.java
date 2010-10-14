package org.driedtoast.travel.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.driedtoast.travel.models.DestinationMap;
import org.driedtoast.travel.models.LineType;
import org.driedtoast.travel.util.DataUtil;

/**
 * Loads a file based on a map routes
 * 
 * @author driedtoast
 *
 */
public class MapFileLoader {

	public Map<LineType, MapElementFactory> factories = new HashMap<LineType, MapElementFactory>();
	
	public MapFileLoader() {
		initialize();
	}
	
	public void initialize() {
		DestinationFactory dfactory = new DestinationFactory();
		factories.put(LineType.End,dfactory);
		factories.put(LineType.Start,dfactory);
		
		RouteFactory rfactory = new RouteFactory();
		factories.put(LineType.Route,rfactory);
	}
	
	
	public DestinationMap parse(String filename) throws IOException {
		
		InputStream stream = DataUtil.load(filename);
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		String line = null;
		while((line = reader.readLine()) != null) {
			System.out.println(" LINE " + line);
		}
		
		
		DestinationMap map = new DestinationMap();
		
		return map;
	
	}
	
	
	
	
}
