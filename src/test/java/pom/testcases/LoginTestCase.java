package pom.testcases;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pom.library.Browser;
import pom.pages.AddUserPage;
import pom.pages.LoginPage;

import static org.junit.Assert.assertTrue;

public class LoginTestCase {

    private static final Browser browser = new Browser();

    @Test
    public void loginWithChrome() {
        WebDriver chrome = browser.getChrome();
        login(chrome, "chrome", "Usain", "Bolt");
        chrome.close();
    }

    @Test
    public void loginWithFirefox() {
        WebDriver firefox = browser.getFirefox();
        login(firefox, "firefox", "Christian", "Coleman");
        firefox.close();
    }

    private void login(WebDriver driver, String name, String username, String password) {
        AddUserPage addUserPage = new AddUserPage(driver);
        addUserPage.addUser(username, password);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        if (!loginPage.isSuccessfull())
            loginPage.screenshot(name + "-" + username + "-" + password);

        assertTrue(loginPage.isSuccessfull());
    }
}
