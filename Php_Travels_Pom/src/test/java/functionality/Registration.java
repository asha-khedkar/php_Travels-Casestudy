package functionality;

import java.util.Iterator;

import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import object_repository.Elements;

public class Registration {

	@Test
	public void resgistration() throws Throwable {
		System.setProperty("Webdriver.chrome.driver","E:\\Selenium 21\\chromedriver.exe");
		WebDriver driver;
        		driver=new ChromeDriver();
		driver.get("https://phptravels.com/demo/");
		driver.manage().window().maximize();
		String w1=driver.getTitle();
        Thread.sleep(5000);
        
        //Login button on Home Page of php
		Elements.login_Button(driver).click();

		//move to the Tabbed window
		Set<String> windows=driver.getWindowHandles();
		
		Iterator<String> iter=windows.iterator();
		String window1=iter.next();
		String window2=iter.next();
        driver.switchTo().window(window2);
		String w2=driver.getTitle();
		
		
		//Get the Title of window
		System.out.println(w1);
		System.out.println(w2);	        
     		
		//get the session ID of window
		System.out.println(window1);
		System.out.println(window2);
					
		Elements.registration_Button(driver).click();
		Elements.first_Name(driver).sendKeys("Asha");
		Elements.last_Name(driver).sendKeys("khedkar");
		Elements.email_ID(driver).sendKeys("khedkarasha18@gmail.com");
		
		//clicking on dropdown and getting contry dial code
		Elements.contry_code(driver);
		
		Elements.phone(driver).sendKeys("9561601992");
		Elements.company_Name(driver).sendKeys("HCL");
		Elements.address1(driver).sendKeys("Magarpatta sez Entrance");
		Elements.address2(driver).sendKeys("Magarpatta City");
		Elements.city(driver).sendKeys("Pune");
		Elements.state(driver).sendKeys("Maharashtra");
		Elements.postalcode(driver).sendKeys("411028");
		Elements.country(driver).sendKeys("India");
		Elements.mobNo(driver).sendKeys("93091364");
		Elements.password1(driver).sendKeys("Asha@123");
		Elements.password2(driver).sendKeys("Asha@123");
		Elements.recive_Email(driver).click();	
	
		Robot robot1=new Robot();
		Dimension sc_size=Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rect=new Rectangle(sc_size);
		BufferedImage Source=robot1.createScreenCapture(rect);
		File destination=new File("A:\\php_screenshot\\Registrationscreen.png");
		ImageIO.write(Source, "png", destination);

		((JavascriptExecutor)driver).executeScript("scroll(0,1200)");
		//click on I am not Robot manually to handle recaptcha
        Thread.sleep(20000);
		
		Elements.register(driver).click();
		
	}
	
	
}











/*
 * WebDriverWait wait=new WebDriverWait(driver,20);
 * wait.until(ExpectedConditions.
 * elementToBeClickable(By.id("//input[@type=\"submit\"]")));
 */ 

