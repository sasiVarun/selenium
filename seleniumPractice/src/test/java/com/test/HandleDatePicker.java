package com.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDatePicker {
	
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--incognito");
		options.addArguments("--disable-notifications");
		
		WebDriverManager.chromedriver().clearDriverCache().setup();
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		
		driver.findElement(By.xpath("//input[@name='departon']")).click();
		
		WebElement monthSelect = driver.findElement(By.xpath("//*[@class='ui-datepicker-month']"));
		WebElement yearSelect = driver.findElement(By.xpath("//*[@class='ui-datepicker-year']"));
		
		selectDropdown(yearSelect,"2024");
		selectDropdown(monthSelect,"Aug");
		
		List<WebElement> elements = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody//td"));
		
		selectDate(driver, elements, 7);
	}
	
	public static void selectDropdown(WebElement element, String selectValue) {
		Select select = new Select(element);
		
		select.selectByVisibleText(selectValue);
	}
	
	public static void selectDate(WebDriver driver, List<WebElement> elements, int value) {
		for(WebElement ele: elements) {
			if(ele.getText().equals(String.valueOf(value))) {
				ele.click();
			}
		}
	}

}
