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
package libraries;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lagovistatech.Naming;

public class NamingTest {
	@Test
	public void PluralToSinguluar() {
		assertEquals("cat", Naming.toSingular("cats"));
	}
	@Test
	public void SingularToSingular() {
		assertEquals("cat", Naming.toSingular("cat"));
	}
	@Test
	public void SingularToPlural() {
		assertEquals("cats", Naming.toPlural("cat"));
	}
	@Test
	public void PluralToPlural() {
		assertEquals("cats", Naming.toPlural("cats"));
	}
	
	
	@Test
	public void Constant() {
		assertEquals("HAPPY_DAYS", Naming.toConstant("Happy Days"));
	}
	@Test
	public void CamelCase() {
		assertEquals("HappyDays", Naming.toCamelCase("Happy Days"));
	}
	@Test
	public void LowerCamel() {
		assertEquals("happyDays", Naming.toLowerCamel("Happy Days"));
	}
	@Test
	public void LowerCase() {
		assertEquals("happy_days", Naming.toLowerCase("Happy Days"));
	}
	
	@Test
	public void CamelToConstant() {
		assertEquals("HAPPY_DAYS", Naming.toConstant("HappyDays"));
	}
	@Test
	public void CamelToCamelCase() {
		assertEquals("HappyDays", Naming.toCamelCase("HappyDays"));
	}
	@Test
	public void CamelToLowerCamel() {
		assertEquals("happyDays", Naming.toLowerCamel("HappyDays"));
	}
	@Test
	public void CamelToLowerCase() {
		assertEquals("happy_days", Naming.toLowerCase("HappyDays"));
	}

	
	@Test
	public void GUIDToConstant() {
		assertEquals("CUSTOMER_GUID", Naming.toConstant("Customer GUID"));
	}
	@Test
	public void GUIDToCamelCase() {
		assertEquals("CustomerGuid", Naming.toCamelCase("Customer GUID"));
	}
	@Test
	public void GUIDToLowerCamel() {
		assertEquals("customerGuid", Naming.toLowerCamel("Customer GUID"));
	}
	@Test
	public void GUIDToLowerCase() {
		assertEquals("customer_guid", Naming.toLowerCase("Customer GUID"));
	}

	@Test
	public void CamelGUIDToConstant() {
		assertEquals("CUSTOMER_GUID", Naming.toConstant("CustomerGUID"));
	}
	@Test
	public void CamelGUIDToCamelCase() {
		assertEquals("CustomerGuid", Naming.toCamelCase("CustomerGUID"));
	}
	@Test
	public void CamelGUIDToLowerCamel() {
		assertEquals("customerGuid", Naming.toLowerCamel("CustomerGUID"));
	}
	@Test
	public void CamelGUIDToLowerCase() {
		assertEquals("customer_guid", Naming.toLowerCase("CustomerGUID"));
	}

	@Test
	public void NumberToConstant() {
		assertEquals("CUSTOMER_123_GUID", Naming.toConstant("Customer 123 GUID"));
	}
	@Test
	public void NumberToCamelCase() {
		assertEquals("Customer123Guid", Naming.toCamelCase("Customer 123 GUID"));
	}
	@Test
	public void NumberToLowerCamel() {
		assertEquals("customer123Guid", Naming.toLowerCamel("Customer 123 GUID"));
	}
	@Test
	public void NumberToLowerCase() {
		assertEquals("customer_123_guid", Naming.toLowerCase("Customer 123 GUID"));
	}

	@Test
	public void CamelNumberToConstant() {
		assertEquals("CUSTOMER_GUID_123_ASAP", Naming.toConstant("CustomerGUID123ASAP"));
	}
	@Test
	public void CamelNumberToCamelCase() {
		assertEquals("CustomerGuid123Asap", Naming.toCamelCase("CustomerGUID123ASAP"));
	}
	@Test
	public void CamelNumberToLowerCamel() {
		assertEquals("customerGuid123Asap", Naming.toLowerCamel("CustomerGUID123ASAP"));
	}
	@Test
	public void CamelNumberToLowerCase() {
		assertEquals("customer_guid_123_asap", Naming.toLowerCase("CustomerGUID123ASAP"));
	}
}
