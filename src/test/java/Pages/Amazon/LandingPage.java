package Pages.Amazon;

import Pages.BasePage;
import org.openqa.selenium.By;

public class LandingPage extends BasePage {
    By searchLocator=By.id("twotabsearchtextbox");
    By searchButtonLocator=By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']");



    public void typeInSearch(String name){
        type(searchLocator,name);

    }

    public void clickOnSearch(){
        clickThis(searchButtonLocator);
    }



}
