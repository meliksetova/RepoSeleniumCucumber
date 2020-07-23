package Pages.Hotels;

import Pages.BasePage;
import org.openqa.selenium.By;

public class LandingPage extends BasePage {
    By searchBoxLocator = By.id("qf-0q-destination");
    By searchButtonLocator = By.xpath("//button[@type='submit']");
    By autoSuggestionsLocator = By.xpath("//div[@class='autosuggest-category-result']");
    By childrenDropDownLocator=By.id("qf-0q-room-0-children");
    By child1DropDownLocator=By.name("q-room-0-child-0-age");
    By child2DropdownLocator=By.name("q-room-0-child-1-age");
    By allDatesFromFirstCalendarLocator = By.xpath("(//div[@class='widget-datepicker-bd'])[1]//td[@data-date]//a");
    By checkInCalendarIconLocator = By.id("widget-query-label-1");
    By checkOutCalendarIconLocator = By.id("widget-query-label-3");
    By briefCaseLocator=By.className("widget-query-num-nights");
    By continueLocator=By.xpath("//button[@class='cta widget-overlay-close']");
    By monthLocator=By.xpath("//div[@class='widget-daterange widget-daterange-start widget-daterange-visible widget-daterange-below']//div[1]//div[1]//div[1]");
    By monthLocator2=By.xpath("//body[1]/div[8]/div[2]/div[1]/div[1]/div[1]");
    By nextButtonLocator=By.xpath("//div[@class='widget-daterange-cont']//div[2]//div[1]//button[2]");


    public void closePopUp(){ clickThis(continueLocator);}

    public void enterDestination(String destination) {
          type(searchBoxLocator, destination);
    }

    public void clickSearchButton() {
        clickThis(searchButtonLocator);
    }

    public void selectDestFromAutoSuggestions(String userWantsToSelectThis) {
        selectFromAutoSuggestion(autoSuggestionsLocator, userWantsToSelectThis);
    }

    public void selectFromChildrenDropDown(String children){
        selectFromDropdownByVisibleText(childrenDropDownLocator,children);
    }

    public void selectFromChild1DropDown(String children){
        selectFromDropdownByVisibleText(child1DropDownLocator,children);
    }

    public void selectFromChild2DropDown(String children){
        selectFromDropdownByVisibleText(child2DropdownLocator,children);
    }

    public void clickCheckInCalendarIcon() {
        clickThis(checkInCalendarIconLocator);
    }

    public void clickCheckOutCalendarIcon() {
        clickThis(checkOutCalendarIconLocator);
    }

    public void selectCheckInDate(String dateValue,String monthValue) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (!getTextFromElement(monthLocator).contains(monthValue)){
            clickThis(nextButtonLocator);
        }
        selectDateFromCalendar(allDatesFromFirstCalendarLocator, dateValue);



    }

    public void selectCheckOutDate(String dateValue, String monthValue) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (!getTextFromElement(monthLocator2).contains(monthValue)){
            clickThis(nextButtonLocator);
        }


        selectDateFromCalendar(allDatesFromFirstCalendarLocator, dateValue);
    }

    public Boolean verifyDays(String days){
        return getTextFromElement(briefCaseLocator).equalsIgnoreCase(days);
    }

}
