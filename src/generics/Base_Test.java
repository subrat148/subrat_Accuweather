package generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base_Test implements AutoConstant 
{
	public WebDriver driver;
	  
	  @BeforeMethod
	  public void openApplication()
	  {
		  System.setProperty(chrome_key, chrome_value);
		  driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  driver.get(url);
		 
	  }
	  
	  @AfterMethod
	  public void closeApplication()
	  {
		  driver.close();	  
	  }	

}
