package com.atmecs.test.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class JsonReader {

	String jsonFilePath;

	public JsonReader(String jsonFilePath) {
		
		this.jsonFilePath = jsonFilePath;
	}
	public Object parse()
	{
		JSONParser parser=new JSONParser();
		Object object=null;
		try {
			object=parser.parse(new FileReader(new File(jsonFilePath)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}
}
