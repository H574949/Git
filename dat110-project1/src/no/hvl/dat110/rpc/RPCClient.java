package no.hvl.dat110.rpc;

import java.io.IOException;
import java.net.UnknownHostException;

import no.hvl.dat110.TODO;
import no.hvl.dat110.messaging.*;

public class RPCClient {

	private MessagingClient msgclient;
	private Connection connection;
	
	public RPCClient(String server, int port) {
	
		msgclient = new MessagingClient(server,port);
	}
	
	public void register(RPCStub remote) {
		remote.register(this);
	}
	
	public void connect() throws UnknownHostException, IOException {
		
		// TODO: connect using the underlying messaging layer connection
		connection = msgclient.connect();
					
	}
	
	public void disconnect() {
		
		// TODO: disconnect/close the underlying messaging connection
		connection.close();
		
	}
	
	public byte[] call(byte[] rpcrequest) throws IOException {
		
		byte[] rpcreply;
		/* TODO: 
		
		Make a remote call on the RPC server by sending the RPC request message
		and receive an RPC reply message
		
		rpcrequest is the marshalled rpcrequest from the client-stub
		rpctreply is the rpcreply to be unmarshalled by the client-stub
		
		*/ 
		int rpcid = rpcrequest[0];
		Message msg = new  Message(rpcrequest);
		connection.send(msg);
		
		msg = connection.receive();
		rpcreply = msg.getData();
		return rpcreply;
		
	}

}
