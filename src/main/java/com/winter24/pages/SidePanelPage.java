package com.winter24.pages;

import com.winter24.drivers.DriverManager;
import com.winter24.enums.Endpoints;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class SidePanelPage extends BasePage {


    public SidePanelPage chooseSidebarMenu(Endpoints endpoints) {
        WebElement element = DriverManager.getDriver().findElement(By.xpath("//ul[@class='oxd-main-menu']/li/a/span[text()='" + endpoints.getMenu() +"']"));
        element.click();
        return this;
    }



}
