package com.github.pixelismania.packetserialisation;

public class PacketSerialiser {
	
	private byte[] packet;
	
	/**
	 * 
	 * This class creates serialised packets that can be sent through data streams
	 * 
	 * @param size The size of the packet which will be turned into a byte array
	 * @param identifier This will help identify the packet when deserialised
	 * @param data All the data that will be included in the packet
	 * 
	 */
	public PacketSerialiser(int size, byte identifier, Object... data) {
		this.packet = new byte[ size ];
		packet[ 0 ] = identifier;
		int index = 1;
		for ( Object dat : data ) {
			String stringed = String.valueOf( dat.getClass().cast( dat ) );
			Class< ? > clas = dat.getClass();
			packet[ index ] = ( byte ) VariableSerialisation.valueOf( ( 
					clas.isPrimitive() ? "PRIMITIVE_" : "" ) + 
					clas.getSimpleName().toUpperCase() ).getIdentifier();
			index++;
			byte[] bytes = stringed.getBytes();
			packet[ index ] = ( byte ) bytes.length;
			for ( byte byt : bytes ) {
				index++;
				packet[ index ] = byt;
			}
			index++;
		}
	}
	
	/**
	 * 
	 * This method will return the serialised packet
	 * 
	 * @return byte[]
	 * 
	 */
	public byte[] getPacket() {
		return this.packet;
	}
	
}
