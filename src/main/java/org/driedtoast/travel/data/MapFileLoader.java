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
	
	
	public void processLine(DestinationMap map, String line) {
		String[] splits = line.split(":");
		String type = splits[0];
		LineType ltype = LineType.valueOf(type);
		MapElementFactory factory = this.factories.get(ltype);
		String rest = splits[1];
		factory.createElement(ltype, map, rest);
	}

	/**
	 * Process the file 
	 * 
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public DestinationMap parse(String filename) throws IOException {
		InputStream stream = DataUtil.load(filename);
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		String line = null;
		DestinationMap map = new DestinationMap();
		while((line = reader.readLine()) != null) {
			this.processLine(map, line);
		}
		return map;
	}
	
	
	
	
}
