package StepDefinition.Amazon;

import Drivers.Web;
import Pages.Amazon.LandingPage;
import Pages.Amazon.SearchPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class SearchItemsSD {
    LandingPage landingPage=new LandingPage();
    SearchPage searchPage=new SearchPage();

    @Given("^I am on Amazon landing page$")
    public void launchAmazon(){
        Web.initDriver("https://www.amazon.com/");
    }

    @When("^I type '(.*)' on search$")
    public void Search(String item){
        landingPage.typeInSearch(item);
        landingPage.clickOnSearch();
    }

    @Then("^I verify search contains '(.*)'$")
    public void verifySearch(String specificItem){
        Web.maximize();
        Assert.assertTrue(searchPage.itemDisplayed(specificItem));

        Web.closeDriver();
    }



}
