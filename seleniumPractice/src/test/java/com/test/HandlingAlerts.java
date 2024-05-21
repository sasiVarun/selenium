package com.test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingAlerts {

	public static void main(String[] args) throws InterruptedException{
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--start-maximized"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
//		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click(); // alert
		
//		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click(); // Confirm
		
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Thread.sleep(3000);
		
		Alert prompt = driver.switchTo().alert();
		prompt.sendKeys("Welcome");
		prompt.accept();
		
		WebDriver driver2 = new ChromeDriver(new ChromeOptions().addArguments("--start-maximized"));
		
		// Normal URL: 'https://the-internet.herokuapp.com/basic_auth'
		// Adding username and password in URL
		// Modified URL: 'https://admin:admin@the-internet.herokuapp.com/basic_auth'
		
		driver2.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
	}

}
