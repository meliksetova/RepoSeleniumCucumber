package Pages.Hotels;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends BasePage {
    By destinationHeaderLocator = By.xpath("//h1[@class='destination-title']");
    By destinationPropertyLandmarkText = By.xpath("//label[text()='Destination, property, or landmark']/following-sibling::input[@id='q-destination']");
    By priceSortLocator=By.xpath("//a[@data-menu='sort-submenu-price']");
    By lowestHotelNameLocator=By.xpath("//li[starts-with(@data-info,'1|')]//descendant::a[@class='property-name-link']");
    By lowestHotelPriceLocator=By.xpath("//li[starts-with(@data-info,'1|')]//descendant::ins");


    public String getDestinationHeader() {
        return getTextFromElement(destinationHeaderLocator);
    }

    public String getDestinationPropertyLandmarkText() {
        return getAttributeValueFromElement(destinationPropertyLandmarkText, "value");
    }

    public void sortByPrice(String sort){
        mouseHoverOnElement(priceSortLocator);
        clickThis(By.linkText(sort));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void getHotelInfo(){
        System.out.println("Hotel name: " + getTextFromElement(lowestHotelNameLocator));
        System.out.println("Hotel price per room: " + getTextFromElement(lowestHotelPriceLocator));

    }

    public int convertPriceIntoNumber(){
        int number=convertAnyStringIntoInt(getTextFromElement(lowestHotelPriceLocator));
        return number;

    }




}
