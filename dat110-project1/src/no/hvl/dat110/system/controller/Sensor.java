package no.hvl.dat110.system.controller;

import java.io.IOException;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;

public class Sensor extends RPCStub {

	private byte RPCID = 1;

	public int read() {

		int temp;

		// TODO
		// implement marshalling, call and unmarshalling for read RPC method
		byte[] req = new byte[1];
		byte[] rep = null;
		req[0] = RPCID;
		try {
			rep = rpcclient.call(req);
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp = RPCUtils.unmarshallInteger(rep);
		return temp;
	}

}
