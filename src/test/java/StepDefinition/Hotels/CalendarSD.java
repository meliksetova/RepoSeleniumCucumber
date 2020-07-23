package StepDefinition.Hotels;

import Pages.Hotels.LandingPage;
import Pages.Hotels.SearchResultPage;
import Utils.DateHelper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class CalendarSD {

    LandingPage landingPage = new LandingPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    String userChoice;

    @When("^I enter (.*) as check in$")
    public void selectCheckInDate(String dateValue) {
        landingPage.clickCheckInCalendarIcon();
        if (dateValue.equalsIgnoreCase("today")) {
            landingPage.selectCheckInDate(DateHelper.getCurrentDateValue(),DateHelper.getCurrentMonthValue());
        } else if (dateValue.equalsIgnoreCase("tomorrow")) {
            landingPage.selectCheckInDate(DateHelper.getTomorrowDateValue(),DateHelper.getTomorrowMonthValue());
        } else {
            landingPage.selectCheckInDate(DateHelper.getDateValue(dateValue),DateHelper.getMonthValue(dateValue));
        }
    }

    @And("^I enter (.*) days from (.*) as checkout$")
    public void selectCheckOutDate(String addDays, String dateValue) {
        landingPage.clickCheckOutCalendarIcon();
        if (dateValue.equalsIgnoreCase("today")) {
            landingPage.selectCheckOutDate(DateHelper.getDateValueXDaysFromToday(Integer.parseInt(addDays)),DateHelper.getMonthValueXDaysFromToday(Integer.parseInt(addDays)));
        } else if (dateValue.equalsIgnoreCase("tomorrow")) {
            landingPage.selectCheckOutDate(DateHelper.getDateValueXDaysFromTomorrow(Integer.parseInt(addDays)),DateHelper.getMonthValueXDaysFromTomorrow(Integer.parseInt(addDays)));
        } else {
            landingPage.selectCheckOutDate(DateHelper.getDateValueXDaysFromDate(dateValue, Integer.parseInt(addDays)),DateHelper.getMonthValueXDaysFromDate(dateValue, Integer.parseInt(addDays)));
        }
    }

    @Then("^I verify (.*) count on the briefcase$")
    public void verifyDate(String days){
        Assert.assertTrue(landingPage.verifyDays(days));

    }








}
