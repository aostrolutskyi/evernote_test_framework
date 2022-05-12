package com.evernote.test_framework.steps.login.api;

import net.thucydides.core.annotations.Step;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EndUserApiSteps {

    private Map<String, Object> map = new HashMap<>();
    Response response;

    public void setLoginRequestData(String email, String password){
        this.map.put("username", email);
        this.map.put("password", password);
        this.map.put("login", "Sign+in");
        this.map.put("hpts", "1652378281224");
        this.map.put("hptsh", "fpSR3Ev98Z0s664OEkLVC6N0w1M%3D");
        this.map.put("analyticsLoginOrigin", "login_action");
        this.map.put("clipperFlow", "false");
        this.map.put("showSwitchService", "true");
        this.map.put("usernameImmutable", "false");
        this.map.put("_sourcePage", "fYKuzFss5K3iMUD9T65RG_YvRLZ-1eYO3fqfqRu0fynRL_1nukNa4gH1t86pc1SP");
        this.map.put("__fp", "QWBQaw1---U3yWPvuidLz-TPR6I9Jhx8");
    }

    @Step
    public void given_user_email_and_login(String email, String password){
        this.setLoginRequestData(email, password);
    }

    @Step
    public void user_send_a_login_request(){
        this.response = given()
                .header("Content-type", "application/json")
                .and()
                .body(this.map)
                .when()
                .post("https://www.evernote.com/Login.action")
                .then()
                .extract().response();
    }

    @Step
    public void user_get_a_suspicious_response(){
        assertEquals(302, this.response.statusCode());

        System.out.println(response.getHeader("Location").toString());
        assertTrue(response.getHeader("Location").toString().contains("login.error.suspicious"));
    }

}
