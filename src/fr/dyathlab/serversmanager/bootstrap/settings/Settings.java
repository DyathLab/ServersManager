package fr.dyathlab.serversmanager.bootstrap.settings;

public class Settings {
	
	private static int SERVER_PORT = 54300;
	
	static void setPort(int port) {
		SERVER_PORT = port;
	}
	
	public static int getServerPort() {
		return SERVER_PORT;
	}
}
