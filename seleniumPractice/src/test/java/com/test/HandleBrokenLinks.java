package com.test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrokenLinks {
	
	public static int brokenLinksCount = 0;
	
	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
//		options.addArguments("--headless");
		options.addArguments("--start-maximized");
		
		WebDriverManager.chromedriver().clearDriverCache().setup();
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://www.deadlinkcity.com/");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total available links in page: " + links.size());
		
		
		
		for(WebElement link : links) {
			verifyLink(link.getAttribute("href"));
		}
		
		System.out.println(brokenLinksCount);
		driver.quit();
	}
	
	public static void verifyLink(String Link) {
		try {
			
			URL url = new URL(Link);
			
			HttpURLConnection httpUrlConnection = (HttpURLConnection)url.openConnection();
			httpUrlConnection.setConnectTimeout(3000);
			httpUrlConnection.connect();
			
			if(httpUrlConnection.getResponseCode() >= 400) {
				System.out.println(httpUrlConnection.getResponseCode() + " " + url + "link is broken");
				brokenLinksCount++;
			} else {
				System.out.println(httpUrlConnection.getResponseCode() + " " + url + "link is valid");
			}
			
		} catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
		
	}

}
