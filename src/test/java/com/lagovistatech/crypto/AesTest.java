package com.lagovistatech.crypto;

import static org.junit.jupiter.api.Assertions.*;


import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.junit.jupiter.api.Test;

public class AesTest {

//	@BeforeAll
//	static void setUpBeforeClass() throws Exception {
//	}
//
//	@AfterAll
//	static void tearDownAfterClass() throws Exception {
//	}

	@Test
	public void Encrypt_Decrypt() throws Exception {
		String msg = "Testing 123! Hello World!";
		
		byte[] key = java.security.SecureRandom.getSeed(256/8);
	    SecretKey sk = new SecretKeySpec(key, "AES");
		
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, sk);
		byte[] encrypted = cipher.doFinal(msg.getBytes());

		cipher.init(Cipher.DECRYPT_MODE, sk);
		String decrypted = new String(cipher.doFinal(encrypted));
		
		assertEquals(msg, decrypted);
	}
}
