package com.atmecs.test.testscripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.atmecs.test.testdata.DataProviderClass;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteUserApiTesting {
	@Test
	public void deleteTestApi() throws MalformedURLException
	{
		String requestUrl="http://localhost:3000/posts/2";
		
		RequestSpecification request=RestAssured.given();
		
		Response response=request.delete(new URL(requestUrl)).then().extract().response();
		
		int statusCode=response.getStatusCode();
		
        
	Assert.assertEquals(statusCode, 200);
	
	System.out.println("Status Code : "+statusCode);
  
		
	
	}
}
