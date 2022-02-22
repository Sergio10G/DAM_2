package Simetrico;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Cifrado {

	private Cipher cipher;
	private SecretKey key;
	
	public Cifrado(String clave) {
		try {
			cipher = Cipher.getInstance("AES");
			byte[] claveEncriptada = clave.getBytes();
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			claveEncriptada = md.digest(claveEncriptada);
			claveEncriptada = Arrays.copyOf(claveEncriptada, 16);
			key = new SecretKeySpec(claveEncriptada, "AES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
	}

	public byte[] encriptar(String msg) {
		try {
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] mensajeCifrado = msg.getBytes();
			mensajeCifrado = cipher.doFinal(mensajeCifrado);
			return mensajeCifrado;
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public byte[] desencriptar(byte[] msg) {
		try {
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] mensajeDescifrado = msg;
			mensajeDescifrado = cipher.doFinal(mensajeDescifrado);
			return mensajeDescifrado;
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public byte[] encriptarObjeto(Object o) {
		try {
			cipher.init(Cipher.ENCRYPT_MODE, key);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(o);
			oos.flush();
			byte[] objetoCifrado = baos.toByteArray();
			objetoCifrado = cipher.doFinal(objetoCifrado);
			return objetoCifrado;
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Object desencriptarObjeto(byte[] cifrado) {
		try {
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] mensajeDescifrado = cipher.doFinal(cifrado);
			ByteArrayInputStream bais = new ByteArrayInputStream(mensajeDescifrado);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
