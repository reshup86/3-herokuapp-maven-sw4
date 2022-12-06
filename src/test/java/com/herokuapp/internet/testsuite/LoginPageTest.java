package com.herokuapp.internet.testsuite;

import com.herokuapp.internet.pages.LoginPage;
import com.herokuapp.internet.pages.SecureAreaPage;
import com.herokuapp.internet.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    SecureAreaPage secureAreaPage = new SecureAreaPage();

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();

        String expectedMessage = "Secure Area";
        Assert.assertEquals(secureAreaPage.getErrorMessage(),expectedMessage,"Secure area text is not displayed");
    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        loginPage.enterUsername("tomsmith1");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();

        String expectedUsernameMessage = "Your username is invalid!\n"+"×";
        Assert.assertEquals(loginPage.getInvalidUsernameMessage(),expectedUsernameMessage,"Invalid username text is not displayed");
    }
    @Test
    public void verifyThePasswordErrorMessage(){
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword");
        loginPage.clickOnLoginButton();

        String expectedPasswordMessage = "Your password is invalid!\n"+"×";
        Assert.assertEquals(loginPage.getInvalidPasswordMessage(),expectedPasswordMessage,"Invalid password text is not displayed");
    }
}
