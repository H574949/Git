package no.hvl.dat110.system.controller;

import java.io.IOException;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.RPCClient;
import no.hvl.dat110.rpc.RPCServerStopStub;

public class Controller  {
	
	private static int N = 5;
	
	public static void main (String[] args) throws IOException {
		
		Display display;
		Sensor sensor;
		
		RPCClient displayclient,sensorclient;
		
		System.out.println("Controller starting ...");
				
		RPCServerStopStub stopdisplay = new RPCServerStopStub();
		RPCServerStopStub stopsensor = new RPCServerStopStub();
		
		displayclient = new RPCClient(Common.DISPLAYHOST,Common.DISPLAYPORT);
		sensorclient = new RPCClient(Common.SENSORHOST,Common.SENSORPORT);
		
		// TODO
		// connect to sensor and display RPC servers
		// create local display and sensor objects
		// register display and sensor objects in the RPC layer
		
		displayclient.connect();
		sensorclient.connect();
		
		display = new Display();
		sensor = new Sensor();
		
		displayclient.register(display);
		sensorclient.register(sensor);
		
		
		
		// register stop methods in the RPC layer
		displayclient.register(stopdisplay);
		sensorclient.register(stopsensor);
		
		// TODO:
		// loop while reading from sensor and write to display via RPC
		int x = 1;
		while(x < 6) {
			Integer send = sensor.read();
			String StringSend = send.toString();
			display.write(StringSend);
	
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			x++;
		}
		
		stopdisplay.stop();
		stopsensor.stop();
	
		displayclient.disconnect();
		sensorclient.disconnect();
		
		System.out.println("Controller stopping ...");
		
	}
}
