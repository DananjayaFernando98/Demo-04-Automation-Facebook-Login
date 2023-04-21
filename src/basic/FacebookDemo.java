package basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FacebookDemo {
	
	WebDriver driver;
	
	
	public void setupBrowser(String browser, String url) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium Webdriver\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium Webdriver\\FireFoxdriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("Valid browser was not provided, hence quiting the automation run");
		}
		
		if(url !="") {
			driver.get(url);
		}
		else {
			driver.get("about:blank");
		}
	}
	
	public void quit() {
		driver.quit();
	}
	
	public void facebookLogin(String username , String password) {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		
	}
	
	public void submitm() {
		driver.findElement(By.name("login")).click();
	}
	public static void main(String[] args) {
		
		FacebookDemo obj = new FacebookDemo();
		obj.setupBrowser("chrome", "https://www.facebook.com");
		obj.facebookLogin("*****", "*****");
		obj.submitm();
		//obj.quit();

	}

}
