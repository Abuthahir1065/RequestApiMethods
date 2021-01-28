package com.atmecs.test.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	Properties property;

	public PropertyReader(String filePath) {
		property = new Properties();
        try {
			property.load(new FileInputStream(new File(filePath)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String get(String key)
	{
		return property.getProperty(key);
	}
}
