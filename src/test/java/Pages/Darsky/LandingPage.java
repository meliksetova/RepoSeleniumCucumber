package Pages.Darsky;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.ArrayList;

public class LandingPage extends BasePage {
    By feelsLikeTempLocator=By.xpath("//span[@class='feels-like-text']");
    By lowTempLocator=By.xpath("//span[@class='low-temp-text']");
    By highTempLocator=By.xpath("//span[@class='high-temp-text']");
    By tempChangeLocator=By.xpath("//div[@id='header']//div[@class='selectric-wrapper selectric-units']");
    By tempCLocator=By.xpath("//div[@id='header']//li[@class='last'][contains(text(),'C, mph')]");
    By timeLineLocator=By.xpath("//span[contains(text(),'Today')]");
    By lowTempInLineLocator=By.xpath("//a[@class='day revealed']//span[@class='minTemp']");
    By lowTempUnderLineLocator=By.xpath("//div[@class='dayDetails revealed']//span[@class='highTemp swip']//span[@class='temp']");
    By highTempInLineLocator=By.xpath("//a[@class='day revealed']//span[@class='maxTemp']");
    By highTempUnderLineLocator=By.xpath("//div[@class='dayDetails revealed']//span[@class='lowTemp swap']//span[@class='temp']");

    ArrayList<Integer> temperaturesF=new ArrayList<Integer>();
    ArrayList<Integer> temperaturesC=new ArrayList<Integer>();

    public void scrollToTimeline(){
        scrollUptoWebElement(timeLineLocator);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickThis(timeLineLocator);
    }

    public void verifyTemp(){
        Assert.assertEquals(getTextFromElement(lowTempInLineLocator),getTextFromElement(lowTempUnderLineLocator));
        Assert.assertEquals(getTextFromElement(highTempInLineLocator),getTextFromElement(highTempUnderLineLocator));
    }


    public void changeTempSystemToC(){
        clickThis(tempChangeLocator);
        clickThis(tempCLocator);

    }

    public boolean checkTempDisplay(){
        boolean feelsLikeTempDisplayed=isWebElementDisplayed(feelsLikeTempLocator);
        boolean lowTempDisplayed=isWebElementDisplayed(lowTempLocator);
        boolean highTempDisplayed=isWebElementDisplayed(highTempLocator);
        boolean allDisplayed=feelsLikeTempDisplayed && highTempDisplayed && lowTempDisplayed;
        return allDisplayed;
    }

    public void saveTempF(){
        int feelLikeTemp=convertAnyStringIntoInt(getTextFromElement(feelsLikeTempLocator));
        int highTemp=convertAnyStringIntoInt(getTextFromElement(highTempLocator));
        int lowTemp=convertAnyStringIntoInt(getTextFromElement(lowTempLocator));
        temperaturesF.add(feelLikeTemp);
        temperaturesF.add(highTemp);
        temperaturesF.add(lowTemp);
    }


    public void saveTempC(){
        int feelLikeTempC=convertAnyStringIntoInt(getTextFromElement(feelsLikeTempLocator));
        int highTempC=convertAnyStringIntoInt(getTextFromElement(highTempLocator));
        int lowTempC=convertAnyStringIntoInt(getTextFromElement(lowTempLocator));
        temperaturesC.add(feelLikeTempC);
        temperaturesC.add(highTempC);
        temperaturesC.add(lowTempC);
    }

    public boolean compare(){
        boolean equal=true;
        for (int i=0; i<3; i++ ){
            int temp=Math.round (convertTempCtoF(temperaturesC.get(i)));
            if(temperaturesF.get(i)!=temp && temperaturesF.get(i)!=++temp && temperaturesF.get(i)!=--temp ){
                equal=false;

            }

        }
        return equal;
    }






}
