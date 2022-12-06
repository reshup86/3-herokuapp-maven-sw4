package com.herokuapp.internet.pages;

import com.herokuapp.internet.utility.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility {
    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By loginButton = By.xpath("//button/i [text() = ' Login']");

    By invalidUsernameMessage = By.xpath("//div[1]//div[@class = 'flash error' and contains(text(),'Your username is invalid!')]");

    By invalidPasswordMessage = By.xpath("//div[1]//div[@class = 'flash error' and contains(text(),'Your password is invalid!')]");

    public void enterUsername (String username){
        sendTextToElement(usernameField,username);
    }
    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
    }
    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }

    public String getInvalidUsernameMessage() {
        return getTextFromElement(invalidUsernameMessage);
    }
    public String getInvalidPasswordMessage() {
        return getTextFromElement(invalidPasswordMessage);
    }
}
