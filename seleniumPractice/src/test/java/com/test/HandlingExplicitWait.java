package com.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingExplicitWait {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().clearDriverCache().setup();
		WebDriverManager.chromedriver();
		
		WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--incognito"));
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()='Selenium']")));
//		ele.click();
		By locator = By.xpath("//h3[text()='Selenium']");
		waitForExplicit(driver, locator, 10).click();
	}
	
	public static WebElement waitForExplicit(WebDriver driver, By locator, int duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

}
