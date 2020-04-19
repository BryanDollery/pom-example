package pom.testcases;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pom.library.Browser;
import pom.pages.AddUserPage;
import pom.pages.LoginPage;

import static org.junit.Assert.assertEquals;

public class LoginTestCase {

    public static final String SUCCESSFUL_LOGIN = "**Successful Login**";

    private Browser browser = new Browser();

    @Test
    public void loginWithChrome() {
        login(browser.getChrome(), "chrome", "Usain", "Bolt");
    }

    @Test
    public void loginWithFirefox() {
        login(browser.getFirefox(), "firefox", "Christian", "Coleman");
    }

    private void login(WebDriver driver, String name, String username, String password) {
        AddUserPage addUserPage = new AddUserPage(driver);
        addUserPage.addUser(username, password);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        String results = loginPage.getResults();

        if (!SUCCESSFUL_LOGIN.equals(results))
            loginPage.screenshot(name + "-" + username + "-" + password);

        driver.close();

        assertEquals(SUCCESSFUL_LOGIN, results);
    }
}
