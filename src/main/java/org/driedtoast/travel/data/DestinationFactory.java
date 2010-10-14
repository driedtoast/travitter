package org.driedtoast.travel.data;


import org.driedtoast.travel.models.Destination;
import org.driedtoast.travel.models.DestinationMap;
import org.driedtoast.travel.models.LineType;

/**
 * Creates a destination
 * 
 * @author driedtoast
 *
 */
public class DestinationFactory implements MapElementFactory<Destination> {

	public Destination createElement(LineType type,DestinationMap map, String line) {
		Destination dest = new Destination(line.trim());
		map.addDestination(dest);
		return dest;
	}

	
	
	
}
