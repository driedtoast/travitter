package org.driedtoast.travel.data;

import org.driedtoast.travel.models.DestinationMap;
import org.driedtoast.travel.models.LineType;


public interface MapElementFactory<T> {

	public T createElement(LineType type,DestinationMap map,  String line);
	
}
