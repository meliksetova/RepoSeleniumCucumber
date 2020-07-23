package Pages.Amazon;

import Pages.BasePage;
import org.openqa.selenium.By;

public class SearchPage extends BasePage {

    public boolean itemDisplayed(String specificItem){
        By itemLocator=By.partialLinkText(specificItem);
        return isWebElementDisplayed(itemLocator);
    }


}
