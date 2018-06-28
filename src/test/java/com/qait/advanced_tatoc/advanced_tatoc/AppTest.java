package com.qait.advanced_tatoc.advanced_tatoc;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class AppTest 
{
	launch_url l_url;
	WebDriver driver;
	hover_menu hovermenu;
	query_gate querygate;
	@BeforeClass
	public void run()
	{
		driver=new ChromeDriver();
		l_url=new launch_url(driver);
		
	}
	@Test
	public void check_whether_url_opens()
	{
		l_url.click_on_advancedcourse();
		
	}
	@Test(dependsOnMethods= {"check_whether_url_opens"})
	public void hovermenu() throws InterruptedException 
	{
		hovermenu=new hover_menu(driver);
		hovermenu.menu();
	}
	@Test(dependsOnMethods= {"hovermenu"})
	public void query_gate() throws ClassNotFoundException, SQLException
	{
		querygate=new query_gate(driver);
		querygate.proceed();
	}
	
}
