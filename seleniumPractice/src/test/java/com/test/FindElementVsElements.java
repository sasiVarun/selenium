package com.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementVsElements {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().clearDriverCache().setup();
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		
		WebElement search = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		WebElement searchButton = driver.findElement(By.xpath("//button[text()[normalize-space()='Search']]"));
		
		List<WebElement> links = driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
		
		System.out.println(links.size());
		
		for(WebElement element:links) {
			System.out.println(element.getText());
		}
	}

}
