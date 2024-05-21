package com.test.day2;

import static org.hamcrest.Matchers.equalTo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
/*
 Different Ways to Create POST request body
 1. Using HashMap
 2. Using org.json
 3. Using POJO class
 4. Using external file data
 */

public class MultipleWaysToCreatePostRequestBody {

	@Test
	void usingHashMap() {
		HashMap data = new HashMap();
		data.put("id", 101);
		data.put("title", "Testing");
		data.put("body", "HashMap Testing");
		data.put("userId", 1);
		
		String[] courses = {"Java", "JS", "Python"};
		data.put("courses", courses);
		
		RestAssured.given()
						.contentType(ContentType.JSON)
						.body(data)
					.when()
						.post("https://jsonplaceholder.typicode.com/posts")
					.then()
						.statusCode(201)
						.body("id", equalTo(101))
						.body("title", equalTo("Testing"))
						.body("body", equalTo("HashMap Testing"))
						.body("userId", equalTo(1))
						.body("courses[0]", equalTo("Java"))
						.body("courses[1]", equalTo("JS"))
						.body("courses[2]", equalTo("Python"))
						.log().all();
		
	}
	@Test
	void usingJSON() {
		
		JSONObject data = new JSONObject(); // Change in this line
		
		data.put("id", 101);
		data.put("title", "Testing");
		data.put("body", "HashMap Testing");
		data.put("userId", 1);
		
		String[] courses = {"Java", "JS", "Python"};
		data.put("courses", courses);
		
		RestAssured.given()
		.contentType(ContentType.JSON)
		.body(data.toString())	// Change in this line
		.when()
		.post("https://jsonplaceholder.typicode.com/posts")
		.then()
		.statusCode(201)
		.body("id", equalTo(101))
		.body("title", equalTo("Testing"))
		.body("body", equalTo("HashMap Testing"))
		.body("userId", equalTo(1))
		.body("courses[0]", equalTo("Java"))
		.body("courses[1]", equalTo("JS"))
		.body("courses[2]", equalTo("Python"))
		.log().all();
		
	}
	
	@Test
	public void usingPOJO() {
		POJORequest req = new POJORequest();
		
		req.setName("Deepak");
		req.setLocation("HYD");
		req.setPhone("54343");
		req.setCourses(new String[] {"Java", "JS", "Python"});
		
		RestAssured.given()
						.contentType(ContentType.JSON)
						.body(req)
					.when()
						.post("https://jsonplaceholder.typicode.com/posts")
					.then()
						.statusCode(201)
						.body("name", equalTo("Deepak"))
						.body("location", equalTo("HYD"))
						.body("phone", equalTo("54343"))
						.body("courses[0]", equalTo("Java"))
						.body("courses[1]", equalTo("JS"))
						.body("courses[2]", equalTo("Python"))
					.log().all();
	}
	
	@Test
	void usingJsonFile() throws FileNotFoundException {
		
		FileReader file = new FileReader("./src/test/resources/templates/jsonBody.json");
		JSONTokener token = new JSONTokener(file);
		JSONObject data = new JSONObject(token);
		
		RestAssured.given()
						.contentType(ContentType.JSON)
						.body(data.toString())
					.when()
						.post("https://jsonplaceholder.typicode.com/posts")
					.then()
						.statusCode(201)
						.body("name", equalTo("Mahima"))
						.body("location", equalTo("BNGLR"))
						.body("phone", equalTo("56000"))
						.body("courses[0]", equalTo("Java"))
						.body("courses[1]", equalTo("JS"))
						.body("courses[2]", equalTo("Python"))
					.log().all(true);
	}
}
