package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

import no.hvl.dat110.TODO;

public class RPCUtils {

	// Utility methods for marshalling and marshalling of parameters and return
	// values
	// in RPC request and RPC responses
	// data bytearrays and return byte arrays is according to the
	// RPC message syntax [rpcid,parameter/return value]

	public static byte[] marshallString(byte rpcid, String str) {

		byte[] encoded = new byte[str.length() + 1];
		// TODO: marshall RPC identifier and string into byte array

		// Convert byte[] to String
		encoded[0] = rpcid;
		byte[] temp = str.getBytes(StandardCharsets.UTF_8);
		for (int x = 1; x < encoded.length; x++) {
			encoded[x] = temp[x - 1];
		}

		return encoded;
	}

	public static String unmarshallString(byte[] data) {

		String decoded;

		byte[] temp = new byte[data.length - 1];
		for (int x = 0; x < temp.length; x++) {
			temp[x] = data[x + 1];
		}

		decoded = new String(temp, StandardCharsets.UTF_8);
		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded;

		encoded = new byte[1];
		encoded[0] = rpcid;

		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

		// ???
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int i) {

		byte[] encoded;

		// TODO: marshall RPC identifier and string into byte array

		encoded = new byte[5];
		byte[] temp = new byte[4];
		encoded[0] = rpcid;

		ByteBuffer buf = ByteBuffer.wrap(temp);
		buf.putInt(i);
		for (int x = 0; x < temp.length; x++) {
			encoded[x+1] = temp[x];
		}
		
		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		int decoded;

		// TODO: unmarshall integer contained in data
		byte[] temp = new byte[data.length-1];
		for(int x = 0; x < temp.length; x++) {
			temp[x] = data[x+1];
		}
		
		ByteBuffer buf = ByteBuffer.wrap(temp);
		decoded = buf.getInt();
		return decoded;

	}
}
