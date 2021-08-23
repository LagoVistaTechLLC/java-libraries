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

import org.atteo.evo.inflector.English;

public class Naming {
	private enum Status {
		LOWER, UPPER, SPACE, NUMBER
	}
	
	public static String toConstant(String original) {
		return toLowerCase(original).toUpperCase();
	}
	public static String toCamelCase(String original) {
		String[] tokens = getLowercaseTokens(original);
		
		String ret = "";
		for(String token : tokens)
			for(int cnt = 0; cnt < token.length(); cnt++)
				if(cnt == 0)
					ret = ret + Character.toUpperCase(token.charAt(cnt));
				else
					ret = ret + token.charAt(cnt);
		
		return ret;		
	}
	public static String toLowerCamel(String original) {
		String[] tokens = getLowercaseTokens(original);
		
		String ret = "";
		for(String token : tokens)
			for(int cnt = 0; cnt < token.length(); cnt++)
				if(cnt == 0 && ret.length() != 0)
					ret = ret + Character.toUpperCase(token.charAt(cnt));
				else
					ret = ret + token.charAt(cnt);
		
		return ret;				
	}
	public static String toLowerCase(String original) {
		String[] tokens = getLowercaseTokens(original);
		
		String ret = "";
		for(String token : tokens) {
			if(ret.length() > 0)
				ret = ret + "_";
			ret = ret + token;
		}
		
		return ret;	
	}
	
	public static String toSingular(String original) {
		return com.hypertino.inflector.English.singular(original);
	}
	public static String toPlural(String original) {
		if(original.equals(toSingular(original)))
			return English.plural(original);
		else
			return original;
	}

	public static String[] getLowercaseTokens(String original) {
		String stripped = original.replaceAll("[^[a-zA-Z0-9]]+", " ");

		Status lastStatus = null;
		String temp = "";
		for(int cnt = 0; cnt < stripped.length(); cnt++) {
			char current = stripped.charAt(cnt);
			Status currentStatus = getStatus(current);
			if(
				(currentStatus == Status.UPPER && lastStatus == Status.LOWER)
				|| (currentStatus != Status.NUMBER && lastStatus == Status.NUMBER)
				|| (currentStatus == Status.NUMBER && lastStatus != Status.NUMBER)
			)
				temp = temp + " ";

			temp = temp + current;
			lastStatus = currentStatus;
		}
		
		return temp.trim().toLowerCase().split("\\s+");
	}
	public static Status getStatus(char current) {
		if(Character.isLowerCase(current))
			return Status.LOWER;
		if(Character.isUpperCase(current))
			return Status.UPPER;
		if(Character.isDigit(current))
			return Status.NUMBER;
		if(Character.isWhitespace(current))
			return Status.SPACE;
		
		return null;
	}
}
