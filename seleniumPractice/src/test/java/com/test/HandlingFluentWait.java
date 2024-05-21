package com.test;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingFluentWait {
	
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		
		WebDriverManager.chromedriver().clearDriverCache().setup();
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://google.com/");
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
//		Wait<WebDriver> wait = new FluentWait<>(driver)
//				.withTimeout(Duration.ofSeconds(10))
//				.pollingEvery(Duration.ofSeconds(2))
//				.ignoring(NoSuchElementException.class);
//		
//		WebElement ele = wait.until((x) -> x.findElement(By.xpath("//h3[text()='Selenium']")));
//		ele.click();
		
		By locator = By.xpath("//h3[text()='Selenium']");
		
		waitForFluent(driver, locator, 20, 4).click();
		
	}
	
	public static WebElement waitForFluent(WebDriver driver, By locator, int timeOutDuration, int pollingTime) {
		
		Wait<WebDriver> wait = new FluentWait<>(driver)
									.withTimeout(Duration.ofSeconds(timeOutDuration))
									.pollingEvery(Duration.ofSeconds(pollingTime))
									.ignoring(NoSuchElementException.class);
		
		return wait.until(drv -> drv.findElement(locator));
		
	}

}
