package ru.specialist;

import java.io.Closeable;
import java.io.IOException;

/*
 *	1. Create object
 *  2. Init object (including link with another object)
 *  3. Control lifetime
 */
public class Container implements Closeable {
	
	private House house = null;
	
	public House getWoodHouse() {
		if (house == null) {
			WoodFrameWindow woodWnd = new WoodFrameWindow ();
			house = new House(woodWnd);
		}
		return house;
	}

	@Override
	public void close() {
		if (house instanceof Closeable)
			house.close();
		house = null;
	}

}
