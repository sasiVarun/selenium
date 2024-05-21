package com.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().clearDriverCache().setup();
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/30-day-free-trial");

		WebElement selectElement = driver.findElement(By.id("Form_getForm_Country"));
		selectFromDropdown(selectElement, "Australia");
//		Select dp = new Select(selectElement);
//		dp.selectByVisibleText("Cuba");

	}

	public static void selectFromDropdown(WebElement element, String value) {

		Select dropDown = new Select(element);
		List<WebElement> allOptions = dropDown.getOptions();
		for (WebElement option : allOptions) {
			if (option.getText().equals(value)) {
				option.click();
				break;
			}
		}
	}

}
