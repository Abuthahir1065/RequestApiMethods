package com.atmecs.test.testdata;

import org.testng.annotations.DataProvider;

import com.atmecs.test.constants.FileConstants;
import com.atmecs.test.utilities.JsonReader;
import com.atmecs.test.utilities.PropertyReader;

public class DataProviderClass 
{	
 @DataProvider(name="userData")

public static Object[][] getUserData()
{
	PropertyReader reader=new PropertyReader(FileConstants.DATA_PROPERTIES_PATH);
	String url=reader.get("url");
	
	String name=reader.get("name");
	String job=reader.get("job");
	Object[][] data=new Object[1][3];
	data[0][0]=url;
	
	data[0][1]=name;
	data[0][2]=job;
	
	
	return data;
}

 @DataProvider(name="createUserData")
 public static Object[][] getCreateUserData()
 {
	 JsonReader jsonReader=new JsonReader(FileConstants.JSON_DATA_PATH);
	 Object object=jsonReader.parse();
	 Object[][] data=new Object[1][1];
	 data[0][0]=object;
	 return data;
 } 
}
