package StepDefinition.Darsky;

import Pages.BasePage;
import Pages.Darsky.LandingPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TodayTimelineSD extends BasePage {
    LandingPage landingPage= new LandingPage();


@Then("^I scroll to Today timeline$")
    public void TimeLine(){
    landingPage.scrollToTimeline();
}

@When("^I verify the temp values on timeline is same as detail section$")
    public void Verify(){
    landingPage.verifyTemp();

}

}
