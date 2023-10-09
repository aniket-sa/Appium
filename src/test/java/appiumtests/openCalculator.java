package appiumtests;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.*;

public class openCalculator {
	static AppiumDriver AD;
	public static void main(String[] args) throws Exception {
		openCalc();
		Thread.sleep(10000);
		number("08");
		number("02");
		action("+");
		number("00");
		number("08");
		action("-");
		number("05");
		number("02");
		action("+");
		number("09");
		number("05");
		number("02");
		number("01");
		//results=
		System.out.println("Calculation result is = "+result());
		System.out.println("Test Ended!!!");
	}
	


	
	public static void openCalc() throws Exception{
		try {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("DeviceName", "Galaxy A50");
		cap.setCapability("udid", "RZ8M50C1DGD");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11");
		cap.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		cap.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		AD = new AppiumDriver(url, cap);
		System.out.println("Application started...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void number(String num) {
			AD.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_"+num)).click();
		}
	public static String result() {
		String calculationResult = AD.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_tv_result")).getText();
		return calculationResult;
	}
	
	public static void action(String act) {
		String perform = null;
		if(act=="*") {
			perform="mul";
		}
		else if(act=="C") {
			perform="clear";
		}
		else if(act=="%") {
			perform="percentage";
		}
		else if(act=="/") {
			perform="div";
		}
		else if(act=="-") {
			perform="sub";
		}
		else if(act=="+") {
			perform="add";
		}
		else if(act=="=") {
			perform="equal";
		}
			AD.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_"+perform)).click();
	}
}


