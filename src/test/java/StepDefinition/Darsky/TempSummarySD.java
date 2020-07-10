package StepDefinition.Darsky;

import Drivers.Web;
import Pages.BasePage;
import Pages.Darsky.LandingPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;

public class TempSummarySD extends BasePage {
    LandingPage landingPage= new LandingPage();



    @Given("^I am on darksky landing page$")
    public void launchDarksky(){
    Web.initDriver("https://darksky.net/forecast/40.7127,-74.0059/us12/en");

    }

    @Then("^I verify feelsLike, low and high temp values are displayed$")
    public void checkTempDisplayed(){
        landingPage.saveTempF();
        Assert.assertTrue(landingPage.checkTempDisplay());


    }

    @When("^I select \"ËšC, mph\" from temp unit dropdown$")
    public void changeTemp(){
        landingPage.changeTempSystemToC();
    }

    @Then("^I verify feelsLike, low and high temp values changed as per unit selected$")
            public void compareTemperature(){
            landingPage.saveTempC();
            boolean equal =landingPage.compare();
            Assert.assertTrue(equal);
            }







}
