package com.winter24.helper;

import org.openqa.selenium.WebDriver;

import java.util.LinkedList;
import java.util.Set;

public class BrowserHelper {
    private WebDriver driver;

    public BrowserHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void  open (String url) {
        driver.navigate().to(url);
    }
    public void goBack () {
        driver.navigate().back();
    }

    public void goForward () {
        driver.navigate().forward();
    }

    public void refreshPage () {
        driver.navigate().refresh();
    }

    public Set<String> getWindowHnadles() {
        return driver.getWindowHandles();
    }

    public void switchToWindows(int index) {
        LinkedList<String> windowsID= new LinkedList<>(getWindowHnadles());

        if (index<0 || index> windowsID.size()) {
            throw new IllegalArgumentException("Invalid index:"+ index);



        }
        driver.switchTo().window(windowsID.get(index));


    }
    public void switchToParentWindow() {
        LinkedList <String> windowsID= new LinkedList<>(getWindowHnadles());
        driver.switchTo().window(windowsID.get(0));

    }
    public void switchToParentWithCloseChild () {
        switchToParentWindow();
        LinkedList <String> windowsID= new LinkedList<>(getWindowHnadles());
        for (int i= 1; i<windowsID.size();i++) {
            driver.switchTo().window(windowsID.get(i));
            driver.close();

        }
        switchToParentWindow();

    }
}
