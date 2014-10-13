import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

/**
 * Class for testing the removal of objects.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Remove extends Basic {

    @Test
    public void e00deletingTheAtm(){
        MethodsForEditing edit = new MethodsForEditing(driver);
        MethodsForNavigation navigate = new MethodsForNavigation(driver);
        MethodsForSearch search = new MethodsForSearch(driver,wait);
        navigate.navigatingToAtm();
        String title = edit.objectTitle(Arrays.atm, Arrays.newAtm);
        boolean check = search.searchObjectOnPage(title,Paths.ATM_CHECKBOX,Paths.ATM_A);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.DELETE_ATM))).click();
        assertTrue(check);
    }

    @Test
    public void e01deletingThePayBox(){
        MethodsForEditing edit = new MethodsForEditing(driver);
        MethodsForNavigation navigate = new MethodsForNavigation(driver);
        MethodsForSearch search = new MethodsForSearch(driver,wait);
        navigate.navigatingToPayBox();
        String title = edit.objectTitle(Arrays.payBox, Arrays.newPayBox);
        boolean check = search.searchObjectOnPage(title,Paths.PAYBOX_CHECKBOX,Paths.PAYBOX_A);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.DELETE_PAYBOX))).click();
        assertTrue(check);
    }

    @Test
    public void e02deletingThePosterm(){
        MethodsForEditing edit = new MethodsForEditing(driver);
        MethodsForNavigation navigate = new MethodsForNavigation(driver);
        MethodsForSearch search = new MethodsForSearch(driver,wait);
        navigate.navigatingToPosterm();
        String title = edit.objectTitle(Arrays.posterm, Arrays.newPosterm);
        boolean check = search.searchObjectOnPage(title,Paths.POSTERM_CHECKBOX,Paths.POSTERM_A);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.DELETE_POSTERM))).click();
        assertTrue(check);
    }

    @Test
    public void e03deletingTheDevice(){
        MethodsForEditing edit = new MethodsForEditing(driver);
        MethodsForNavigation navigate = new MethodsForNavigation(driver);
        MethodsForSearch search = new MethodsForSearch(driver,wait);
        navigate.navigatingToDevice();
        String title = edit.objectTitle(Arrays.device, Arrays.newDevice);
        boolean check = search.searchObjectOnPage(title,Paths.LINK_CHECKBOX,Paths.LINK_A);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.DELETE_DEVICE))).click();
        assertTrue(check);
    }

    @Test
    public void e04deletingTheRack(){
        MethodsForEditing edit = new MethodsForEditing(driver);
        MethodsForNavigation navigate = new MethodsForNavigation(driver);
        MethodsForSearch search = new MethodsForSearch(driver,wait);
        navigate.navigatingToRack();
        String title = edit.objectTitle(Arrays.rack, Arrays.newRack);
        boolean check = search.searchObjectOnPage(title,Paths.LINK_CHECKBOX,Paths.LINK_A);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.DELETE_RACK))).click();
        assertTrue(check);
    }

    @Test
    public void e05deletingTheRoom(){
        MethodsForEditing edit = new MethodsForEditing(driver);
        MethodsForNavigation navigate = new MethodsForNavigation(driver);
        MethodsForSearch search = new MethodsForSearch(driver,wait);
        navigate.navigatingToRoom();
        String title = edit.objectTitle(Arrays.room, Arrays.newRoom);
        boolean check = search.searchObjectOnPage(title,Paths.LINK_CHECKBOX,Paths.LINK_A);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.DELETE_ROOM))).click();
        assertTrue(check);
    }

    @Test
    public void e06deletingTheFloor(){
        MethodsForEditing edit = new MethodsForEditing(driver);
        MethodsForNavigation navigate = new MethodsForNavigation(driver);
        MethodsForSearch search = new MethodsForSearch(driver,wait);
        navigate.navigatingToFloor();
        String title = "Floor#" + edit.objectTitle(Arrays.floor, Arrays.newFloor);
        boolean check = search.searchObjectOnPage(title,Paths.LINK_CHECKBOX,Paths.LINK_A);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.DELETE_FLOOR))).click();
        assertTrue(check);
    }

    @Test
    public void e07deletingTheBuilding(){
        MethodsForEditing edit = new MethodsForEditing(driver);
        MethodsForNavigation navigate = new MethodsForNavigation(driver);
        MethodsForSearch search = new MethodsForSearch(driver,wait);
        navigate.navigatingToBuilding();
        String title = edit.objectTitle(Arrays.building, Arrays.newBuilding);
        boolean check = search.searchObjectOnPage(title,Paths.LINK_CHECKBOX,Paths.LINK_A);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.DELETE_BUILDING))).click();
        assertTrue(check);
    }

    @Test
    public void e08deletingTheCity(){
        MethodsForEditing edit = new MethodsForEditing(driver);
        MethodsForNavigation navigate = new MethodsForNavigation(driver);
        MethodsForSearch search = new MethodsForSearch(driver,wait);
        navigate.navigatingToCity();
        String title = edit.objectTitle(Arrays.city, Arrays.newCity);
        boolean check = search.searchObjectOnPage(title,Paths.LINK_CHECKBOX,Paths.LINK_A);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.DELETE_CITY))).click();
        assertTrue(check);
    }

    @Test
    public void e09deletingTheCountries(){
        int[] row = new int[10];
        int i = 0;
        int j = 0;
        List<WebElement> listOfOwners = driver.findElements(By.xpath("//tr[@role='row']/td[@class='object_owner']"));
        for (WebElement element : listOfOwners){
            if (element.getText().equals(currentUser[0])){
                row[j] = i;
                j++;
            }
            i++;
        }
        i = 0;
        j = 0;
        List<WebElement> listOfCountries = driver.findElements(By.xpath("//tr[@role='row']/td[@class='object_name']/input"));
        for (WebElement country : listOfCountries){
            if (row[j] == i){
                country.click();
                j++;
            }
            i++;
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.DELETE_COUNTRY))).click();
        listOfOwners = driver.findElements(By.xpath("//tr[@role='row']/td[@class='object_owner']"));
        for (WebElement element : listOfOwners) {
            if (element.getText().equals(currentUser[0])) {
                fail("Not all countries of the current user have been deleted");
            }
        }
    }
}
