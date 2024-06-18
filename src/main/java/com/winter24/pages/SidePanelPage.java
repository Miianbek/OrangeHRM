package com.winter24.pages;

import com.winter24.drivers.DriverManager;
import com.winter24.enums.Endpoints;
import com.winter24.enums.SideBarMenuEnums;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.winter24.enums.SideBarMenuEnums.ADMIN;

public class SidePanelPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Username']")
    public WebElement userNameInput;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement passwordInput;


    public SidePanelPage chooseSidebarMenu(Endpoints sidebarMenuName) {
        WebElement element = DriverManager.getDriver().findElement(By.xpath("//ul[@class='oxd-main-menu']/li/a/span[text()='" + sidebarMenuName.getMenu() +"']"));
        element.click();
        return this;
    }


    public SidePanelPage fillUpUserPassword(String userName, String password) {
        webElementActions.sendKeys(userNameInput, "Admin")
                .sendKeys(passwordInput, "admin123");

        return this;
    }
}
