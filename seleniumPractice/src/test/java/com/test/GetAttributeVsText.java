package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAttributeVsText {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().clearDriverCache().setup();
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://admin-demo.nopcommerce.com/login");
		
//		WebElement email = driver.findElement(By.xpath("//input[normalize-space(@class)='email valid']"));
		WebElement email = driver.findElement(By.xpath("//input[contains(@class,'email')]"));
		email.clear();
		email.sendKeys("admin@gmail.com");
		
		System.out.println("Attribute: " + email.getAttribute("value"));
		System.out.println("Text: " + email.getText());
	}

}
