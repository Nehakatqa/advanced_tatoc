package com.qait.advanced_tatoc.advanced_tatoc;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class query_gate {
WebDriver driver;
query_gate(WebDriver driver)
{
	this.driver=driver;
}
void connection_establish() throws SQLException, ClassNotFoundException
{
	
	String url="jdbc:mysql://10.0.1.86/tatoc";
	String username="tatocuser";
	String password="tatoc01";
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection(url,username,password);
	Statement statement=con.createStatement();
	WebElement symbol=driver.findElement(By.id("symboldisplay"));
	String get_symbol=symbol.getText();
	ResultSet rs=statement.executeQuery("Select name,passkey,symbol from identity inner join credentials on identity.id=credentials.id");
	
	WebElement Name=driver.findElement(By.id("name"));
	WebElement Passkey=driver.findElement(By.id("passkey"));
	while(rs.next())
	{
		String get_Symb=rs.getString("symbol");	
		String get_Name=rs.getString("name");
		String get_PassKey=rs.getString("passkey");
		System.out.println(get_Name);
		if(get_symbol.equalsIgnoreCase(get_Symb))
		{
		System.out.println(get_PassKey);
		Name.sendKeys(get_Name);
		Passkey.sendKeys(get_PassKey);
		}
	}
}

void proceed() throws ClassNotFoundException, SQLException
{
	connection_establish();
	driver.findElement(By.id("submit")).click();
	
	String expected_url="http://10.0.1.86/tatoc/advanced/query/gate";
	Assert.assertEquals(expected_url, driver.getCurrentUrl());
	
}
}

