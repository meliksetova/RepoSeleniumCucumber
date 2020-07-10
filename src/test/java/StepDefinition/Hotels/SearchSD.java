package StepDefinition.Hotels;

import Drivers.Web;
import Pages.BasePage;
import Pages.Hotels.LandingPage;
import Pages.Hotels.SearchResultPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SearchSD extends BasePage {
    LandingPage landingPage = new LandingPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    String userChoice;

    @Given("^I am on hotels landing page$")
    public void launchHotels() {
        Web.initDriver("https://www.hotels.com/");
    }

    @When("^I enter '(.*)' in search$")
    public void enterUserDestination(String destination) {
        landingPage.enterDestination(destination);
    }

    @When("^I select '(.*)' from autosuggestion$")
    public void selectFromLandingAutoSuggestions(String userPreference) {
        userChoice = userPreference;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        landingPage.selectDestFromAutoSuggestions(userPreference);
    }

    @When("^I click on Search button$")
    public void clickSearch() {
        landingPage.clickSearchButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("^I select '(.*)' in children dropdown$")
    public void selectFromChildDropdown(String children){
        landingPage.selectFromChildrenDropDown(children);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("^I enter Child 1 age as '(.*)'$")
    public void selectFromChild1Dropdown(String child){
        landingPage.selectFromChild1DropDown(child);

    }

    @When("^I enter Child 2 age as '(.*)'$")
    public void selectFromChild2Dropdown(String child){
        landingPage.selectFromChild2DropDown(child);

    }

    @When("^I sort the result '(.*)'$")
    public void sortByPrice(String sort){
        searchResultPage.sortByPrice(sort);

    }


    @Then("^I print the lowest hotel price and hotel name in console$")
    public void HotelInfo(){
        searchResultPage.getHotelInfo();
    }


    @Then("^I verify search result header is same as text selected from auto suggestion$")
    public void verifySearchHeader() {
        Assert.assertEquals(userChoice, searchResultPage.getDestinationHeader(), "Search Result header didn't match");
    }

    @Then("^I verify text under 'Destination, property, or landmark' is same as text selected from auto suggestion$")
    public void verifyDeatinationPropertyLandmarkText() {
        Assert.assertEquals(userChoice, searchResultPage.getDestinationPropertyLandmarkText(), "Text under Destination, Property and Landmark didn't match   ");
    }

    @Then("^I verify the lowest price is less than '(.*)'$")
    public void verifyPriceLowerThan(String price){
        int priceNumber=convertAnyStringIntoInt(price);
        int hotelPrice=searchResultPage.convertPriceIntoNumber();
        boolean compare=priceNumber>hotelPrice;
        Assert.assertTrue(compare);
    }







}
