package com.qait.advanced_tatoc.advanced_tatoc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class launch_url {

	WebDriver driver;
	launch_url(WebDriver driver)
	{
		this.driver=driver;
	}
	public void get_url()
	{
		driver.get("http://10.0.1.86/tatoc");
		WebElement logo = driver.findElement(By.className("title"));
		Assert.assertTrue(logo.isDisplayed());
	}
	public WebDriver click_on_advancedcourse()
	{
		get_url();
		WebElement link=driver.findElement(By.cssSelector("body > div > div.page > a:nth-child(6)"));
		link.click();
		String expected_url="http://10.0.1.86/tatoc/advanced/hover/menu";
		Assert.assertEquals(expected_url, driver.getCurrentUrl());
		return driver;
	}
	

}