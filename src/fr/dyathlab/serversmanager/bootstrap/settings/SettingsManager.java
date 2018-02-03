package fr.dyathlab.serversmanager.bootstrap.settings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.esotericsoftware.yamlbeans.YamlConfig;
import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;
import com.sun.corba.se.pept.transport.ContactInfo;

public class SettingsManager {
	
	private File settings;
	private YamlReader reader;
	private YamlWriter writer;
	
	protected SettingsManager(File settings) {
		this.settings = settings;
		init();
		load();
	}
	private void inite() {
		reader = null;
		try {
			reader = new YamlReader(new FileReader(settings));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		writer = null;
		try {
			writer = new YamlWriter(new FileWriter(settings));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private Object get(String key) {
		Object object = null;
		try {
			object = reader.read();
		} catch (YamlException e) {
			e.printStackTrace();
		}
		if (object == null) return null;
		Map<?, ?> map = (Map<?, ?>) object;
		return map.get(key);
	}
	
	private void init() {
		writer = null;
		try {
			writer = new YamlWriter(new FileWriter(settings));
		} catch (IOException e) {
			e.printStackTrace();
		}
		writer.getConfig().setClassTag("settings", Settings.class);
		try {
			writer.write(new DefaultSettings());
		} catch (YamlException e) {
			e.printStackTrace();
		}
		try {
			writer.close();
		} catch (YamlException e) {
			e.printStackTrace();
		}
	}
	private void load() {
		
		if (get("port") == null) init();
		Settings.setPort(Integer.parseInt((String) get("port")));
	}

	
}
