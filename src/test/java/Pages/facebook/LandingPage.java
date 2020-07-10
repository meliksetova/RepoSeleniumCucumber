package Pages.facebook;


import Drivers.Web;
import Pages.BasePage;
import org.openqa.selenium.By;

import java.util.Set;

public class LandingPage extends BasePage{

        // locators for web-element on Landing Page
        By loginEmailLocator = By.id("email");
        By loginPasswordLocator = By.id("pass");
        By loginButtonLocator = By.id("loginbutton");
        By fNameLocator=By.name("firstname");
        By lNameLocator=By.name("lastname");
        By mobileLocator=By.name("reg_email_");
        By termslinkLocator=By.id("terms-link");
        By dataPolicyLocator=By.id("privacy-link");
        By CookiePolicyLocator=By.id("cookie-use-link");


        public void enterLoginEmail(String userEmail) {
            type(loginEmailLocator, userEmail);
        }

        public void enterLoginPassword(String userPassword) {
            type(loginPasswordLocator, userPassword);
        }

        public void clickLoginButton() {
            clickThis(loginButtonLocator);
        }

        public void clickTerms(){clickThis(termslinkLocator);}

        public void clickPolicy(){clickThis(dataPolicyLocator);}

        public void clickCookiePolicy(){clickThis(CookiePolicyLocator);}




}



