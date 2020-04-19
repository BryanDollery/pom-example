package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends Page {
    private static final String URL = "http://thedemosite.co.uk/login.php";
    private static final String RESULT_SELECTOR = "body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b";

    private static final By SUBMIT_BUTTON = By.name("FormsButton2");
    private static final By USERNAME_FIELD = By.name("username");
    private static final By PASSWORD_FIELD = By.name("password");

    public LoginPage(WebDriver driver) {
        super(driver, URL);
    }

    public void login(String username, String password) {
        home();
        fillField("username", username);
        fillField("password", password);
        submit("FormsButton2");
    }

    public String getResults() {
        WebElement resultElement = driver.findElement(By.cssSelector(RESULT_SELECTOR));
        return resultElement.getText();
    }
}
