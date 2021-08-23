/*

	Copyright (C) 2021 Lago Vista Technologies LLC

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as
    published by the Free Software Foundation, either version 3 of the
    License, or (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
	
*/
package com.lagovistatech;

import java.util.UUID;

public class Helpers {
	public static final byte[] objectToBytes(Object obj) throws Exception {
		if(obj == null)
			return null;

		return (byte[]) obj;
	}
	public static final Boolean objectToBoolean(Object obj) throws Exception {
		if(obj == null)
			return null;

		if(Number.class.isInstance(obj))
			return Long.valueOf(((Number) obj).longValue()) != 0;
		
		if(Boolean.class.isInstance(obj))
			return Boolean.valueOf((boolean) obj);
		
		throw new Exception("Cannot cast '" + obj.getClass().getCanonicalName() + "' to Boolean!");
	}
	public static final Long objectToLong(Object obj) throws Exception {
		if(obj == null)
			return null;
		
		if(Number.class.isInstance(obj))
			return Long.valueOf(((Number) obj).longValue());
		
		throw new Exception("Cannot cast '" + obj.getClass().getCanonicalName() + "' to Long!");
	}
	
	public static final String readResourceAsString(Class<?> cls, String name) throws Exception {
		return new String(cls.getResourceAsStream(name).readAllBytes());
	}
	public static UUID uuidFromString(String guid) {
		//0          1            2         3
		//01234567 8901 2345 6789 012345678901
		//38400000-8cf0-11bd-b23e-10b96e4ef00d
		//07e93800-3af8-4c6a-9901-5528dc8ecdf0
		if(guid.matches("[0-9a-f]{7}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{13}"))
			return UUID.fromString(guid);
		
		if(!guid.matches("[0-9a-f]{32}"))
			return null;
		
		String temp = ""; 
		temp += guid.substring(0, 8) + "-";
		temp += guid.substring(8, 12) + "-";
		temp += guid.substring(12, 16) + "-";
		temp += guid.substring(16, 20) + "-";
		temp += guid.substring(20);
		
		return UUID.fromString(temp);
	}
}
