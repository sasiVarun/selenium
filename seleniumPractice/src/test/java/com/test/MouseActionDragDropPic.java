package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseActionDragDropPic {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='demo-frame lazyloaded']")));

		WebElement image1 = driver.findElement(By.xpath("//li[1]"));
		WebElement image2 = driver.findElement(By.xpath("//li[2]"));
		WebElement trash = driver.findElement(By.id("trash"));

		Actions action = new Actions(driver);
		action.dragAndDrop(image1, trash)
			  .dragAndDrop(image2, trash)
			  .perform();
	}

}
