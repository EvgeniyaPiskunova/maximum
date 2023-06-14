package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-name")
    private WebElement login;

    @FindBy(xpath = "//div[@class='login_logo']")
    public WebElement logo;

    @FindBy(id = "password")
    private WebElement pasword;

    @FindBy(id="login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement title;


    public LoginPage typeLogin(String userName) {
        login.sendKeys(userName);
        return new LoginPage(getDriver());
    }

    public LoginPage typePassword(String passwordIn) {
        pasword.sendKeys(passwordIn);
        return new LoginPage(getDriver());
    }

    public LoginPage putInvalidPassword(String wrongPassword) {
        pasword.sendKeys(wrongPassword);
        return new LoginPage(getDriver());
    }

    public LoginPage putInvalidLogin(String wrongLogin) {
        pasword.sendKeys(wrongLogin);
        return new LoginPage(getDriver());
    }

    public MainPage clickLogin() {
        loginButton.click();
        return new MainPage(getDriver());
    }

    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }

    public String viewTitle() {
        return title.getText();
    }
}