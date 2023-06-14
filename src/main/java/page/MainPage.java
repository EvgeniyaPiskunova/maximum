package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='title']")
    private WebElement title;

    @FindBy(xpath = "//h3[@data-test=\"error\"]")
    private WebElement errorMessageInvalidLoginOrPassword;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menu;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logout;

    public boolean isErrorMassageDisplayed() {
        return errorMessageInvalidLoginOrPassword.isDisplayed();
    }

    public MainPage clickMenu() {
        menu.click();
        return new MainPage(getDriver());
    }

    public LoginPage clickLogout() {
        waitElementClickable(logout);
        logout.click();
        return new LoginPage(getDriver());
    }

    public String getTitle() {
        return title.getText();
    }
}