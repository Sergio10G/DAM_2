package Asimetrico;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Cifrado {
	private Cipher cipher;
	private PrivateKey prikey;
	private PublicKey pubkey;

	public Cifrado(String clave) {
		try {
			cipher = Cipher.getInstance("RSA");
			KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
			KeyPair kp = kpg.generateKeyPair();
			prikey = kp.getPrivate();
			pubkey = kp.getPublic();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
	}

	public byte[] encriptar(String mensaje) {
		try {
			cipher.init(Cipher.ENCRYPT_MODE, pubkey);
			byte[] cifrado = cipher.doFinal(mensaje.getBytes());
			return cifrado;
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String desencriptar(byte[] msg) {
		try {
			cipher.init(Cipher.DECRYPT_MODE, prikey);
			byte[] mensajeDescifrado = msg;
			mensajeDescifrado = cipher.doFinal(mensajeDescifrado);
			return new String(mensajeDescifrado);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
