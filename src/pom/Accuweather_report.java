package pom;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generics.AutoConstant;
import generics.Base_Page;
import generics.Excel_Library;

public class Accuweather_report extends Base_Page implements AutoConstant 
{

	 @FindBy(xpath="//span[contains(text(), 'This site can’t be reached')]")
	 private WebElement pageLoadError;
	
	 @FindBy(xpath="//img[@alt='AccuWeather']")
	 private WebElement accuWeatherText;

	 @FindBy(xpath="//input[@type='text']")
	 private WebElement searchBox;
	 
	 @FindBy(xpath="(//div[@class='searchbar-content']//*[local-name()='svg'])[1]")
	 private WebElement searchButton;
	   
	 @FindBy(xpath="//span[.='(189781)']")
	 private WebElement location;
	 
	 @FindBy(xpath="//div[@data-qa='tomorrowWeatherCard']//div[@class='temp']")
	 private WebElement tomorrowWeatherButton;
	
	 @FindBy(xpath="(//span[@class='high'])[3]")
	 private WebElement futureweatherForecast;
	 
	 @FindBy(xpath="(//a[@data-gatext='AccuWeather APIs'])[2]")
	 private WebElement apiLink;
	 
	 @FindBy(xpath="//a[.='Login']")
	 private WebElement loginLink;
	 
	 @FindBy(id="edit-name")
	 private WebElement usernameField;
	 
	 @FindBy(id="edit-pass")
	 private WebElement passwordField;
	 
	 @FindBy(id="edit-submit")
	 private WebElement loginButton;
	
	 @FindBy(xpath="(//a[.='API Reference'])[1]")
	 private WebElement apiReferenceButton;
	 
	 @FindBy(xpath="//a[.='Forecast API']")
	 private WebElement forecastApiButton;
	 
	 @FindBy(xpath="//a[.='5 Days of Daily Forecasts']")
	 private WebElement fiveDaysForescast;
	 
	 @FindBy(css="span[class='template_param']")
	 private WebElement locationKey;
	 
	 @FindBy(xpath="//input[@name='apikey']")
	 private WebElement apiKeyField;
	 
	 @FindBy(xpath="//input[@name='metric']")
	 private WebElement metricField;
	 
	 @FindBy(id="send_request")
	 private WebElement sendRequestButton;
	 
