package no.hvl.dat110.system.controller;

import java.io.IOException;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;

public class Display extends RPCStub {

	private byte RPCID = 1;

	public void write(String message) {

		// TODO
		// implement marshalling, call and unmarshalling for write RPC method
		int temp = Integer.parseInt(message);
		byte[] marshal = RPCUtils.marshallInteger(RPCID, temp);
	
		try {
			rpcclient.call(marshal);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
	}
}
