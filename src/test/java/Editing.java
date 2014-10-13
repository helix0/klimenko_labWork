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


    @Test
    public void c00(){
        MethodsForNavigation navigate = new MethodsForNavigation(driver);
        navigate.findAndClick(Paths.COUNTRIES, Arrays.country[0]);
        assertEquals(driver.getTitle(),Arrays.country[0]);
    }

    @Test
    public void c10editingCountry(){
        MethodsForNavigation navigate = new MethodsForNavigation(driver);
        MethodsForEditing edit = new MethodsForEditing(driver);
        navigate.findAndClick(Paths.COUNTRIES, Arrays.country[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.PARAMETERS))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.EDIT))).click();
        edit.fillingEditingForm(Arrays.newCountry);
        String select = driver.findElement(By.xpath(Paths.SELECTED)).getText();
        driver.findElement(By.xpath(Paths.SAVE_EDITING)).click();
        String[] currentCountry = edit.checkChanges(Arrays.country, Arrays.newCountry);
        String[] expected = new String[]{currentCountry[0],"Country",currentUser[0],null,currentUser[0],null,select,currentCountry[1]};
        String[] actual = edit.actualParameters();
        for(int i = 0; i < actual.length; i++) {
            assertEquals(expected[i],actual[i]);
        }

    }

    @Test
    public void c11editingCity(){
        MethodsForNavigation navigate = new MethodsForNavigation(driver);
        MethodsForEditing edit = new MethodsForEditing(driver);
        navigate.navigatingToCity();
        navigate.findAndClick(Paths.CITIES, Arrays.city[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.PARAMETERS))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.EDIT))).click();
        edit.fillingEditingForm(Arrays.newCity);
        String select = driver.findElement(By.xpath(Paths.SELECTED)).getText();
        driver.findElement(By.xpath(Paths.SAVE_EDITING)).click();
        String[] currentCity = edit.checkChanges(Arrays.city, Arrays.newCity);
        String[] expected = new String[]{currentCity[0],"City",Arrays.etalon[0],null,Arrays.etalon[0],null,currentCity[1],select};
        String[] actual = edit.actualParameters();
        for(int i = 0; i < actual.length; i++) {
            assertEquals(expected[i],actual[i]);
        }

    }

   @Test
    public void c12editingBuilding(){
        MethodsForNavigation navigate = new MethodsForNavigation(driver);
        MethodsForEditing edit = new MethodsForEditing(driver);
        navigate.navigatingToBuilding();
        navigate.findAndClick(Paths.BUILDINGS,Arrays.building[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.PARAMETERS))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.EDIT))).click();
        edit.fillingEditingForm(Arrays.newBuilding);
        String select = driver.findElement(By.xpath(Paths.SELECTED)).getText();
        driver.findElement(By.xpath(Paths.SAVE_EDITING)).click();
        String[] currentBuilding = edit.checkChanges(Arrays.city, Arrays.newCity);
        String[] expected = new String[]{currentBuilding[0],"Building",Arrays.etalon[0],null,Arrays.etalon[0],null,currentBuilding[1],currentBuilding[2],currentBuilding[3],select};
        String[] actual = edit.actualParameters();
        for(int i = 0; i < actual.length; i++) {
            assertEquals(expected[i],actual[i]);
        }
    }

    @Test
    public void c13editingFloor(){
        MethodsForNavigation navigate = new MethodsForNavigation(driver);
        MethodsForEditing edit = new MethodsForEditing(driver);
        navigate.navigatingToFloor();
        navigate.findAndClick(Paths.FLOORS, "Floor#" + Arrays.floor[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.PARAMETERS))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.EDIT))).click();
        edit.fillingEditingForm(Arrays.newFloor);
        driver.findElement(By.xpath(Paths.SAVE_EDITING)).click();
        String[] current = edit.checkChanges(Arrays.floor, Arrays.newFloor);
        String[] expected = new String[]{"Floor#" + current[0],"Floor",Arrays.etalon[0],null,Arrays.etalon[0],null,current[0],current[1]};
        String[] actual = edit.actualParameters();
        for(int i = 0; i < actual.length; i++) {
            assertEquals(expected[i],actual[i]);
        }
    }

    @Test
    public void c14editingRoom(){
        MethodsForNavigation navigate = new MethodsForNavigation(driver);
        MethodsForEditing edit = new MethodsForEditing(driver);
        navigate.navigatingToRoom();
        navigate.findAndClick(Paths.ROOMS, Arrays.room[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.PARAMETERS))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.EDIT))).click();
        edit.fillingEditingForm(Arrays.newRoom);
        driver.findElement(By.xpath(Paths.SAVE_EDITING)).click();
        String[] current = edit.checkChanges(Arrays.room, Arrays.newRoom);
        String[] expected = new String[]{current[0],"Room",Arrays.etalon[0],null,Arrays.etalon[0],null,current[1]};
        String[] actual = edit.actualParameters();
        for(int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void c15editingRack(){
        MethodsForNavigation navigate = new MethodsForNavigation(driver);
        MethodsForEditing edit = new MethodsForEditing(driver);
        navigate.navigatingToRack();
        navigate.findAndClick(Paths.RACKS, Arrays.rack[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.PARAMETERS))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.EDIT))).click();
        edit.fillingEditingForm(Arrays.newRack);
        String select = driver.findElement(By.xpath(Paths.SELECTED)).getText();
        driver.findElement(By.xpath(Paths.SAVE_EDITING)).click();
        String[] current = edit.checkChanges(Arrays.rack, Arrays.newRack);
        String[] expected = new String[]{current[0],"Rack",Arrays.etalon[0],null,Arrays.etalon[0],null,current[1],current[2],current[3],select};
        String[] actual = edit.actualParameters();
        for(int i = 0; i < actual.length; i++) {
            assertEquals(expected[i],actual[i]);
        }
    }

    @Test
    public void c16editingDevice(){
        MethodsForNavigation navigate = new MethodsForNavigation(driver);
        MethodsForEditing edit = new MethodsForEditing(driver);
        navigate.navigatingToDevice();
        navigate.findAndClick(Paths.DEVICE, Arrays.device[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.EDIT))).click();
        edit.fillingEditingForm(Arrays.newDevice);
        String select = driver.findElement(By.xpath(Paths.SELECTED)).getText();
        String located = driver.findElement(By.xpath("//td[@class='parameter']/input[@id='j_idt74:locatedIn']")).getAttribute("value");
        String networkElement = driver.findElement(By.xpath("//td[@class='parameter']/input[@id='j_idt74:networkElementName']")).getAttribute("value");
        driver.findElement(By.xpath(Paths.SAVE_EDITING)).click();
        String[] current = edit.checkChanges(Arrays.posterm, Arrays.newPosterm);
        String[] expected = new String[]{current[0],"Device",Arrays.etalon[0],null,Arrays.etalon[0],null,current[1],current[2],current[3],current[4],select,current[5],current[6],current[7],located,networkElement};
        String[] actual = edit.actualParameters();
        for(int i = 0; i < actual.length; i++) {
            assertEquals(expected[i],actual[i]);
        }
    }

    @Test
    public void c17editingPosterm(){
        MethodsForNavigation navigate = new MethodsForNavigation(driver);
        MethodsForEditing edit = new MethodsForEditing(driver);
        navigate.navigatingToPosterm();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.POSTERM)));
        navigate.findAndClick(Paths.POSTERM, Arrays.posterm[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.EDIT))).click();
        edit.fillingEditingForm(Arrays.newPosterm);
        String select = driver.findElement(By.xpath(Paths.SELECTED)).getText();
        String located = driver.findElement(By.xpath("//td[@class='parameter']/input[@id='j_idt74:locatedIn']")).getAttribute("value");
        driver.findElement(By.xpath(Paths.SAVE_EDITING)).click();
        String[] current = edit.checkChanges(Arrays.posterm, Arrays.newPosterm);
        String[] expected = new String[]{current[0],"POS Term",Arrays.etalon[0],null,Arrays.etalon[0],null,current[1],current[2],current[3],select,"Country: " + located};
        String[] actual = edit.actualParameters();
        for(int i = 0; i < actual.length; i++) {
            assertEquals(expected[i],actual[i]);
        }
    }

    @Test
    public void c18editingPayBox(){
        MethodsForNavigation navigate = new MethodsForNavigation(driver);
        MethodsForEditing edit = new MethodsForEditing(driver);
        navigate.navigatingToPayBox();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.PAYBOX)));
        navigate.findAndClick(Paths.PAYBOX, Arrays.payBox[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.EDIT))).click();
        edit.fillingEditingForm(Arrays.newPayBox);
        String select = driver.findElement(By.xpath(Paths.SELECTED)).getText();
        String located = driver.findElement(By.xpath("//td[@class='parameter']/input[@id='j_idt74:locatedIn']")).getAttribute("value");
        driver.findElement(By.xpath(Paths.SAVE_EDITING)).click();
        String[] current = edit.checkChanges(Arrays.payBox, Arrays.newPayBox);
        String[] expected = new String[]{current[0],"Pay Box",Arrays.etalon[0],null,Arrays.etalon[0],null,current[1],current[2],select,"Country: " + located};
        String[] actual = edit.actualParameters();
        for(int i = 0; i < actual.length; i++) {
            assertEquals(expected[i],actual[i]);
        }
    }

    @Test
    public void c19editingAtm(){
        MethodsForNavigation navigate = new MethodsForNavigation(driver);
        MethodsForEditing edit = new MethodsForEditing(driver);
        navigate.navigatingToAtm();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.ATM)));
        navigate.findAndClick(Paths.ATM, Arrays.atm[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.EDIT))).click();
        edit.fillingEditingForm(Arrays.newAtm);
        String select = driver.findElement(By.xpath(Paths.SELECTED)).getText();
        String located = driver.findElement(By.xpath("//td[@class='parameter']/input[@id='j_idt74:locatedIn']")).getAttribute("value");
        driver.findElement(By.xpath(Paths.SAVE_EDITING)).click();
        String[] current = edit.checkChanges(Arrays.atm, Arrays.newAtm);
        String[] expected = new String[]{current[0],"ATM",Arrays.etalon[0],null,Arrays.etalon[0],null,current[1],current[2],select,"Country: " + located};
        String[] actual = edit.actualParameters();
        for(int i = 0; i < actual.length; i++) {
            assertEquals(expected[i],actual[i]);
        }
    }

}
