package chromeBrowser;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

public class openBrowser {
	static WebDriver AD;
	public static void main(String[] args) throws Exception {
		openChrome();
		Thread.sleep(10000);
		openWebsite("https://www.amazon.com");
		search("iPhone 14");
		System.out.println("Test Ended!!!");
	}
	
	public static void openChrome() throws Exception{
		try {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("DeviceName", "Galaxy A50");
		cap.setCapability("udid", "RZ8M50C1DGD");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11");
		cap.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		cap.setCapability(CapabilityType.BROWSER_VERSION, "103.0.5060.53");
		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		AD = new AppiumDriver(url, cap);
		System.out.println("Application started...");
		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	public static void openWebsite(String link) {
		AD.get(link);
		}	
	public static void search(String search) {
			AD.findElement(By.xpath("//android.view.View[@content-desc=\"Clear search keywords\"]")).sendKeys(search);
			AD.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.widget.TextView")).click();
	}

}
