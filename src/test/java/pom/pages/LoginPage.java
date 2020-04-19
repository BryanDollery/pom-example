package pom.pages;

import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {
    private static final String URL = "http://thedemosite.co.uk/login.php";
    private static final String RESULT_SELECTOR = "body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b";
    public static final String SUCCESSFUL_LOGIN = "**Successful Login**";

    public LoginPage(WebDriver driver) {
        super(driver, URL);
    }

    public void login(String username, String password) {
        home();
        fillField("username", username);
        fillField("password", password);
        submit("FormsButton2");
    }

    public boolean isSuccessfull() {
        return SUCCESSFUL_LOGIN.equals(getResults());
    }

    public String getResults() {
        return getText(RESULT_SELECTOR);
    }
}
