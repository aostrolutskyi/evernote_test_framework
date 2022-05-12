package com.evernote.test_framework.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webdriver.javascript.JavascriptExecutorFacade;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DefaultUrl("https://www.evernote.com/Login.action")
public class LoginPage extends PageObject {

    @FindBy(id="username")
    private WebElementFacade userName;

    @FindBy(id="loginButton")
    private WebElementFacade loginButton;

    @FindBy(id="responseMessage")
    private WebElementFacade responseMessage;

    @FindBy(id="password")
    private WebElementFacade passwordField;

    @FindBy(xpath="//*[@id='password-wrapper']/div")
    private WebElementFacade passwordWrapper;

    public void enterUsername(String username) {
        userName.type(username);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public String getResponseMessage() {
        return responseMessage.getText();
    }

    public String getIncorrectPasswordMessage() {
        return passwordWrapper.getText();
    }

    public void enterPassword(String password) {
        passwordField.type(password);
    }

    public void isPasswordFieldVisible(){
        waitForCondition().until(
                ExpectedConditions.elementToBeClickable(passwordField)
        );
    }

}
