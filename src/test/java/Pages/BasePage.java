package Pages;


import Drivers.Web;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.xml.ws.WebEndpoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BasePage {

    public void type(By locator, String data) {

        Web.getDriver().findElement(locator).sendKeys(data);
    }

    public void clickThis(By locator) {

        Web.getDriver().findElement(locator).click();
    }

    public void clickThis(WebElement element){
        element.click();
    }

    public void clearField(By locator){
        Web.getDriver().findElement(locator).clear();
    }

    public void clearField(WebElement element){
        element.clear();
    }

    public String getTextFromElement(By locator) {

        return Web.getDriver().findElement(locator).getText();
    }

    public String getWebPageTitle() {
        return Web.getDriver().getTitle();
    }

    public String getCurrentWebUrl() {
        return Web.getDriver().getCurrentUrl();
    }

    public String getAttributeValueFromElement(By locator, String attributeName) {
        return Web.getDriver().findElement(locator).getAttribute(attributeName);
    }

    public String getAttributeValueFromElement(WebElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }

    public void selectFromDropdownByVisibleText(By locator, String visibleText) {
        WebElement dropdownElement = Web.getDriver().findElement(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(visibleText);
    }

    public boolean isWebElementEnabled(By locator) {
        return Web.getDriver().findElement(locator).isEnabled();
    }

    public boolean isWebElementDisplayed(By locator) {
        return Web.getDriver().findElement(locator).isDisplayed();
    }


    public void mouseHoverOnElement(WebElement element) {
        Actions act = new Actions(Web.getDriver());
        act.moveToElement(element).build().perform();
    }

    public void mouseHoverOnElement(By locator) {
        WebElement element = Web.getDriver().findElement(locator);
        Actions act = new Actions(Web.getDriver());
        act.moveToElement(element).build().perform();
    }

    public void selectFromAutoSuggestion(By locator, String userSelection) {
        List<WebElement> autoSuggestionElements= Web.getDriver().findElements(locator);
        for (int i=0 ; i < autoSuggestionElements.size() ; i++) {
            if (autoSuggestionElements.get(i).getText().equalsIgnoreCase(userSelection)) {
                clickThis(autoSuggestionElements.get(i));
                break;
            }
        }
    }

    public int convertAnyStringIntoInt(String text){
        int number=Integer.valueOf(text.replaceAll("\\D+",""));
        return number;
    }

    public int converttempCtoF(int temp){
        int temp1=(temp*9/5)+32;
        return temp1;
    }

    public void switchWindow(String windowHandle) {
        Web.getDriver().switchTo().window(windowHandle);
    }

    public String getCurrentWindowHandle() {
        return Web.getDriver().getWindowHandle();
    }

    public Set<String> getAllWindowHandles() {
        return Web.getDriver().getWindowHandles();
    }

    public ArrayList<String> getAllTitles(){
        Set<String> allHandles=getAllWindowHandles();
        ArrayList<String> allTitles = new ArrayList<String>();
        for (String handle : allHandles) {
            switchWindow(handle);
            allTitles.add(Web.getDriver().getTitle());
        }
        return allTitles;
    }

    public boolean checkHandlesContainsTitle(String title){
     ArrayList<String> allTitles=getAllTitles();
     boolean contains=false;
     if (allTitles.contains(title)){
         contains=true;
     } return contains;
    }

    public ArrayList<String> getAllURLs(){
        Set<String> allHandles=getAllWindowHandles();
        ArrayList<String> allURl = new ArrayList<String>();
        for (String handle : allHandles) {
            switchWindow(handle);
            allURl.add(Web.getDriver().getCurrentUrl());
        }
        return allURl;
    }

    public boolean checkHandlesContainsURL(String url){
        ArrayList<String> allURL=getAllURLs();
        boolean contains=false;
        if (allURL.contains(url)){
            contains=true;
        } return contains;
    }

    public void scrollUptoWebElement(By locator) {
        WebElement webElement = Web.getDriver().findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor)Web.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    public void scrollbyPixel(int y) {
        JavascriptExecutor js = (JavascriptExecutor)Web.getDriver();
        js.executeScript("scrollBy(0," + y + ")"); // scrollBy(0,+y+) --> scrollBy(0,y)
    }


}


