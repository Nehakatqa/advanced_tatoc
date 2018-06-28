package com.qait.advanced_tatoc.advanced_tatoc;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
public class hover_menu {

		WebDriver driver;
		hover_menu(WebDriver driver)
		{
			this.driver=driver;
		}
		
		public void menu() throws InterruptedException
		{
			//driver.get("http://10.0.1.86/tatoc/advanced/hover/menu");
			
			WebElement element =driver.findElement(By.cssSelector("body > div > div.page > div.menutop.m2"));
			//WebElement subelement=driver.findElement(By.cssSelector("body > div > div.page > div.menutop.m2 > span:nth-child(5)"));
			WebElement subelement = driver.findElement(By.cssSelector(".menutop.m2 span:nth-child(5)"));
			System.out.println(element.getText());   
			Actions action=new Actions(driver);
			action.moveToElement(element).perform();
			subelement.click();
			System.out.println(driver.getCurrentUrl());
			String expected_url="http://10.0.1.86/tatoc/advanced/query/gate";
			Assert.assertEquals(expected_url, driver.getCurrentUrl());
		}
		
		}
	


