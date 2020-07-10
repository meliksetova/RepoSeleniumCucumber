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

}
