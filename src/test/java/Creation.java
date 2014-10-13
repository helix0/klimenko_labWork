import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static junit.framework.Assert.assertEquals;

/**
 * Class for testing of objects creations.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Creation extends Basic {

    //MethodsForCreation methods = new MethodsForCreation(driver);


    @Test
    public void b00creationOfTheCountry() {
        MethodsForCreation methods = new MethodsForCreation(driver);
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='table_header']//a[contains(.,'Create')]"))).click();
        driver.findElement(By.xpath(Paths.CREATE)).click();
        System.out.println(Arrays.country[0]);
        methods.fillingCreationForm(Arrays.country);
        String currentContinent = methods.selectionFromList(1);
        driver.findElement(By.xpath(Paths.SAVE)).click();
        assertEquals(driver.getTitle(), Arrays.country[0]);
        driver.getCurrentUrl();
    }


  @Test
    public void b12creationOfTheCity(){
        MethodsForCreation methods = new MethodsForCreation(driver);
        MethodsForNavigation navigate = new MethodsForNavigation(driver);
        navigate.findAndClick(Paths.COUNTRIES, Arrays.country[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Create city')]"))).click();
        methods.fillingCreationForm(Arrays.city);
        String selCity = methods.selectionFromList(1);
        driver.findElement(By.xpath(Paths.SAVE)).click();
        assertEquals(driver.getTitle(), Arrays.city[0]);
    }


    @Test
    public void b13creationOfTheBuilding(){
        MethodsForCreation methods = new MethodsForCreation(driver);
        MethodsForNavigation navigate = new MethodsForNavigation(driver);
        navigate.findAndClick(Paths.COUNTRIES, Arrays.country[0]);
        navigate.findAndClick(Paths.CITIES, Arrays.city[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.CREATE))).click();
        methods.fillingCreationForm(Arrays.building);
        String selBuilding = methods.selectionFromList(1);
        driver.findElement(By.xpath(Paths.SAVE)).click();
        assertEquals(driver.getTitle(), Arrays.building[0]);
    }

    @Test
    public void b14creationOfTheFloor(){
        MethodsForCreation methods = new MethodsForCreation(driver);
        MethodsForNavigation navigate = new MethodsForNavigation(driver);
        navigate.findAndClick(Paths.COUNTRIES, Arrays.country[0]);
        navigate.findAndClick(Paths.CITIES, Arrays.city[0]);
        navigate.findAndClick(Paths.BUILDINGS, Arrays.building[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.CREATE))).click();
        methods.fillingCreationForm(Arrays.floor);
        driver.findElement(By.xpath(Paths.SAVE)).click();
        String titlefl = "Floor#";
        String titleFloor = titlefl + Arrays.floor[0];
        assertEquals(driver.getTitle(), titleFloor);
    }

    @Test
    public void b15creationOfTheRoom(){
        MethodsForCreation methods = new MethodsForCreation(driver);
        MethodsForNavigation navigate = new MethodsForNavigation(driver);
        navigate.findAndClick(Paths.COUNTRIES, Arrays.country[0]);
        navigate.findAndClick(Paths.CITIES, Arrays.city[0]);
        navigate.findAndClick(Paths.BUILDINGS, Arrays.building[0]);
        navigate.findAndClick(Paths.FLOORS, "Floor#" + Arrays.floor[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.CREATE))).click();
        methods.fillingCreationForm(Arrays.room);
        driver.findElement(By.xpath(Paths.SAVE)).click();
        assertEquals(driver.getTitle(), Arrays.room[0]);
    }

    @Test
    public void b16creationOfTheRack(){
        MethodsForCreation methods = new MethodsForCreation(driver);
        MethodsForNavigation navigate = new MethodsForNavigation(driver);
        navigate.findAndClick(Paths.COUNTRIES, Arrays.country[0]);
        navigate.findAndClick(Paths.CITIES, Arrays.city[0]);
        navigate.findAndClick(Paths.BUILDINGS, Arrays.building[0]);
        navigate.findAndClick(Paths.FLOORS, "Floor#" + Arrays.floor[0]);
        navigate.findAndClick(Paths.ROOMS, Arrays.room[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.CREATE))).click();
        methods.fillingCreationForm(Arrays.rack);
        String rackPhisicalStatus = methods.selectionFromList(2);
        driver.findElement(By.xpath(Paths.SAVE)).click();
        assertEquals(driver.getTitle(), Arrays.rack[0]);
    }

    @Test
    public void b17creationOfTheDevice(){
        MethodsForCreation methods = new MethodsForCreation(driver);
        MethodsForNavigation navigate = new MethodsForNavigation(driver);
        navigate.findAndClick(Paths.COUNTRIES, Arrays.country[0]);
        navigate.findAndClick(Paths.CITIES, Arrays.city[0]);
        navigate.findAndClick(Paths.BUILDINGS, Arrays.building[0]);
        navigate.findAndClick(Paths.FLOORS, "Floor#" + Arrays.floor[0]);
        navigate.findAndClick(Paths.ROOMS, Arrays.room[0]);
        navigate.findAndClick(Paths.RACKS, Arrays.rack[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.CREATE))).click();
        methods.fillingCreationForm(Arrays.device);
        String devicePhisicalStatus = methods.selectionFromList(2);
        selectingInNewWindow();
        driver.findElement(By.xpath(Paths.SAVE)).click();
        assertEquals(driver.getTitle(), Arrays.device[0]);
    }

    @Test
    public void b18creationOfThePosterm(){
        MethodsForCreation methods = new MethodsForCreation(driver);
        MethodsForNavigation navigate = new MethodsForNavigation(driver);
        navigate.findAndClick(Paths.COUNTRIES, Arrays.country[0]);
        navigate.findAndClick(Paths.CITIES, Arrays.city[0]);
        navigate.findAndClick(Paths.BUILDINGS, Arrays.building[0]);
        navigate.findAndClick(Paths.FLOORS, "Floor#" + Arrays.floor[0]);
        navigate.findAndClick(Paths.ROOMS, Arrays.room[0]);
        navigate.findAndClick(Paths.RACKS, Arrays.rack[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Post Terminal (s)']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='j_idt76:tabView:j_idt151']//a[contains(.,'Create')]"))).click();
        methods.fillingCreationForm(Arrays.posterm);
        String postermPhisicalStatus = methods.selectionFromList(2);
        selectingInNewWindow();
        driver.findElement(By.xpath(Paths.SAVE)).click();
        assertEquals(driver.getTitle(), Arrays.posterm[0]);
    }

    @Test
    public void b19creationOfThePayBox(){
        MethodsForCreation methods = new MethodsForCreation(driver);
        MethodsForNavigation navigate = new MethodsForNavigation(driver);
        navigate.findAndClick(Paths.COUNTRIES, Arrays.country[0]);
        navigate.findAndClick(Paths.CITIES, Arrays.city[0]);
        navigate.findAndClick(Paths.BUILDINGS, Arrays.building[0]);
        navigate.findAndClick(Paths.FLOORS, "Floor#" + Arrays.floor[0]);
        navigate.findAndClick(Paths.ROOMS, Arrays.room[0]);
        navigate.findAndClick(Paths.RACKS, Arrays.rack[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Pay Box (s)']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='j_idt76:tabView:j_idt136']//a[contains(.,'Create')]"))).click();
        methods.fillingCreationForm(Arrays.payBox);
        String payBoxPhisicalStatus = methods.selectionFromList(2);
        selectingInNewWindow();
        driver.findElement(By.xpath(Paths.SAVE)).click();
        assertEquals(Arrays.payBox[0],driver.getTitle());
    }

    @Test
    public void b20creationOfTheAtm(){
        MethodsForCreation methods = new MethodsForCreation(driver);
        MethodsForNavigation navigate = new MethodsForNavigation(driver);
        navigate.findAndClick(Paths.COUNTRIES, Arrays.country[0]);
        navigate.findAndClick(Paths.CITIES, Arrays.city[0]);
        navigate.findAndClick(Paths.BUILDINGS, Arrays.building[0]);
        navigate.findAndClick(Paths.FLOORS, "Floor#" + Arrays.floor[0]);
        navigate.findAndClick(Paths.ROOMS, Arrays.room[0]);
        navigate.findAndClick(Paths.RACKS, Arrays.rack[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='ATM (s)']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='j_idt76:tabView:j_idt121']//a[contains(.,'Create')]"))).click();
        methods.fillingCreationForm(Arrays.atm);
        String atmPhisicalStatus = methods.selectionFromList(2);
        selectingInNewWindow();
        driver.findElement(By.xpath(Paths.SAVE)).click();
        assertEquals(Arrays.atm[0], driver.getTitle());
    }

    public void selectingInNewWindow(){
        List<WebElement> selecting = driver.findElements(By.xpath("//div[@id='table_data']//td/a[text()='select ']"));
        for (WebElement elem : selecting){
            String originalWindow = driver.getWindowHandle();
            final Set<String> oldWindowsSet = driver.getWindowHandles();
            elem.click();
            String newWindow = (new WebDriverWait(driver, 10))
                    .until(new ExpectedCondition<String>() {
                               public String apply(WebDriver driver) {
                                   Set<String> newWindowsSet = driver.getWindowHandles();
                                   newWindowsSet.removeAll(oldWindowsSet);
                                   return newWindowsSet.size() > 0 ?
                                           newWindowsSet.iterator().next() : null;
                               }
                           }
                    );

            driver.switchTo().window(newWindow);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a")));
            List<WebElement> countries = driver.findElements(By.xpath("//a"));
            for (WebElement element : countries){
                if (element.getText().equals("Country: " + Arrays.country[0])){
                    element.click();
                    break;
                }
            }
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='OK']"))).click();
            driver.switchTo().window(originalWindow);
        }
    }
}
