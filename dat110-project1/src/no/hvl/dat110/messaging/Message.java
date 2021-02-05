package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		if (payload.length < 128)
			this.payload = payload; // TODO: check for length within boundary

	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload;
	}

	public byte[] encapsulate() {

		byte[] encoded = null;

		// TODO
		// encapulate/encode the payload of this message in the
		// encoded byte array according to message format
		encoded = new byte[128];
		encoded[0] = (byte) payload.length;

		if (encoded.length + 1 >= payload.length) // Could also use payload != null
		{
			for (int x = 0; x < encoded[0]; x++) {
				encoded[x + 1] = payload[x];
			}
		}

		return encoded;

	}

	public void decapsulate(byte[] received) {

		// TODO
		// decapsulate the data contained in the received byte array and store it
		// in the payload of this message
		
			byte[] tempload = new byte[received[0]];
			if (received.length <= 128) {

				for (int x = 0; x < received[0]; x++) {
					tempload[x] = received[x + 1];
				}
				this.payload = tempload;
			} else
				System.err.println("incomming message is greater than 128");
		

	}
}
