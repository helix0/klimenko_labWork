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
public class Basic extends Arrays{

    String[] currentUser = etalon;
    static final String SELECT_OPTION = "//select/option";

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
        driver.get(LOGIN_PAGE_URL);
        driver.findElement(By.xpath(".//tr[1]/td[2]/input")).sendKeys(currentUser[0]);
        driver.findElement(By.xpath(".//tr[2]/td[2]/input")).sendKeys(currentUser[1]);
        driver.findElement(By.xpath(".//tr[3]/td[2]/input")).click();
        assertEquals("Top",driver.getTitle());
        driver.findElement(By.xpath(".//*[@id='inventory']/a")).click();
    }

    public void findAndClick(String objects, String title){
        List<WebElement> count = driver.findElements(By.xpath(objects));
        for (WebElement element : count){
            if (element.getText().equals(title)){
                element.click();
                break;
            }
        }
    }

    public String selectionFromList(int n){
        List<WebElement> select = driver.findElements(By.xpath(SELECT_OPTION));
        WebElement choose = select.get(n);
        choose.click();
        return choose.getText();
    }

    public String[] checkChanges(String[] oldObject, String[] newObject){
        String [] currentObject = new String[oldObject.length];
        for(int i = 0; i < oldObject.length; i++ ) {
            if (newObject[i] != null){
                currentObject[i] = newObject[i];
            } else
                currentObject[i] = oldObject[i];
        }
        return currentObject;
    }

    public String objectTitle(String[] object, String[] newObject){
        String[] currentArray = checkChanges(object,newObject);
        return currentArray[0];
    }

    public void navigatingToAtm(){
        findAndClick(Creation.COUNTRIES,newCountry[0]);
        findAndClick(Creation.CITIES,newCity[0]);
        findAndClick(Creation.BUILDINGS,newBuilding[0]);
        findAndClick(Creation.FLOORS,"Floor#" + newFloor[0]);
        findAndClick(Creation.ROOMS,newRoom[0]);
        findAndClick(Creation.RACKS,newRack[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/a[text()='ATM (s)']"))).click();

    }
    public void navigatingToPayBox(){
        findAndClick(Creation.COUNTRIES,newCountry[0]);
        findAndClick(Creation.CITIES,newCity[0]);
        findAndClick(Creation.BUILDINGS,newBuilding[0]);
        findAndClick(Creation.FLOORS,"Floor#" + newFloor[0]);
        findAndClick(Creation.ROOMS,newRoom[0]);
        findAndClick(Creation.RACKS,newRack[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/a[text()='Pay Box (s)']"))).click();

    }

    public void navigatingToPosterm(){
        findAndClick(Creation.COUNTRIES,newCountry[0]);
        findAndClick(Creation.CITIES,newCity[0]);
        findAndClick(Creation.BUILDINGS,newBuilding[0]);
        findAndClick(Creation.FLOORS,"Floor#" + newFloor[0]);
        findAndClick(Creation.ROOMS,newRoom[0]);
        findAndClick(Creation.RACKS,newRack[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/a[text()='Post Terminal (s)']"))).click();
    }

    public void navigatingToDevice(){
        findAndClick(Creation.COUNTRIES,newCountry[0]);
        findAndClick(Creation.CITIES,newCity[0]);
        findAndClick(Creation.BUILDINGS,newBuilding[0]);
        findAndClick(Creation.FLOORS,"Floor#" + newFloor[0]);
        findAndClick(Creation.ROOMS,newRoom[0]);
        findAndClick(Creation.RACKS,newRack[0]);
    }

    public void navigatingToRack(){
        findAndClick(Creation.COUNTRIES,newCountry[0]);
        findAndClick(Creation.CITIES,newCity[0]);
        findAndClick(Creation.BUILDINGS,newBuilding[0]);
        findAndClick(Creation.FLOORS,"Floor#" + newFloor[0]);
        findAndClick(Creation.ROOMS,newRoom[0]);
    }

    public void navigatingToRoom(){
        findAndClick(Creation.COUNTRIES,newCountry[0]);
        findAndClick(Creation.CITIES,newCity[0]);
        findAndClick(Creation.BUILDINGS,newBuilding[0]);
        findAndClick(Creation.FLOORS,"Floor#" + newFloor[0]);
    }

    public void navigatingToFloor(){
        findAndClick(Creation.COUNTRIES,newCountry[0]);
        findAndClick(Creation.CITIES,newCity[0]);
        findAndClick(Creation.BUILDINGS,newBuilding[0]);
    }

    public void navigatingToBuilding(){
        findAndClick(Creation.COUNTRIES,newCountry[0]);
        findAndClick(Creation.CITIES,newCity[0]);
    }
    public void navigatingToCity(){
        findAndClick(Creation.COUNTRIES,newCountry[0]);
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

}
