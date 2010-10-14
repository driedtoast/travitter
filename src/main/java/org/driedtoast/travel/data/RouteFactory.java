package org.driedtoast.travel.data;

import org.driedtoast.travel.models.DestinationMap;
import org.driedtoast.travel.models.Hop;
import org.driedtoast.travel.models.HopType;
import org.driedtoast.travel.models.LineType;
import org.driedtoast.travel.models.Point;
import org.driedtoast.travel.models.TransitionPoint;

/**
 * 
 * @author driedtoast
 *
 */
public class RouteFactory implements MapElementFactory<TransitionPoint> {

	public TransitionPoint createElement(LineType type, DestinationMap map,
			String line) {
		
		String[] splits = line.split(",");
		TransitionPoint point = new TransitionPoint();
		String marker = splits[0];
		
		point.setName(splits[1]);
		long distance = Long.parseLong(splits[2].trim());
		// TODO set lat and long
		// TODO type 
		Point lastPoint = map.getLastAdded();
		Hop hop = map.getLastHopAdded();
		if(hop != null && hop.getMarker().equals(marker)) {
			hop = map.addHop(lastPoint, point, distance, HopType.CITY);
		} else {
			hop = map.addHop(map.getLastDestinationAdded(), point, distance, HopType.CITY);
		}
		hop.setMarker(marker);
		return point;
	}

}
