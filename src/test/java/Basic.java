import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Basic class for testing.
 */
public class Basic {

    String[] currentUser = Arrays.etalon;

    WebDriver driver;
    WebDriverWait wait;


    @BeforeClass
    public static void setterForDriver() {
        WebDriver driver;
        WebDriverWait wait;
        System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");

    }

    @Before
    public void loginToSoftwareLogo() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get(Paths.LOGIN_PAGE_URL);
        driver.findElement(By.xpath(".//tr[1]/td[2]/input")).sendKeys(currentUser[0]);
        driver.findElement(By.xpath(".//tr[2]/td[2]/input")).sendKeys(currentUser[1]);
        driver.findElement(By.xpath(".//tr[3]/td[2]/input")).click();
        assertEquals("Top",driver.getTitle());
        driver.findElement(By.xpath(".//*[@id='inventory']/a")).click();
    }



    @After
    public void tearDown() throws Exception {
        driver.close();
    }

}
