package com.maximum.selenium;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.LoginPage;
import page.Utils;

public class SimpleTest extends BaseTest {

    private final String VALID_LOGIN = System.getProperty("user1");
    private final String VALID_PASSWORD = System.getProperty("user1pw");

    @Owner("Zhenya")
    @Link(name = "link", url = "https://www.saucedemo.com/")
    @Description("isDisplay Logo")
    @Test
    public void isDisplayLogo() {
        boolean result = new LoginPage(getDriver())
                .isLogoDisplayed();

        Assert.assertTrue(result);
    }

    @Owner("Zhenya")
    @Link(name = "link", url = "https://www.saucedemo.com/")
    @Description("failed login")
    @Test
    public void inValidLoginAndPassword() {
        boolean result = new LoginPage(getDriver())
                .putInvalidLogin(Utils.randomUUID())
                .putInvalidPassword(Utils.randomUUID())
                .clickLogin()
                .isErrorMassageDisplayed();

        Assert.assertTrue(result);
    }

    @Owner("Zhenya")
    @Link(name = "link", url = "https://www.saucedemo.com/")
    @Description("success login")
    @Test
    public void validLoginAndPassword() {
        String title = new LoginPage(getDriver())
                .typeLogin(VALID_LOGIN)
                .typePassword(VALID_PASSWORD)
                .clickLogin()
                .getTitle();

        Assert.assertEquals(title, "Products");
    }

    @Owner("Zhenya")
    @Link(name = "link", url = "https://www.saucedemo.com/")
    @Description("logout")
    @Test
    public void clickLogout() {
        boolean logout = new LoginPage(getDriver())
                .typeLogin(VALID_LOGIN)
                .typePassword(VALID_PASSWORD)
                .clickLogin()
                .clickMenu()
                .clickLogout()
                .isLogoDisplayed();

        Assert.assertTrue(logout);
    }
}
