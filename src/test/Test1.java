package test;

import java.io.IOException;

import org.testng.annotations.Test;

import generics.Base_Test;
import pom.Accuweather_report;

public class Test1 extends Base_Test 
{
	@Test
	 public void FunctionalTest() throws IOException, InterruptedException
	 {
		Accuweather_report test=new Accuweather_report(driver);
		 test.reportCheckMethod();
		 
	 }

}
