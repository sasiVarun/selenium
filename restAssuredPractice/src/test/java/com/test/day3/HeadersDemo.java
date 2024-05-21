package com.test.day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class HeadersDemo {
	@Test
	void testHeaders() {
		given()
			.log().uri()
		.when()
			.get("https://google.com")
		.then()
			.header("Content-Type", equalTo("text/html; charset=ISO-8859-1"))
		.log().all();
	}

}
