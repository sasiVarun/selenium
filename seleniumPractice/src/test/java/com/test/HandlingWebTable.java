package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingWebTable {
	
	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		
		WebDriverManager.chromedriver().clearDriverCache().setup();
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
		int rowCount = driver.findElements(By.xpath("//table[@id='customers']//tr[child::td]")).size();
		
		int columnCount = driver.findElements(By.xpath("//table[@id='customers']//th")).size();
		
		System.out.println("Row Count: " + rowCount);
		System.out.println("Column Count: " + columnCount);
		
		for(int r=1 ; r<=rowCount; r++) {
			
			for(int c=1; c<columnCount; c++) {
				String data = driver.findElement(By.xpath("//table[@id='customers']//tr[child::td]["+r+"]/td["+c+"]")).getText();
				System.out.print(data + " ");
			}
			System.out.println("\n-----------------------------------");			
		}
		
		for(int r=1; r<=rowCount; r++) {
			
			String find = driver.findElement(By.xpath("//table[@id='customers']//tr[child::td]["+r+"]/td[1]")).getText();
			
			if(find.equals("Microsoft")) {
				String contact = driver.findElement(By.xpath("//table[@id='customers']//tr[child::td]["+r+"]/td[2]")).getText();
				String country = driver.findElement(By.xpath("//table[@id='customers']//tr[child::td]["+r+"]/td[3]")).getText();
				System.out.println("Contact: " + contact);
				System.out.println("Country: " + country);
			}
		}
	}

}
