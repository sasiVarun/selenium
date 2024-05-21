package com.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingIFrames {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().clearDriverCache().setup();
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--start-maximized"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demoqa.com/nestedframes");
		
		WebElement iframe = driver.findElement(By.xpath("//iframe[@src='/sampleiframe']"));
		
		driver.switchTo().frame(iframe);
		
	}

}
