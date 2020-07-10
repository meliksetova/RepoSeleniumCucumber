package Pages.facebook;


import Pages.BasePage;
import org.openqa.selenium.By;

public class IncorrectLoginPage extends BasePage {

        By errorLocator = By.xpath("//div[contains(text(), 'The password that you\'ve entered'");

        public String getErrorMsg() {
            return getTextFromElement(errorLocator);
        }



    }