	 @FindBy(xpath="//*[@id=\"some-code123\"]/span[170]")
	 private WebElement futureTempApiResponse;
	 public Accuweather_report(WebDriver driver)
		{
		   this.driver=driver;
		   PageFactory.initElements(driver, this);
		}
	 public void reportCheckMethod()
	 {
		 try {
			 WebDriverWait wait= new WebDriverWait(driver,20);
			 wait.until(ExpectedConditions.visibilityOf(accuWeatherText));
			 accuWeatherText.isDisplayed();
			 System.out.println("Application is opened");
		 }
		catch(Throwable exp){
			pageLoadError.isDisplayed();
			System.out.println("Application is not opened");
			System.out.println(exp);
		 }
		 
		 try {
			 WebDriverWait wait= new WebDriverWait(driver,20);
			 wait.until(ExpectedConditions.visibilityOf(searchBox));
			 searchBox.isDisplayed();
			 System.out.println("Search textfield is present");
		 }
		catch(Throwable exp){
			pageLoadError.isDisplayed();
			System.out.println("Search textfield is not present");
			System.out.println(exp);	
		 }
		 try {
			 WebDriverWait wait= new WebDriverWait(driver,20);
			 wait.until(ExpectedConditions.visibilityOf(searchBox));
			 
			 searchBox.sendKeys(Excel_Library.getcellvalue(sheet_path, sheet_name, 1, 1));
			System.out.println("Location is entered.");
		 }
		catch(Throwable exp){
			System.out.println("Location is not entered.");
			System.out.println(exp);	
		 }
		 try {
			 WebDriverWait wait= new WebDriverWait(driver,20);
			 wait.until(ExpectedConditions.visibilityOf(searchButton));
			 searchButton.click();
			 System.out.println("Button clicked.");
		 }
		catch(Throwable exp){
			System.out.println("Button not clicked.");
			System.out.println(exp);	
		 }
		 try {
			 WebDriverWait wait= new WebDriverWait(driver,20);
			 wait.until(ExpectedConditions.visibilityOf(location));
			 location.click();
			 driver.navigate().refresh();
			 
			 wait.until(ExpectedConditions.visibilityOf(location));
			 location.click();
			 System.out.println("Locations are showing.");
		 }

		 catch(Throwable exp){
			 System.out.println("Location are not showing.");
			 System.out.println(exp);	
		 }
		 
			 WebDriverWait wait1= new WebDriverWait(driver,10);
			 wait1.until(ExpectedConditions.visibilityOf(tomorrowWeatherButton));
			 String text=tomorrowWeatherButton.getText();
			 System.out.println(text);
			 System.out.println("Tommorow's weather is" + text);
		 
		 try {
			 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", apiLink);
			 WebDriverWait wait= new WebDriverWait(driver,20);
			 wait.until(ExpectedConditions.visibilityOf(apiLink));
			 apiLink.click();
			 System.out.println("User is redirected to API page.");
		 }
		 catch(Exception Exp) {
			 System.out.println("User is not redirected to API page.");
			 System.out.println(Exp);
		 }
		 
		 Set<String> windowHandles=driver.getWindowHandles();
		 ArrayList<String> al=new ArrayList<String>(windowHandles);
		 System.out.println(al.size());
		 driver.switchTo().window(al.get(1));
		 
		 try {
			 WebDriverWait wait= new WebDriverWait(driver,20);
			 wait.until(ExpectedConditions.visibilityOf(loginLink));
			 loginLink.click();
			 System.out.println("Login page displayed.");
		 }

		 catch(Throwable exp){
			 System.out.println("Login page not displayed.");
			 System.out.println(exp);	
		 }
		 try {
			 WebDriverWait wait= new WebDriverWait(driver,20);
			 wait.until(ExpectedConditions.visibilityOf(usernameField));
			 String username=Excel_Library.getcellvalue(sheet_path, sheet_name, 2, 1);
			 usernameField.sendKeys(username);;
			 System.out.println("Username entered.");
		 }

		 catch(Throwable exp){
			 System.out.println("Username not entered.");
			 System.out.println(exp);	
		 }
		 
		 try {
			 WebDriverWait wait= new WebDriverWait(driver,20);
			 wait.until(ExpectedConditions.visibilityOf(passwordField));
			 String password=Excel_Library.getcellvalue(sheet_path, sheet_name, 3, 1);
			 passwordField.sendKeys(password);
			 System.out.println("Password entered.");
		 }

		 catch(Throwable exp){
			 System.out.println("Password not entered.");
			 System.out.println(exp);	
		 }
		 try {
			 WebDriverWait wait= new WebDriverWait(driver,20);
			 wait.until(ExpectedConditions.visibilityOf(loginButton));
			 loginButton.click();
			 System.out.println("Login button is clicked.");
		 }

		 catch(Throwable exp){
			 System.out.println("Login button not clicked.");
			 System.out.println(exp);	
		 }
		 try {
			 WebDriverWait wait= new WebDriverWait(driver,20);
			 wait.until(ExpectedConditions.visibilityOf(apiReferenceButton));
			 apiReferenceButton.click();
			 System.out.println("API Response page is opened.");
		 }

		 catch(Throwable exp){
			 System.out.println("API Response page is not opened.");
			 System.out.println(exp);	
		 }
		 try {
			 WebDriverWait wait= new WebDriverWait(driver,20);
			 wait.until(ExpectedConditions.visibilityOf(forecastApiButton));
			 forecastApiButton.click();
			 System.out.println("Forecast API page is opened.");
		 }

		 catch(Throwable exp){
			 System.out.println("Forecast API page is not opened.");
			 System.out.println(exp);	
		 }
		 try {
			 WebDriverWait wait= new WebDriverWait(driver,20);
			 wait.until(ExpectedConditions.visibilityOf(fiveDaysForescast));
			 fiveDaysForescast.click();
			 System.out.println("5 days Forecast page is opened.");
		 }

		 catch(Throwable exp){
			 System.out.println("5 Days page not is opened.");
			 System.out.println(exp);	
		 }

		 try {
			 WebDriverWait wait= new WebDriverWait(driver,20);
			 wait.until(ExpectedConditions.visibilityOf(locationKey));
			 locationKey.sendKeys(Keys.CONTROL,"a");
			 locationKey.sendKeys("189781");
			 System.out.println("Location key entered.");
		 }

		 catch(Throwable exp){
			 System.out.println("Location key not entered.");
			 System.out.println(exp);	
		 }
		 try {
			 WebDriverWait wait= new WebDriverWait(driver,20);
			 wait.until(ExpectedConditions.visibilityOf(apiKeyField));
			 String apiKey=Excel_Library.getcellvalue(sheet_path, sheet_name, 4, 1);
			 apiKeyField.sendKeys(apiKey);
			 System.out.println("API key entered.");
		 }

		 catch(Throwable exp){
			 System.out.println("API key not entered.");
			 System.out.println(exp);	
		 }
		 
		 try {
			 WebDriverWait wait= new WebDriverWait(driver,20);
			 wait.until(ExpectedConditions.visibilityOf(metricField));
			 metricField.sendKeys("true");
			 System.out.println("Metric is entered.");
		 }

		 catch(Throwable exp){
			 System.out.println("Metric is not entered.");
			 System.out.println(exp);	
		 }
		 
		 try {
			 WebDriverWait wait= new WebDriverWait(driver,20);
			 wait.until(ExpectedConditions.visibilityOf(sendRequestButton));
			 sendRequestButton.click();
			 System.out.println("Request page is opened.");
		 }

		 catch(Throwable exp){
			 System.out.println("Request page is not opened.");
			 System.out.println(exp);	
		 }
		 
		 try {
			 WebDriverWait wait= new WebDriverWait(driver,20);
			 wait.until(ExpectedConditions.visibilityOf(futureTempApiResponse));
			 String actualText=text; 
			 System.out.println(actualText);
			 String expectedText=futureTempApiResponse.getText();
			 System.out.println(expectedText);
			 if(actualText.contains(expectedText))
			 System.out.println("Actual result is same.");
		 }

		 catch(Throwable exp){
			 System.out.println("Actual result is not same.");
			 System.out.println(exp);	
		 }
		 
		 
	 }
	 
	

}
