package webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class elements {

	public static WebElement username_field(WebDriver driver) {
		WebElement element = driver.findElement(By.id("input-29"));
		return element;
	}

	public static WebElement password_field(WebDriver driver) {
		WebElement element = driver.findElement(By.id("input-33"));
		return element;
	}

	public static WebElement account_circle(WebDriver driver) {
		WebElement element = driver.findElement(By.className(("mdi-account-circle")));
		return element;
	}

	public static WebElement logout_button(WebDriver driver) {
		WebElement element = driver.findElement(By.className(("mdi-logout-variant")));
		return element;
	}

	public static WebElement login_error(WebDriver driver) {
		WebElement element = driver.findElement(By.className(("v-snack__content")));
		return element;
	}

}
