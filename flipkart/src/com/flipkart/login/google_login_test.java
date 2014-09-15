package com.flipkart.login;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class google_login_test {
public static WebDriver driver=null;
	
	@Test
public void facebook_login() throws Throwable{
	

	try {
		FileInputStream fp = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\flipkart\\utils\\or.properties");
		Properties prop=new Properties();
		prop.load(fp);
		String s=System.getProperty("user.dir")+"\\src\\com\\flipkart\\utils\\or.properties";
		System.out.println("s value is :" +s);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		driver.findElement(By.xpath(prop.getProperty("login_url"))).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath(prop.getProperty("google_xpath"))).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath(prop.getProperty("google_username"))).sendKeys("exampleapalya@gmail.com");
		driver.findElement(By.xpath(prop.getProperty("google_password"))).sendKeys("apalya01");
		driver.findElement(By.xpath(prop.getProperty("google_password"))).sendKeys(Keys.ENTER);
		Thread.sleep(3000L);
		//driver.findElement(By.xpath(prop.getProperty("facebook_accept_button"))).click();
		
		String name=driver.findElement(By.xpath(prop.getProperty("root_node"))).getText();
		System.out.println(name);
		Assert.assertEquals("Hi Example !", name);
		WebElement rootnode=driver.findElement(By.xpath(prop.getProperty("root_node")));
		Actions act=new Actions(driver);
		act.moveToElement(rootnode).build().perform();
		driver.findElement(By.xpath(prop.getProperty("log_out"))).click();
		//driver.close();
	}catch(Exception e){
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("F:\\workspace\\flipkart\\src\\screen_shots\\google_login.jpg"));
		System.out.println("error"+e.getMessage());
		e.printStackTrace();
}
}
	@AfterMethod
	public void close(){
		driver.close();
	}
}
