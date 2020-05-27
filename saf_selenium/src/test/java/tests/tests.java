package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class tests {

	private static WebDriver driver = null;
	private static WebDriverWait wait = null;
	private static String mainpage = "https://aranet.cloud/login";
	private static String dashboard = "https://aranet.cloud/dashboard";
	private static String username = "aranetcloudtests@inbox.lv";
	private static String password = "aranetcloudtests@inbox.lv";
	private static String wrong_password = "wrong_password";

	@BeforeMethod
	public void reloadPage() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 1);
		driver.get(mainpage);
	}

	@AfterMethod
	public void tearDownMethod() {
		driver.close();
	}

	@AfterTest
	public void tearDownTest() {
		driver.quit();
	}

	@Test(priority = 1, description = "Test unsuccessfull login")
	public void test_unsuccessfull_login() {
		methods.methods.login(driver, wait, username, wrong_password);
		String current_url = driver.getCurrentUrl();
		Assert.assertEquals(current_url, mainpage, "We should still be on main page.");
		boolean error_message_exists;
		try {
			WebElement element = webelements.elements.login_error(driver);
			error_message_exists = true;
		} catch (NoSuchElementException e) {
			error_message_exists = false;
		}
		Assert.assertEquals(error_message_exists, true, "Error message should exist on unsuccesfull login.");
	}

	@Test(priority = 2, description = "Test possibility to login")
	public void test_successfull_login() {
		methods.methods.login(driver, wait, username, password);
		String current_url = driver.getCurrentUrl();
		Assert.assertEquals(current_url, dashboard, "Dashboard page should occure.");
	}

	@Test(priority = 3, description = "Test possibility to logout")
	public void test_successfull_logout() {
		methods.methods.login(driver, wait, username, password);
		methods.methods.logout(driver, wait, mainpage);
		String current_url = driver.getCurrentUrl();
		Assert.assertEquals(current_url, mainpage, "Main page should occure.");
	}

}
