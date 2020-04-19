package pom.library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {

    static {
        System.setProperty("webdriver.gecko.driver", "/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
    }

    public WebDriver getChrome() {
        return setup(new ChromeDriver());
    }

    public WebDriver getFirefox() {
        return setup(new FirefoxDriver());
    }

    private WebDriver setup(WebDriver driver) {
        driver.manage().window().maximize();
        return driver;
    }

}