package functionality;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class practice {

	
	@Test
	public static WebElement resgistration() throws Throwable {
		System.setProperty("Webdriver.chrome.driver","E:\\Selenium 21\\chromedriver.exe");
		WebDriver driver;
        
		driver=new ChromeDriver();
		driver.get("https://phptravels.org/register.php");
		driver.manage().window().maximize();
	
        String searchText = "+91";
        WebElement dropdown = driver.findElement(By.xpath("//div[@class=\"selected-dial-code\"]"));
        dropdown.click();
        List<WebElement> options = dropdown.findElements(By.xpath("//span[@class=\"dial-code\"]"));
        for (WebElement option : options)
        {        	
    		if(option.getText().contains(searchText))    
            {    	                	
    	    	System.out.println(option.getSize());
                option.click(); 
                break;
            }
        }
		return dropdown;
				
			
	}
}