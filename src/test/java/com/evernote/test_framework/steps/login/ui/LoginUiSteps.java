package com.evernote.test_framework.steps.login.ui;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class LoginUiSteps {
    
    @Steps
    EndUserUiSteps endUser;

    @Given("the user is on the LoginPage")
    public void givenTheUserIsOnTheLoginPage() {
        endUser.is_on_the_login_page();
    }

    @When("the user enters e-mail '$email'")
    public void whenUserEntersEmail(String email) {
        endUser.enter_email(email);
    }

    @When("the user clicks on login button")
    public void whenUserClicksOnLoginButton() {
        endUser.click_login_button();
    }

    @When("the user enters password '$password'")
    public void whenUserEntersPassword(String password) throws InterruptedException {
        Thread.sleep(10000);
        endUser.is_password_field_visible();
        endUser.enter_password(password);
    }

    @Then("the user should see error response message '$responseMessage'")
    public void thenUserShouldSeeErrorResponseMessage(String responseMessage) throws InterruptedException {
        Thread.sleep(10000);
        endUser.should_see_definition(responseMessage);
    }

    @Then("the user should see incorrect password message '$message'")
    public void thenUserShouldSeeIncorrectPasswordMessage(String message) {
        endUser.should_see_incorrect_password_message(message);
    }

    @Then("the user is on the HomePage")
    public void thenUserShouldBeOnTheHomePage() {
        endUser.is_on_the_home_page();
    }

    @When("the user creates a note with text '$text'")
    public void userCreatesANoteWithText(String text) throws InterruptedException {
        endUser.create_a_note_with_text(text);
        endUser.check_note_is_saved(text);
    }

    @When("the user clicks on logout")
    public void userClicksOnLogOut(){
        endUser.click_logout_button();
    }

    @Then("the user follows by a logout")
    public void userFollowsByALogout() throws InterruptedException {
        endUser.is_on_the_logout_page();
    }

    @Then("a note with text '$text' has been created")
    public void lastNoteIsCreated(String text) throws InterruptedException {
        Thread.sleep(20000);
        endUser.homePage.clickOnNotesMenu();
        Thread.sleep(2000);
        endUser.is_a_note_created(text);
    }
}
