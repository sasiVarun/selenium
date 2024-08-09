package com.test.day1;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;



/*
Static import below 3 packages
	io.restassured.RestAssured.*
	io.restassured.matcher.RestAssuredMatchers.*
	org.hamcrest.Matchers.*

given()
	content type, set cookies, add auth, add param, set headers info etc...
when()
	get, post, put, delete
then()
	validate status code, extract response, extract headers cookies & response body... 
*/
public class HttpRequests {
	
	// Printing ResponseBody
	@Test
	void getUser() {
		Response response = given()
							.when()
							.get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.getBody().asPrettyString());
	}
	
	// Printing log
	@Test
	void getUser1() {
		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("page", equalTo(2))
			.log().all();
		
	}
	
	// Post Operation
	@Test
	void createUser() {
		HashMap data = new HashMap();
		
		data.put("name", "Sanjay");
		data.put("job", "QA");
		
		given()
			.contentType(ContentType.JSON)
			.body(data)
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201)
			.log().all();
	}
	// Print data from Post response
	@Test
	void createUserFetch() {
		HashMap data = new HashMap();
		
		data.put("name", "Ajay");
		data.put("job", "DEV");
		
		String id = given()
				.contentType(ContentType.JSON)
				.body(data)
			.when()
			.post("https://reqres.in/api/users")
				.jsonPath().get("id");
		
		System.out.println("Id: " + id);
	}
}
