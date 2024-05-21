package com.test.day3;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PathAndQueryParameters {
	
	//https://reqres.in/api/users?page=2&id=5
	@Test
	void testQuery() {
		given()
			.pathParam("path", "users") // path parmeters
			.queryParam("page", 2) // query parmeters
			.queryParam("id", 5)	// query parmeters
			.log().uri() // prints URI into log
		.when()
			.get("https://reqres.in/api/{path}")
		.then()
			.statusCode(200)
		.log().all();
	}

}
