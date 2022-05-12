package com.evernote.test_framework.steps.login.api;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class LoginApiSteps {

    @Steps
    EndUserApiSteps endUser;

    @Given("the user have e-mail '$email' and password '$password'")
    public void givenUserEmailAndLogin(String email, String password) {
        endUser.given_user_email_and_login(email, password);
    }

    @When("the user send a login request")
    public void userSendALoginRequest() {
        endUser.user_send_a_login_request();
    }

    @Then("the user get a suspicious response")
    public void userGetASuspiciousResponse() {
        endUser.user_get_a_suspicious_response();
    }
}
