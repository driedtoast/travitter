package org.driedtoast.travel.util;

import java.io.InputStream;

public class DataUtil {

	
	/**
	 * Get an input stream from class path
	 * @param filename
	 * @return
	 */
	public static InputStream load(String filename) {
		return DataUtil.class.getResourceAsStream(filename);
	}
	
	
}
