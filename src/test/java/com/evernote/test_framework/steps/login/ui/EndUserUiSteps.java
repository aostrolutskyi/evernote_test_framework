package com.evernote.test_framework.steps.login.ui;

import com.evernote.test_framework.pages.HomePage;
import com.evernote.test_framework.pages.LoginPage;
import com.evernote.test_framework.pages.MainPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;


public class EndUserUiSteps {
    LoginPage loginPage;
    HomePage homePage;
    MainPage mainPage;

    @Step
    public void is_on_the_login_page() {
        loginPage.open();
    }

    @Step
    public void is_on_the_home_page() {
        assertThat(homePage.getDriver().getCurrentUrl(), containsString("https://www.evernote.com/client/web"));
    }

    @Step
    public void is_on_the_logout_page() throws InterruptedException {
        Thread.sleep(15000);
        assertThat(mainPage.getDriver().getCurrentUrl(), containsString("https://evernote.com/logged-out/"));
    }

    @Step
    public void is_password_field_visible() {
        loginPage.isPasswordFieldVisible();
    }

    @Step
    public void enter_email(String email) {
        loginPage.enterUsername(email);
    }

    @Step
    public void enter_password(String password) {
        loginPage.enterPassword(password);
    }

    @Step
    public void click_login_button() {
        loginPage.clickOnLoginButton();
    }

    @Step
    public void click_logout_button() {
        homePage.clickLogOutButton();
    }

    @Step
    public void check_note_is_saved(String text) throws InterruptedException {
        assertTrue(homePage.isANoteSaved(text)) ;
    }

    @Step
    public void should_see_definition(String responseMessage) {
        assertThat(loginPage.getResponseMessage(), equalTo(responseMessage));
    }

    @Step
    public void should_see_incorrect_password_message(String message) {
        assertThat(loginPage.getIncorrectPasswordMessage(), equalTo(message));
    }

    @Step
    public void create_a_note_with_text(String text) throws InterruptedException {
        Thread.sleep(20000);
        homePage.waitUntilNewButtonAppears();
        Thread.sleep(15000);
        homePage.clickOnNewButton();
        Thread.sleep(3000);
        homePage.clickOnNewNoteButton();
        Thread.sleep(8000);
        homePage.typeAText(text);
        Thread.sleep(5000);
    }

    @Step
    public void is_a_note_created(String text) throws InterruptedException {
        assertTrue(homePage.isANoteSaved(text)) ;
    }
}
