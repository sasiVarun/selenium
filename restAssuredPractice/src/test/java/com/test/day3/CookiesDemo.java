package com.test.day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class CookiesDemo {
	
	@Test
	void testCookies() {
		given()
			.log().uri()
		.when()
			.get("https://google.com")
		.then()
		.cookie("AEC","AQTF6Hz1PbjDuLDGUvT7aXWsug6rf0erXUcMI070I4jU_DrYGciGiU65shs") // will fail because cookie will change for every call
		.log().all();
		
	}
	
	@Test
	void getCookiesInfo() {
		Response response = given()
							.when()
								.get("https://google.com");
		String singleCookie = response.getCookie("AEC");
		System.out.println("Cookie: " + singleCookie);
		
		Map<String, String> cookies = response.getCookies();
		
		cookies.forEach((k,v) -> System.out.println(k + " - " + v));
//		response.then().log().all();
	}

}
