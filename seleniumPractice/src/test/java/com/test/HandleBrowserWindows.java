package com.test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrowserWindows {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		
		WebDriverManager.chromedriver().clearDriverCache().setup();
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		Set<String> windowsId = driver.getWindowHandles();
		
		/*
		 * Iterator<String> it = windowsId.iterator();
		 * 
		 * while(it.hasNext()) { String windowId = it.next();
		 * System.out.println(windowId); System.out.println("Window ID: " + windowId);
		 * String title = driver.switchTo().window(windowId).getTitle();
		 * System.out.println("Page Title: " + title);
		 * 
		 * }
		 */
		
		List<String> windowList = new ArrayList<>(windowsId);
		
		System.out.println(windowList.size());
		
		for(String window : windowList) {
			String id = window;
			System.out.println("Window ID: "+id);
			System.out.println("Page Title: " + driver.switchTo().window(id).getTitle());
		}
		
		driver.close(); //closes current window
//		driver.quit(); // closes all opened windows
		
	}

}
