package fr.dyathlab.serversmanager.sockets;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
	
	ServerSocket server;
	
	private boolean started = false;
	
	public void start() {
		if (started) {
			System.err.println("Server already started!");
			return;
		}
		try {
			server = new ServerSocket(0);
		} catch (IOException e) {
			System.err.println("Cant listen on port " + 0);
			e.printStackTrace();
		}
		started = true;
		
	}
}
