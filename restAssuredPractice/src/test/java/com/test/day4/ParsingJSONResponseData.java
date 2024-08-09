package com.test.day4;

import org.testng.annotations.Test;

import io.restassured.config.LogConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Iterator;

import org.json.JSONObject;

public class ParsingJSONResponseData {
	@Test
	void testJSONResponse() {
		
		Response response = given()
								.contentType(ContentType.JSON)
								.log().uri()
								.config(config.logConfig(LogConfig.logConfig().blacklistHeader("Content-Type"))	/*Header Blacklisting, hiding sensitive data*/)
							.when()
								.get("https://reqres.in/api/users?page=2");
		
		response.then().log().all();
		
		Integer data = response.jsonPath().get("data[0].id");
		System.out.println(data);
		
		JSONObject res = new JSONObject(response.asString());
		
		for (int i = 0; i < res.getJSONArray("data").length(); i++) {
			
			String id = res.getJSONArray("data").getJSONObject(i).get("id").toString();
			System.out.println(id);
		}
	}

}
