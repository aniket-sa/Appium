package appiumtests;

import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

public class startCalculation {


	public static void main(String[] args) {	
		try {
			DesiredCapabilities cap=new DesiredCapabilities();
			cap.setCapability("DeviceName", "Galaxy A50");
			cap.setCapability("udid", "RZ8M50C1DGD");
			cap.setCapability("platformName", "Android");
			cap.setCapability("platformVersion", "11");
			cap.setCapability("appPackage", "com.sec.android.app.popupcalculator");
			cap.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
			
			URL url=new URL("http://127.0.0.1:4723/wd/hub");
			AppiumDriver driver = new AppiumDriver(url, cap);
			System.out.println("Application started...");
			driver.close();
			System.out.println("Application Ended!!!");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
}
