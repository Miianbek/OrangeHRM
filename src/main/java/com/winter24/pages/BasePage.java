package com.winter24.pages;

import com.winter24.drivers.DriverManager;
import com.winter24.enums.Endpoints;
import com.winter24.helper.BrowserHelper;
import com.winter24.helper.DropdownHelper;
import com.winter24.helper.WebElementActions;
import com.winter24.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
    public WebElementActions webElementActions = new WebElementActions();
    public DropdownHelper dropdownHelper = new DropdownHelper(DriverManager.getDriver());
    public BrowserHelper browserHelper = new BrowserHelper(DriverManager.getDriver());




    @FindBy(xpath = "//input[@name='username']")
    public WebElement userNameInput;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")

    public WebElement loginBtn;

    // Метод для открытия соответствующего эндпоинта
    public void openEndpoint1(Endpoints endpoint) {
        browserHelper.open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        webElementActions.sendKeys(userNameInput, "Admin")
                .sendKeys(passwordInput, "admin123")
                .click(loginBtn);
        browserHelper.open(ConfigReader.getValue("baseDevURL") + endpoint.getEndpoint());

    }
}
