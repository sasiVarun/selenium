package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StatusOfWebElements {
	
	public static void main(String args[]) {
		WebDriverManager.chromedriver().clearDriverCache().setup();
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register");
		
		WebElement search = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		System.out.println("Displaying Status: " + search.isDisplayed());
		System.out.println("Enabled Status: " + search.isEnabled());
		
		WebElement male = driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement female = driver.findElement(By.xpath("//input[@id='gender-female']"));
		
		//isSelected() is applicable on checkboxes, radio button, options of select
		System.out.println(male.isSelected());
		System.out.println(female.isSelected());
		
		male.click();
		
		System.out.println(male.isSelected());
		System.out.println(female.isSelected());
		
		driver.quit();
	}

}
