package com.winter24.helper;

import com.winter24.drivers.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebElementActions {
    public Actions actions=new Actions(DriverManager.getDriver());



    public WebElementActions click(WebElement element) {

        waitElementToBeClickAble(element);
        scrollToElement(element);
        highLightElement(element);
        element.click();
        return this;
    }

    public WebElementActions sendKeys(WebElement element, String txt) {
        waitElementToBeVisible(element);
//        scrollToElement(element);
        highLightElement(element);
        element.sendKeys(txt);
        return this;
    }

    public WebElementActions sendKeysWithEnter(WebElement element, String txt) {
        waitElementToBeVisible(element);
        scrollToElement(element);
        element.sendKeys(txt);
        element.sendKeys(Keys.ENTER);
        return this;
    }

    public WebElementActions waitElementToBeClickAble (WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }
    public WebElementActions waitElementToBeVisible (WebElement element) {
        new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public WebElementActions scrollToElement (WebElement element) {
        JavascriptExecutor js= (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",element);
        return this;
    }

    public WebElementActions jsClick(WebElement element) {
        JavascriptExecutor js=(JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].click();",element);
        return this;
    }

    public WebElementActions highLightElement(WebElement element) {
        JavascriptExecutor js=(JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].style.border='3px solid green'",element);
        return this;
    }

    public WebElementActions jsSendKeys(WebElement element, String txt) {
        JavascriptExecutor js=(JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].value = arguments[1];", element, txt);
        return this;
    }

    public WebElementActions doubleClick (WebElement element) {
        waitElementToBeVisible(element);
        waitElementToBeClickAble(element);
        actions.doubleClick(element).perform();
        return this;
    }

    public WebElementActions rightClick (WebElement element) {
        waitElementToBeVisible(element);
        waitElementToBeClickAble(element);
        actions.contextClick(element).perform();
        return this;
    }

    public WebElementActions moveToElement(WebElement element) {
        waitElementToBeVisible(element);
        actions.moveToElement(element).perform();
        return this;
    }
    public WebElementActions pause(Integer Seconds){
        try {
            TimeUnit.SECONDS.sleep(Seconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return this;
    }

}
