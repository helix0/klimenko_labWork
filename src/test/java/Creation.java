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
    static final String CREATE = "//div[@id='table_header']//a[contains(.,'Create')]";
    static final String ROWS = "//div[@id='table_data']//td/input";
    static final String SAVE = ".//*[@id='table_header']//*/input";
    static final String COUNTRIES = "//tbody[@id='j_idt76:tabView:j_idt89_data']//a";
    static final String CITIES = "//tbody[@id='j_idt76:tabView:j_idt109_data']//a";
    static final String BUILDINGS = "//tbody[@id='j_idt76:tabView:j_idt109_data']//a";
    static final String FLOORS = "//tbody[@id='j_idt76:tabView:j_idt113_data']//a";
    static final String ROOMS = "//tbody[@id='j_idt76:tabView:j_idt109_data']//a";
    static final String RACKS = "//tbody[@id='j_idt76:tabView:j_idt107_data']//a";
    static final String POSTERM = "//tbody[@id='j_idt76:tabView:j_idt158_data']//a";
    static final String DEVICE = "//tbody[@id='j_idt76:tabView:j_idt113_data']//a";
    static final String PAYBOX = "//tbody[@id='j_idt76:tabView:j_idt143_data']//a";
    static final String ATM = "//tbody[@id='j_idt76:tabView:j_idt128_data']//a";

    private void fillingForm(String[] array){
        List<WebElement> arrayRows = driver.findElements(By.xpath(ROWS));
        for (int i = 0; i < array.length; i++) {
            arrayRows.get(i).sendKeys(array[i]);
        }
    }

    private void selectingInNewWindow(){
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
                if (element.getText().equals("Country: " + country[0])){
                    element.click();
                    break;
                }
            }
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='OK']"))).click();
            driver.switchTo().window(originalWindow);
        }
    }


    @Test
    public void b00creationOfTheCountry() {
        driver.findElement(By.xpath(CREATE)).click();
        fillingForm(country);
        String currentContinent = selectionFromList(1);
        driver.findElement(By.xpath(SAVE)).click();
        assertEquals(driver.getTitle(), country[0]);
        driver.getCurrentUrl();
    }


    @Test
    public void b12creationOfTheCity(){
        findAndClick(COUNTRIES,country[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Create city')]"))).click();
        fillingForm(city);
        String selCity = selectionFromList(1);
        driver.findElement(By.xpath(SAVE)).click();
        assertEquals(driver.getTitle(), city[0]);
    }


    @Test
    public void b13creationOfTheBuilding(){
        findAndClick(COUNTRIES,country[0]);
        findAndClick(CITIES,city[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CREATE))).click();
        fillingForm(building);
        String selBuilding = selectionFromList(1);
        driver.findElement(By.xpath(SAVE)).click();
        assertEquals(driver.getTitle(), building[0]);
    }

    @Test
    public void b14creationOfTheFloor(){
        findAndClick(COUNTRIES,country[0]);
        findAndClick(CITIES,city[0]);
        findAndClick(BUILDINGS,building[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CREATE))).click();
        fillingForm(floor);
        driver.findElement(By.xpath(SAVE)).click();
        String titlefl = "Floor#";
        String titleFloor = titlefl + floor[0];
        assertEquals(driver.getTitle(), titleFloor);
    }

    @Test
    public void b15creationOfTheRoom(){
        findAndClick(COUNTRIES,country[0]);
        findAndClick(CITIES,city[0]);
        findAndClick(BUILDINGS,building[0]);
        findAndClick(FLOORS,"Floor#" + floor[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CREATE))).click();
        fillingForm(room);
        driver.findElement(By.xpath(SAVE)).click();
        assertEquals(driver.getTitle(), room[0]);
    }

    @Test
    public void b16creationOfTheRack(){
        findAndClick(COUNTRIES,country[0]);
        findAndClick(CITIES,city[0]);
        findAndClick(BUILDINGS,building[0]);
        findAndClick(FLOORS,"Floor#" + floor[0]);
        findAndClick(ROOMS,room[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CREATE))).click();
        fillingForm(rack);
        String rackPhisicalStatus = selectionFromList(2);
        driver.findElement(By.xpath(SAVE)).click();
        assertEquals(driver.getTitle(), rack[0]);
    }

    @Test
    public void b17creationOfTheDevice(){
        findAndClick(COUNTRIES,country[0]);
        findAndClick(CITIES,city[0]);
        findAndClick(BUILDINGS,building[0]);
        findAndClick(FLOORS,"Floor#" + floor[0]);
        findAndClick(ROOMS,room[0]);
        findAndClick(RACKS,rack[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CREATE))).click();
        fillingForm(device);
        String devicePhisicalStatus = selectionFromList(2);
        selectingInNewWindow();
        driver.findElement(By.xpath(SAVE)).click();
        assertEquals(driver.getTitle(), device[0]);
    }

    @Test
    public void b18creationOfThePosterm(){
        findAndClick(COUNTRIES,country[0]);
        findAndClick(CITIES,city[0]);
        findAndClick(BUILDINGS,building[0]);
        findAndClick(FLOORS,"Floor#" + floor[0]);
        findAndClick(ROOMS,room[0]);
        findAndClick(RACKS,rack[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Post Terminal (s)']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='j_idt76:tabView:j_idt151']//a[contains(.,'Create')]"))).click();
        fillingForm(posterm);
        String postermPhisicalStatus = selectionFromList(2);
        selectingInNewWindow();
        driver.findElement(By.xpath(SAVE)).click();
        assertEquals(driver.getTitle(), posterm[0]);
    }

    @Test
    public void b19creationOfThePayBox(){
        findAndClick(COUNTRIES,country[0]);
        findAndClick(CITIES,city[0]);
        findAndClick(BUILDINGS,building[0]);
        findAndClick(FLOORS,"Floor#" + floor[0]);
        findAndClick(ROOMS,room[0]);
        findAndClick(RACKS,rack[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Pay Box (s)']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='j_idt76:tabView:j_idt136']//a[contains(.,'Create')]"))).click();
        fillingForm(payBox);
        String payBoxPhisicalStatus = selectionFromList(2);
        selectingInNewWindow();
        driver.findElement(By.xpath(SAVE)).click();
        assertEquals(payBox[0],driver.getTitle());
    }

    @Test
    public void b20creationOfTheAtm(){
        findAndClick(COUNTRIES,country[0]);
        findAndClick(CITIES,city[0]);
        findAndClick(BUILDINGS,building[0]);
        findAndClick(FLOORS,"Floor#" + floor[0]);
        findAndClick(ROOMS,room[0]);
        findAndClick(RACKS,rack[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='ATM (s)']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='j_idt76:tabView:j_idt121']//a[contains(.,'Create')]"))).click();
        fillingForm(atm);
        String atmPhisicalStatus = selectionFromList(2);
        selectingInNewWindow();
        driver.findElement(By.xpath(SAVE)).click();
        assertEquals(atm[0], driver.getTitle());
    }

}
