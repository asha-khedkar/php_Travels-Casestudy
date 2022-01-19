package functionality;

import java.io.File;
import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import object_repository.Elements;
import java.awt.*;
import java.awt.image.BufferedImage;
public class Login {
	@Test
	public void login() throws Throwable {
		System.setProperty("Webdriver.chrome.driver","E:\\Selenium 21\\chromedriver.exe");
		WebDriver driver;

		driver=new ChromeDriver();
		driver.get("https://phptravels.org/login");
		driver.manage().window().maximize();
		driver.getTitle();
        //Thread.sleep(5000);
		
        PageFactory.initElements(driver, Elements.class);
		Elements.inputEmail.sendKeys("khedkarasha18@gmail.com");
		Elements.inputPassword.sendKeys("Asha@123");
		Elements.rememberMe.click();
		((JavascriptExecutor)driver).executeScript("scroll(0,400)");

		Robot robot1=new Robot();
		Dimension sc_size=Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rect=new Rectangle(sc_size);
		BufferedImage Source=robot1.createScreenCapture(rect);
		File destination=new File("A:\\php_screenshot\\Loginscreen.png");
		ImageIO.write(Source, "png", destination);

        Thread.sleep(30000);	
        WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("login")));
		Elements.clickLogin.click();

		Robot robot2=new Robot();
		Dimension sc_size2=Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rect2=new Rectangle(sc_size2);
		BufferedImage Source2=robot2.createScreenCapture(rect2);
		File destination2=new File("A:\\php_screenshot\\clientscreen.png");
		ImageIO.write(Source2, "png", destination2);

		
		}
	}


