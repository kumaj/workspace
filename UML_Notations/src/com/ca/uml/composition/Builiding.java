package com.ca.uml.composition;

import java.util.List;

/**
 * Building class is an composition of Room classes. It means if building class doesn't exist then room will also not exist.
 * See the UML diagram, how it has been depicted in the UML diagram.
 * @author kumaj04
 *
 */
public class Builiding {
	
	List<Rooms> roomsList;
	public String buildingName() {
		return "APPLE";
	}
}
