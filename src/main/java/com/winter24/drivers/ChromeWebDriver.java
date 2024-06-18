package com.winter24.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static com.winter24.utils.ConfigReader.getValue;

public class ChromeWebDriver {

    public static WebDriver loadChromeDriver()  {

        WebDriverManager.chromedriver().setup();



        ChromeOptions options= new ChromeOptions();

        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-extensions");
        options.addArguments("--window-size-1920,1080");
        options.addArguments("--no-sandbox");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
//        SafariOptions browserOptions = new SafariOptions();
//        browserOptions.setPlatformName("macOS 13");
//        browserOptions.setBrowserVersion("latest");
//        Map<String, Object> sauceOptions = new HashMap<>();
//        sauceOptions.put("username", "oauth-miianbek.iliazbek-c6c13");
//        sauceOptions.put("accessKey", "bd8ce7f8-6d3a-4a10-b5bc-a1c53e9e8256");
//        sauceOptions.put("build", "<your build id>");
//        sauceOptions.put("name", "<your test name>");
//        browserOptions.setCapability("sauce:options", sauceOptions);
//
//        URL url = null;
//        try {
//            url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
//        RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);


        if(Boolean.parseBoolean(getValue("headless"))) {
            options.addArguments("--headless");
        }
        WebDriver driver= new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
}
