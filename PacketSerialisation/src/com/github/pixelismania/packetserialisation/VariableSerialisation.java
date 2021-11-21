package com.github.pixelismania.packetserialisation;

public enum VariableSerialisation {
	
	STRING,
	PRIMITIVE_INT,
	INTEGER,
	PRIMITIVE_BYTE,
	BYTE,
	PRIMITIVE_SHORT,
	SHORT,
	PRIMITIVE_LONG,
	LONG,
	PRIMITIVE_FLOAT,
	FLOAT,
	PRIMITIVE_DOUBLE,
	DOUBLE,
	PRIMITIVE_BOOLEAN,
	BOOLEAN,
	CHAR;
	
	private int identifier;
	
	static {
		
		STRING.identifier = 1;
		PRIMITIVE_INT.identifier = 2;
		INTEGER.identifier = 3;
		PRIMITIVE_BYTE.identifier = 4;
		BYTE.identifier = 5;
		PRIMITIVE_SHORT.identifier = 6;
		SHORT.identifier = 7;
		PRIMITIVE_LONG.identifier = 8;
		LONG.identifier = 9;
		PRIMITIVE_FLOAT.identifier = 10;
		FLOAT.identifier = 11;
		PRIMITIVE_DOUBLE.identifier = 12;
		DOUBLE.identifier = 13;
		PRIMITIVE_BOOLEAN.identifier = 14;
		BOOLEAN.identifier = 15;
		CHAR.identifier = 16;
		
	}
	
	/**
	 * 
	 * This method will return the variable type identifier
	 * 
	 * @return int
	 * 
	 */
	public int getIdentifier() {
		return this.identifier;
	}
	
	/**
	 * 
	 * This method will deserialise the provided variable type
	 * 
	 * @param variableType The variable type identifier that will be used to deserialise
	 * @return java.lang.Object<h1>null will be returned if variable type is invalid</h1>
	 * 
	 */
	public static Object deserialise(int variableType, byte[] variableData) {
		String stringed = new String( variableData );
		switch ( variableType ) {
		case 1 : {
			return stringed;
		}
		case 2 : {
			return ( int ) Integer.valueOf( stringed );
		}
		case 3 : {
			return Integer.valueOf( stringed );
		}
		case 4 : {
			return ( byte ) Byte.valueOf( stringed );
		}
		case 5 : {
			return Byte.valueOf( stringed );
		}
		case 6 : {
			return ( short ) Short.valueOf( stringed );
		}
		case 7 : {
			return Short.valueOf( stringed );
		}
		case 8 : {
			return ( long ) Long.valueOf( stringed );
		}
		case 9 : {
			return Long.valueOf( stringed );
		}
		case 10 : {
			return ( float ) Float.valueOf( stringed );
		}
		case 11 : {
			return Float.valueOf( stringed );
		}
		case 12 : {
			return ( double ) Double.valueOf( stringed );
		}
		case 13 : {
			return Double.valueOf( stringed );
		}
		case 14 : {
			return ( boolean ) Boolean.valueOf( stringed );
		}
		case 15 : {
			return Boolean.valueOf( stringed );
		}
		case 16 : {
			return ( char ) stringed.charAt( 0 );
		}
		default: return null;
		}
	}
	
}
