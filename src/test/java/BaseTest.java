import com.winter24.drivers.DriverManager;
import com.winter24.helper.BrowserHelper;
import com.winter24.helper.DropdownHelper;
import com.winter24.helper.WebElementActions;
import com.winter24.pages.OrangeHRMpages;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;
    protected RandomUtils randomUtils;
    protected WebElementActions webElementActions;
    protected BrowserHelper browserHelper;
    protected DropdownHelper dropdownHelper;
    protected OrangeHRMpages orangeHRMpages;



    @BeforeClass(alwaysRun = true)
    public void setUp (){
        driver= DriverManager.getDriver();
        randomUtils= new RandomUtils();
        webElementActions= new WebElementActions();
        browserHelper= new BrowserHelper(driver);
        dropdownHelper= new DropdownHelper(driver);
        orangeHRMpages= new OrangeHRMpages();



    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverManager.closeDriver();

    }
}
