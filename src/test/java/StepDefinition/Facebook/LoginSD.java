package StepDefinition.Facebook;

import Drivers.Web;
import Pages.facebook.IncorrectLoginPage;
import Pages.facebook.LandingPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;


public class LoginSD {
    LandingPage landingPage = new LandingPage();
    IncorrectLoginPage incorrectLoginPage = new IncorrectLoginPage();


    @Given("^I am on facebook landing page$")
    public void launchFacebook(){
        Web.initDriver("https://www.facebook.com");

    }

    @When("^I enter '(.*)' as username$") // I enter '0 or something random' as username
    public void enterLoginUserEmail(String email) {
        landingPage.enterLoginEmail(email);
    }

    @When("^I enter '(.*)' as password$")
    public void enterLoginUserPassword(String password) {
        landingPage.enterLoginPassword(password);
    }

    @When("^I click on (login|signup) button$") // <- I click on <either login or signup> button
    public void clickButton(String buttonName) {
        if ("login".equals(buttonName.toLowerCase())) {
            landingPage.clickLoginButton();

        } else {
            new Exception("Invalid button name: " + buttonName);
        }
    }

    @Then("^I get invalid credentials error message$")
    public void verifyErrorMessage() {
        String actualError = incorrectLoginPage.getErrorMsg();
        String expectedError = "";
        Assert.assertEquals(actualError, expectedError, "Invalid credentials Error msg is not as expected");
    }


}
