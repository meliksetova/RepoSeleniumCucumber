package Pages;


import Drivers.Web;
import com.google.common.base.Function;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import static Drivers.Web.getDriver;

public class BasePage {

    public void type(By locator, String data) {

        findElementUsingFluentWait(locator).sendKeys(data);
    }
    public void typeJS(By locator, String data) {
        WebElement element = findElementUsingFluentWait(locator);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].values='%s';", element, data);
    }

    public void clickThis(By locator) {

        findElementUsingFluentWait(locator).click();
    }

    public void clickThisJS(By locator) {
        WebElement element = findElementUsingFluentWait(locator);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    public void clickThis(WebElement element){
        element.click();
    }

    public void clearField(By locator){
        findElementUsingFluentWait(locator).clear();
    }

    public void clearField(WebElement element){
        element.clear();
    }

    public String getTextFromElement(By locator) {

        return findElementUsingFluentWait(locator).getText();
    }
    public String getTextFromElement(WebElement element) {
        return element.getText();
    }

    public String getWebPageTitle() {
        return getDriver().getTitle();
    }

    public String getCurrentWebUrl() {
        return getDriver().getCurrentUrl();
    }

    public String getAttributeValueFromElement(By locator, String attributeName) {
        return findElementUsingFluentWait(locator).getAttribute(attributeName);
    }

    public String getAttributeValueFromElement(WebElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }

    public void selectFromDropdownByVisibleText(By locator, String visibleText) {
        WebElement dropdownElement = findElementUsingFluentWait(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(visibleText);
    }

    public boolean isWebElementEnabled(By locator) {
        return findElementUsingFluentWait(locator).isEnabled();
    }

    public boolean isWebElementDisplayed(By locator) {
        return findElementUsingFluentWait(locator).isDisplayed();
    }


    public void mouseHoverOnElement(WebElement element) {
        Actions act = new Actions(getDriver());
        act.moveToElement(element).build().perform();
    }

    public void mouseHoverOnElement(By locator) {
        WebElement element = findElementUsingFluentWait(locator);
        Actions act = new Actions(getDriver());
        act.moveToElement(element).build().perform();
    }

    public void selectFromAutoSuggestion(By locator, String userSelection) {
        List<WebElement> autoSuggestionElements= findElementsUsingFluentWait(locator);
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

    public int convertTempCtoF(int temp){
        int temp1=(temp*9/5)+32;
        return temp1;
    }
    public ArrayList<String> getAllTitles(){
        Set<String> allHandles=getAllWindowHandles();
        ArrayList<String> allTitles = new ArrayList<String>();
        for (String handle : allHandles) {
            switchWindow(handle);
            allTitles.add(getDriver().getTitle());
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
            allURl.add(getDriver().getCurrentUrl());
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
        WebElement webElement = getDriver().findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    public void scrollbyPixel(int y) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("scrollBy(0," + y + ")"); // scrollBy(0,+y+) --> scrollBy(0,y)
    }

    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void switchWindow(String windowHandle) {
        getDriver().switchTo().window(windowHandle);
    }

    public String getCurrentWindowHandle() {
        return getDriver().getWindowHandle();
    }

    public Set<String> getAllWindowHandles() {
        return getDriver().getWindowHandles();
    }

    public void switchToFrame(String frameId) {
        getDriver().switchTo().frame(frameId);
    }

    public void switchToFrame(By frameLocator) {
        WebElement myFrame = findElementUsingFluentWait(frameLocator);
        getDriver().switchTo().frame(myFrame);
    }

    // generic method to accept an alert
    public void acceptAlert() {
        getDriver().switchTo().alert().accept();
    }

    // generic method to dismiss an alert
    public void dismissAlert() {
        getDriver().switchTo().alert().dismiss();
    }

    // generic method to get text from an alert
    public String getTextFromAlert() {
        return getDriver().switchTo().alert().getText();
    }


    public WebElement findElementUsingFluentWait(By locator) {
        Wait fWait = new FluentWait(getDriver())
                .withTimeout(Duration.ofSeconds(25))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(NoAlertPresentException.class)
                .ignoring(ElementNotInteractableException.class)
                .withMessage("Element is not found within 25 seconds");

        WebElement ele=(WebElement) fWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        }) ;
        return ele;

    }

    public List<WebElement> findElementsUsingFluentWait(By locator) {
        Wait fWait = new FluentWait<>(Web.getDriver())
                .withTimeout(Duration.ofSeconds(25))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(NoAlertPresentException.class)
                .ignoring(ElementNotInteractableException.class)
                .withMessage("Elements are not found within 25 seconds");

        List<WebElement> ele = (List<WebElement>) fWait.until(new Function<WebDriver, List<WebElement>>() {
            public List<WebElement> apply(WebDriver driver) {
                return driver.findElements(locator);

            }
        });
        return ele;
    }
    public void selectDateFromCalendar(By locator, String userDate) {
        List<WebElement> allDates = findElementsUsingFluentWait(locator);
        for (WebElement date : allDates) {
            if (date.getText().equals(userDate)) {
                clickThis(date);
                break;
            }
        }
    }












}


