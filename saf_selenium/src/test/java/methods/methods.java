package methods;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class methods {

	public static void login(WebDriver driver, WebDriverWait wait, String username, String password) {
		WebElement username_field = webelements.elements.username_field(driver);
		username_field.click();
		username_field.sendKeys(username, Keys.ENTER);

		WebElement password_field = webelements.elements.password_field(driver);
		password_field.click();
		password_field.sendKeys(password, Keys.ENTER);

		wait_for_nothing(driver, wait);
	}

	public static void logout(WebDriver driver, WebDriverWait wait, String mainpage) {

		WebElement account_circle = webelements.elements.account_circle(driver);
		account_circle.click();

		wait_for_nothing(driver, wait);
		WebElement logout_button = webelements.elements.logout_button(driver);
		logout_button.click();

		wait.until(ExpectedConditions.urlMatches(mainpage));
		wait_for_nothing(driver, wait);
	}

	public static void wait_for_nothing(WebDriver driver, WebDriverWait wait) {
		// Functionality to show where we are in the browser, otherwise it closes very
		// fast.
		try {
			wait.until(ExpectedConditions.urlMatches("12312321312"));
		} catch (Exception e) {

		}
	}

}
