package StepDefinition.Facebook;

import Drivers.Web;
import Pages.BasePage;
import Pages.facebook.IncorrectLoginPage;
import Pages.facebook.LandingPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.Set;

public class FBlinksSD extends BasePage {

    LandingPage landingPage = new LandingPage();
    IncorrectLoginPage incorrectLoginPage = new IncorrectLoginPage();


    @When("^I click on Terms link$")
        public void openTermsLink(){
            landingPage.clickTerms();
        }

    @When("^I click on Data Policy link$")
    public void openPolicyLink(){
        landingPage.clickPolicy();
    }

    @When("^I click on Cookie Policy link$")
    public void openCookiePolicyLink(){
        landingPage.clickCookiePolicy();
    }

    @Then("^I verify user is on '(.*)' page title$")
    public void verifyTitle(String title){
        Assert.assertTrue(checkHandlesContainsTitle(title));
    }

    @Then("^I verify facebook landing page is open$")
    public void verifyFacebook(){
        Assert.assertTrue(checkHandlesContainsURL("https://www.facebook.com/"));
    }

    @Then("^I close all facebook window$")
    public void closeWindows(){
        Web.quitDriver();
    }


}
