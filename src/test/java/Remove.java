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

    static final String DELETE_ATM = "//div[@id='j_idt76:tabView:j_idt121']//input[@value='Delete']";
    static final String DELETE_PAYBOX = "//input[@name='j_idt76:tabView:j_idt141']";
    static final String DELETE_POSTERM = "//input[@name='j_idt76:tabView:j_idt156']";
    static final String DELETE_DEVICE = "//input[@name='j_idt76:tabView:j_idt111']";
    static final String DELETE_RACK = "//input[@name='j_idt76:tabView:j_idt105']";
    static final String DELETE_ROOM = "//input[@name='j_idt76:tabView:j_idt107']";
    static final String DELETE_FLOOR = "//input[@name='j_idt76:tabView:j_idt111']";
    static final String DELETE_BUILDING = "//input[@name='j_idt76:tabView:j_idt107']";
    static final String DELETE_CITY = "//input[@name='j_idt76:tabView:j_idt107']";
    static final String DELETE_COUNTRY = "//input[@name='j_idt76:tabView:j_idt87']";
    static final String ATM = "//div[@id='j_idt76:tabView:j_idt128']//td[@class='object_name']/input[@type='checkbox']";
    static final String ATM_A = "//div[@id='j_idt76:tabView:j_idt128']//td[@class='object_name']/a";
    static final String PAYBOX = "//div[@id='j_idt76:tabView:j_idt136']//td[@class='object_name']/input[@type='checkbox']";
    static final String PAYBOX_A = "//div[@id='j_idt76:tabView:j_idt136']//td[@class='object_name']/a";
    static final String POSTERM = "//div[@id='j_idt76:tabView:j_idt158']//td[@class='object_name']/input[@type='checkbox']";
    static final String POSTERM_A = "//div[@id='j_idt76:tabView:j_idt158']//td[@class='object_name']/a";
    static final String LINK = "//input[@type='checkbox']";
    static final String LINK_A = "//td[@class='object_name']/a[@class='link']";
    
    public boolean checkingForObject(String s, String link, String link_a){
        int i = 0;
        int n = 0;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(link)));
        List<WebElement> elements = driver.findElements(By.xpath(link_a));
        for (WebElement elem : elements){
            i++;
            String object = elem.getText();
            if (object.equals(s)){
                n = i;
                break;
            }
        }
        int j = 0;
        List<WebElement> element = driver.findElements(By.xpath(link));
        for (WebElement elem : element) {
            j++;
            if (j == n){
                elem.click();
                return true;
            }
        }
        return false;
    }

    @Test
    public void e00deletingTheAtm(){
        navigatingToAtm();
        String title = objectTitle(atm, newAtm);
        boolean check = checkingForObject(title,ATM,ATM_A);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DELETE_ATM))).click();
        assertTrue(check);
    }

    @Test
    public void e01deletingThePayBox(){
        navigatingToPayBox();
        String title = objectTitle(payBox, newPayBox);
        boolean check = checkingForObject(title,PAYBOX,PAYBOX_A);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DELETE_PAYBOX))).click();
        assertTrue(check);
    }

    @Test
    public void e02deletingThePosterm(){
        navigatingToPosterm();
        String title = objectTitle(posterm, newPosterm);
        boolean check = checkingForObject(title,POSTERM,POSTERM_A);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DELETE_POSTERM))).click();
        assertTrue(check);
    }

    @Test
    public void e03deletingTheDevice(){
        navigatingToDevice();
        String title = objectTitle(device, newDevice);
        boolean check = checkingForObject(title,LINK,LINK_A);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DELETE_DEVICE))).click();
        assertTrue(check);
    }

    @Test
    public void e04deletingTheRack(){
        navigatingToRack();
        String title = objectTitle(rack, newRack);
        boolean check = checkingForObject(title,LINK,LINK_A);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DELETE_RACK))).click();
        assertTrue(check);
    }

    @Test
    public void e05deletingTheRoom(){
        navigatingToRoom();
        String title = objectTitle(room, newRoom);
        boolean check = checkingForObject(title,LINK,LINK_A);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DELETE_ROOM))).click();
        assertTrue(check);
    }

    @Test
    public void e06deletingTheFloor(){
        navigatingToFloor();
        String title = "Floor#" + objectTitle(floor, newFloor);
        boolean check = checkingForObject(title,LINK,LINK_A);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DELETE_FLOOR))).click();
        assertTrue(check);
    }

    @Test
    public void e07deletingTheBuilding(){
        navigatingToBuilding();
        String title = objectTitle(building, newBuilding);
        boolean check = checkingForObject(title,LINK,LINK_A);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DELETE_BUILDING))).click();
        assertTrue(check);
    }

    @Test
    public void e08deletingTheCity(){
        navigatingToCity();
        String title = objectTitle(city, newCity);
        boolean check = checkingForObject(title,LINK,LINK_A);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DELETE_CITY))).click();
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
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DELETE_COUNTRY))).click();
        listOfOwners = driver.findElements(By.xpath("//tr[@role='row']/td[@class='object_owner']"));
        for (WebElement element : listOfOwners) {
            if (element.getText().equals(currentUser[0])) {
                fail("Not all countries of the current user have been deleted");
            }
        }
    }
}
