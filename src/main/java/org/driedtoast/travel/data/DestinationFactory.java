package org.driedtoast.travel.data;


import org.driedtoast.travel.models.Destination;
import org.driedtoast.travel.models.DestinationMap;
import org.driedtoast.travel.models.LineType;

public class DestinationFactory implements MapElementFactory<Destination> {

	public Destination createElement(LineType type,DestinationMap map, String line) {
		Destination dest = new Destination(line);
		map.getDestinations().add(dest);
		return dest;
	}

	
	
	
}
