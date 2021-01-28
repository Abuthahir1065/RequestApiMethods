package com.atmecs.test.testscripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.atmecs.test.testdata.DataProviderClass;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class PutUserApiTesting {
	@Test(dataProvider="createUserData",dataProviderClass=DataProviderClass.class)

	public void putData(Object requestBody) throws MalformedURLException
	{
		System.out.println("Request Body : "+requestBody);
		String requestUrl="http://localhost:3000/posts/4";
		
		Map<String,Object> headers=new HashMap<String,Object>();
		headers.put("Content-Type","application/json");
		RequestSpecification request=RestAssured.given().headers(headers);
		Response response=request.when().body(requestBody.toString()).put(new URL(requestUrl)).then().extract().response();
		int statusCode=response.getStatusCode();
		System.out.println("Status Code :"+statusCode);
		String responseBody=response.getBody().asString();
		Assert.assertEquals(statusCode, 200);
		JsonPath jsonpath=response.jsonPath();
		String name=jsonpath.getString("name");
		System.out.println("Name : "+name);
		String job=jsonpath.getString("job");
		System.out.println("Job = "+job);
		String id=jsonpath.getString("id");
     	System.out.println("Id : "+id);
		JSONObject jsonObject=(JSONObject) requestBody;
		Assert.assertEquals(name, jsonObject.get("name").toString());
		
	}
}
