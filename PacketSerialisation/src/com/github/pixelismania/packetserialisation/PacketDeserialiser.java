package com.github.pixelismania.packetserialisation;

import java.util.ArrayList;
import java.util.List;

public class PacketDeserialiser {
	
	private int identifier;
	private List< Object > variables = new ArrayList< Object >();
	
	/**
	 * 
	 * This class deserialises a serialised packet
	 * 
	 * @param packet The packet that will be deserialised
	 * 
	 */
	public PacketDeserialiser(byte[] packet) {
		this.identifier = packet[ 0 ];
		boolean serialising = false;
		byte[] bytes = null;
		int variableType = 0;
		int currentIndex = 0;
		for ( int index = 1; index < packet.length; index++ ) {
			if ( !serialising ) {
				serialising = true;
				bytes = null;
				variableType = packet[ index ];
				currentIndex = 0;
			} else {
				if ( packet[ index ] == 0 ) {
					return;
				} else {
					if ( bytes == null ) {
						bytes = new byte[ packet[ index ] ];
					} else {
						bytes[ currentIndex ] = packet[ index ];
						currentIndex++;
						if ( currentIndex == bytes.length ) {
							serialising = false;
							this.variables.add( VariableSerialisation.deserialise( variableType, bytes ) );
						}
					}
				}
			}
		}
	}
	
	/**
	 * 
	 * This method returns the identifier of the packet
	 * 
	 * @return int
	 * 
	 */
	public int getIdentifier() {
		return this.identifier;
	}
	
	/**
	 * 
	 * This method returns the deserialised content of the packet
	 * 
	 * @return List< Object >
	 * 
	 */
	public List< Object > getVariables() {
		return this.variables;
	}
	
}
