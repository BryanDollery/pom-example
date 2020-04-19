package pom.pages;

import org.openqa.selenium.WebDriver;

public class AddUserPage extends Page {
    private static final String URL = "http://thedemosite.co.uk/addauser.php";

    public AddUserPage(WebDriver driver) {
        super(driver, URL);
    }

    public void addUser(String username, String password) {
        home();
        fillField("username", username);
        fillField("password", password);
        submit("FormsButton2");
    }
}
