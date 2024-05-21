package com.test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckDropDownSorted {
	
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.setExperimentalOption("useAutomationExtension", false);
		
		WebDriverManager.chromedriver().clearDriverCache().setup();
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("https://www.orangehrm.com/en/30-day-free-trial/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		WebElement selectElement = driver.findElement(By.xpath("//select[@id='Form_getForm_Country']"));
		
		Select select = new Select(selectElement);
//		select.selectByVisibleText("India");
		List<WebElement> selectOptions = select.getOptions();
		
		ArrayList<String> originalList = new ArrayList<>();
		ArrayList<String> tempList = new ArrayList<>();
		
		for(WebElement option : selectOptions) {
			originalList.add(option.getText());
			tempList.add(option.getText());
		}
		
		Collections.sort(tempList);
		
		System.out.println(originalList);
		System.out.println(tempList);
		
		if(originalList.equals(tempList)) {
			System.out.println("Both are sorted");
		}else {
			System.out.println("Not sorted");
		}
	}

}
