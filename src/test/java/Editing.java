import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Class for testing of objects editing.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Editing extends Basic {

    static final String PARAMETERS = "//div[@id='j_idt76:tabView']//a[text()='Parameters']";
    static final String EDIT = "//div[@id='j_idt76:tabView']//a[contains(.,'Edit')]";
    static final String AFTER_EDIT = "//div[@id='j_idt76:tabView:tab2']//div[@id='table_data']//td[@class='parameter']";
    static final String SAVE = "//form[@id='j_idt74']//input[@value='Save']";
    static final String SELECTED = "//select/option[@selected]";
    static final String ROWS = "//form[@id='j_idt74']//div[@id='table_data']//td/input";


    public void fillingForm(String[] newArray){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ROWS)));
        List<WebElement> rows = driver.findElements(By.xpath(ROWS));
        for(int i = 0; i < newArray.length; i++ ) {
            if(newArray[i] != null) {
                rows.get(i).clear();
                rows.get(i).sendKeys(newArray[i]);
            }
        }
    }

    public String[] actualParameters(){
        List<WebElement> afterEdit = driver.findElements(By.xpath(AFTER_EDIT));
        String[] actual = new String[afterEdit.size()];
        for(int i = 0; i < afterEdit.size(); i++) {
            if (i == 3 || i == 5) i++;
            actual[i] = afterEdit.get(i).getText();
        }
        return actual;
    }

    @Test
    public void c00(){
        findAndClick(Creation.COUNTRIES,country[0]);
        assertEquals(driver.getTitle(),country[0]);
    }

    @Test
    public void c10editingCountry(){
        findAndClick(Creation.COUNTRIES,country[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PARAMETERS))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EDIT))).click();
        fillingForm(newCountry);
        String select = driver.findElement(By.xpath(SELECTED)).getText();
        driver.findElement(By.xpath(SAVE)).click();
        String[] currentCountry = checkChanges(country,newCountry);
        String[] expected = new String[]{currentCountry[0],"Country",currentUser[0],null,currentUser[0],null,select,currentCountry[1]};
        String[] actual = actualParameters();
        for(int i = 0; i < actual.length; i++) {
            assertEquals(expected[i],actual[i]);
        }

    }

    @Test
    public void c11editingCity(){
        navigatingToCity();
        findAndClick(Creation.CITIES,city[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PARAMETERS))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EDIT))).click();
        fillingForm(newCity);
        String select = driver.findElement(By.xpath(SELECTED)).getText();
        driver.findElement(By.xpath(SAVE)).click();
        String[] currentCity = checkChanges(city,newCity);
        String[] expected = new String[]{currentCity[0],"City",etalon[0],null,etalon[0],null,currentCity[1],select};
        String[] actual = actualParameters();
        for(int i = 0; i < actual.length; i++) {
            assertEquals(expected[i],actual[i]);
        }

    }

   @Test
    public void c12editingBuilding(){
       navigatingToBuilding();
        findAndClick(Creation.BUILDINGS,building[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PARAMETERS))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EDIT))).click();
        fillingForm(newBuilding);
        String select = driver.findElement(By.xpath(SELECTED)).getText();
        driver.findElement(By.xpath(SAVE)).click();
        String[] currentBuilding = checkChanges(city,newCity);
        String[] expected = new String[]{currentBuilding[0],"Building",etalon[0],null,etalon[0],null,currentBuilding[1],currentBuilding[2],currentBuilding[3],select};
        String[] actual = actualParameters();
        for(int i = 0; i < actual.length; i++) {
            assertEquals(expected[i],actual[i]);
        }
    }

    @Test
    public void c13editingFloor(){
        navigatingToFloor();
        findAndClick(Creation.FLOORS,"Floor#" + floor[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PARAMETERS))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EDIT))).click();
        fillingForm(newFloor);
        driver.findElement(By.xpath(SAVE)).click();
        String[] current = checkChanges(floor,newFloor);
        String[] expected = new String[]{"Floor#" + current[0],"Floor",etalon[0],null,etalon[0],null,current[0],current[1]};
        String[] actual = actualParameters();
        for(int i = 0; i < actual.length; i++) {
            assertEquals(expected[i],actual[i]);
        }
    }

    @Test
    public void c14editingRoom(){
        navigatingToRoom();
        findAndClick(Creation.ROOMS,room[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PARAMETERS))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EDIT))).click();
        fillingForm(newRoom);
        driver.findElement(By.xpath(SAVE)).click();
        String[] current = checkChanges(room,newRoom);
        String[] expected = new String[]{current[0],"Room",etalon[0],null,etalon[0],null,current[1]};
        String[] actual = actualParameters();
        for(int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void c15editingRack(){
        navigatingToRack();
        findAndClick(Creation.RACKS,rack[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PARAMETERS))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EDIT))).click();
        fillingForm(newRack);
        String select = driver.findElement(By.xpath(SELECTED)).getText();
        driver.findElement(By.xpath(SAVE)).click();
        String[] current = checkChanges(rack,newRack);
        String[] expected = new String[]{current[0],"Rack",etalon[0],null,etalon[0],null,current[1],current[2],current[3],select};
        String[] actual = actualParameters();
        for(int i = 0; i < actual.length; i++) {
            assertEquals(expected[i],actual[i]);
        }
    }

    @Test
    public void c16editingDevice(){
        navigatingToDevice();
        findAndClick(Creation.DEVICE,device[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EDIT))).click();
        fillingForm(newDevice);
        String select = driver.findElement(By.xpath(SELECTED)).getText();
        String located = driver.findElement(By.xpath("//td[@class='parameter']/input[@id='j_idt74:locatedIn']")).getAttribute("value");
        String networkElement = driver.findElement(By.xpath("//td[@class='parameter']/input[@id='j_idt74:networkElementName']")).getAttribute("value");
        driver.findElement(By.xpath(SAVE)).click();
        String[] current = checkChanges(posterm,newPosterm);
        String[] expected = new String[]{current[0],"Device",etalon[0],null,etalon[0],null,current[1],current[2],current[3],current[4],select,current[5],current[6],current[7],located,networkElement};
        String[] actual = actualParameters();
        for(int i = 0; i < actual.length; i++) {
            assertEquals(expected[i],actual[i]);
        }
    }

    @Test
    public void c17editingPosterm(){
        navigatingToPosterm();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Creation.POSTERM)));
        findAndClick(Creation.POSTERM,posterm[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EDIT))).click();
        fillingForm(newPosterm);
        String select = driver.findElement(By.xpath(SELECTED)).getText();
        String located = driver.findElement(By.xpath("//td[@class='parameter']/input[@id='j_idt74:locatedIn']")).getAttribute("value");
        System.out.println(located);
        driver.findElement(By.xpath(SAVE)).click();
        String[] current = checkChanges(posterm,newPosterm);
        String[] expected = new String[]{current[0],"POS Term",etalon[0],null,etalon[0],null,current[1],current[2],current[3],select,"Country: " + located};
        String[] actual = actualParameters();
        for(int i = 0; i < actual.length; i++) {
            assertEquals(expected[i],actual[i]);
        }
    }

    @Test
    public void c18editingPayBox(){
        navigatingToPayBox();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Creation.PAYBOX)));
        findAndClick(Creation.PAYBOX,payBox[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EDIT))).click();
        fillingForm(newPayBox);
        String select = driver.findElement(By.xpath(SELECTED)).getText();
        String located = driver.findElement(By.xpath("//td[@class='parameter']/input[@id='j_idt74:locatedIn']")).getAttribute("value");
        driver.findElement(By.xpath(SAVE)).click();
        String[] current = checkChanges(payBox,newPayBox);
        String[] expected = new String[]{current[0],"Pay Box",etalon[0],null,etalon[0],null,current[1],current[2],select,"Country: " + located};
        String[] actual = actualParameters();
        for(int i = 0; i < actual.length; i++) {
            assertEquals(expected[i],actual[i]);
        }
    }

    @Test
    public void c19editingAtm(){
        navigatingToAtm();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Creation.ATM)));
        findAndClick(Creation.ATM,atm[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EDIT))).click();
        fillingForm(newAtm);
        String select = driver.findElement(By.xpath(SELECTED)).getText();
        String located = driver.findElement(By.xpath("//td[@class='parameter']/input[@id='j_idt74:locatedIn']")).getAttribute("value");
        driver.findElement(By.xpath(SAVE)).click();
        String[] current = checkChanges(atm,newAtm);
        String[] expected = new String[]{current[0],"ATM",etalon[0],null,etalon[0],null,current[1],current[2],select,"Country: " + located};
        String[] actual = actualParameters();
        for(int i = 0; i < actual.length; i++) {
            assertEquals(expected[i],actual[i]);
        }
    }

}
