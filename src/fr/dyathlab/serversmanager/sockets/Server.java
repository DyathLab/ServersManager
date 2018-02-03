package fr.dyathlab.serversmanager.sockets;

import java.io.IOException;
import java.net.ServerSocket;

import fr.dyathlab.serversmanager.bootstrap.settings.Settings;

public class Server {
	
	ServerSocket server;
	
	private boolean started = false;
	
	public void start() {
		if (started) {
			System.err.println("Server already started!");
			return;
		}
		try {
			server = new ServerSocket(Settings.getServerPort());
		} catch (IOException e) {
			System.err.println("Cant listen on port " + Settings.getServerPort());
			e.printStackTrace();
		}
		started = true;
		
	}
}
