import com.winter24.drivers.DriverManager;
import com.winter24.enums.Endpoints;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SidePanelTest extends BaseTest{
    @Test
    public void selectSidePanelTest() {
        browserHelper.open("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");

        // открывается окно для введения парля и логина
//        orangeHRMpages.getSidePanelPage().fillUpUserPassword("Admin", "admin123");
        orangeHRMpages.getSidePanelPage().fillUpUserPassword("Admin","admin123");


        webElementActions.pause(5); // ждем 5 секунд
        orangeHRMpages.getSidePanelPage().chooseSidebarMenu(Endpoints.DIRECTORY); // здесь указать нужную вкладку
        webElementActions.pause(5);

    }
}
