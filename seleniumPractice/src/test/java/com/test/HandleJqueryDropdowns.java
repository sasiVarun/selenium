package com.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleJqueryDropdowns {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().clearDriverCache().setup();
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("justAnInputBox")).click();
		selectChoiceValues(driver, "choice 1");
//		selectChoiceValues(driver, "choice 2","choice 2 2","choice 2 3");
		selectChoiceValues(driver, "all");

	}

	public static void selectChoiceValues(WebDriver driver, String... values) {
		List<WebElement> choices = driver
				.findElements(By.xpath("//h3[text()='Multi Selection']/parent::div/child::div//span[@class='comboTreeItemTitle']"));

		if (!values[0].equalsIgnoreCase("all")) {
			for(WebElement item: choices) {
				for(String value: values) {
					if(item.getText().equals(value)) {
						item.click();
						break;
					}
				}
			}
		}else {
			for(WebElement item: choices) {
				item.click();
			}
		}
	}

}
