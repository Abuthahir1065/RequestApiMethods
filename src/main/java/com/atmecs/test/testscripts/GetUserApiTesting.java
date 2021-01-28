package com.atmecs.test.testscripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.atmecs.test.testdata.DataProviderClass;
import com.atmecs.test.utilities.PropertyReader;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GetUserApiTesting {

	@Test(dataProvider="userData",dataProviderClass=DataProviderClass.class)
	public void testApi(String url,String name,String job) throws MalformedURLException
	{
		String requestUrl=url;
		
		RequestSpecification request=RestAssured.given();
		
		Response response=request.get(new URL(requestUrl));
		
		int statusCode=response.getStatusCode();
		String body=response.getBody().asString();
		JsonPath jsonPath=response.jsonPath();
		
		String actualName=jsonPath.get("name");
		String actualJob=jsonPath.get("job");
        
	Assert.assertEquals(statusCode, 200,"Verified Status Code");
	Assert.assertEquals(actualName,name);
	Assert.assertEquals(actualJob,job);
	
	
	System.out.println("Status Code : "+statusCode);
  	System.out.println("Response Body : "+body);
  	System.out.println("Name : "+name);
  	System.out.println("Job : "+job);
		
	
	}
}
