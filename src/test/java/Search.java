import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Class for testing the searching of objects.
 */
public class Search extends Basic {

    MethodsForEditing edit = new MethodsForEditing();
    MethodsForNavigation navigate = new MethodsForNavigation();
    MethodsForSearch search = new MethodsForSearch();


    @Test
    public void d00searchingForCountry(){
        search.chooseTheTypeOfSearch(0);
        String[] current = edit.checkChanges(Arrays.country,Arrays.newCountry);
        search.fillingSearchForm(current);
        driver.findElement(By.xpath("//form//select[@id='j_idt66:continent']/option[2]")).click();
        driver.findElement(By.xpath(Paths.SUBMIT)).click();
        navigate.findAndClick(Paths.LINK_A, current[0]);
        assertEquals(current[0],driver.getTitle());
    }

    @Test
    public void d01searchingForCity(){
        search.chooseTheTypeOfSearch(1);
        String[] current = edit.checkChanges(Arrays.city,Arrays.newCity);
        search.fillingSearchForm(current);
        driver.findElement(By.xpath("//select[@name='j_idt66:j_idt84']/option[2]")).click();
        driver.findElement(By.xpath(Paths.SUBMIT)).click();
        navigate.findAndClick(Paths.LINK_A,current[0]);
        assertEquals(current[0],driver.getTitle());
    }

    @Test
    public void d02searchingForBuilding(){
        search.chooseTheTypeOfSearch(2);
        String[] current = edit.checkChanges(Arrays.building, Arrays.newBuilding);
        search.fillingSearchForm(current);
        driver.findElement(By.xpath("//select[@name='j_idt66:j_idt100']/option[2]")).click();
        driver.findElement(By.xpath(Paths.SUBMIT)).click();
        navigate.findAndClick(Paths.LINK_A,current[0]);
        assertEquals(current[0],driver.getTitle());
    }

    @Test
    public void d03searchingForFloor(){
        search.chooseTheTypeOfSearch(3);
        String[] curr = edit.checkChanges(Arrays.floor, Arrays.newFloor);
        String[] current = {"Floor#" + curr[0],curr[0],curr[1]};
        search.fillingSearchForm(current);
        driver.findElement(By.xpath(Paths.SUBMIT)).click();
        navigate.findAndClick(Paths.LINK_A,current[0]);
        assertEquals(current[0],driver.getTitle());
    }

    @Test
    public void d04searchingForRoom(){
        search.chooseTheTypeOfSearch(4);
        String[] current = edit.checkChanges(Arrays.room,Arrays.newRoom);
        search.fillingSearchForm(current);
        driver.findElement(By.xpath(Paths.SUBMIT)).click();
        navigate.findAndClick(Paths.LINK_A,current[0]);
        assertEquals(current[0],driver.getTitle());
    }

    @Test
    public void d05searchingForRack(){
        search.chooseTheTypeOfSearch(5);
        String[] current = edit.checkChanges(Arrays.rack,Arrays.newRack);
        search.fillingSearchForm(current);
        driver.findElement(By.xpath("//select[@name='j_idt66:j_idt77']/option[3]")).click();
        driver.findElement(By.xpath(Paths.SUBMIT)).click();
        navigate.findAndClick(Paths.LINK_A,current[0]);
        assertEquals(current[0],driver.getTitle());
    }

    @Test
    public void d06searchingForDevice(){
        search.chooseTheTypeOfSearch(6);
        String[] current = edit.checkChanges(Arrays.device, Arrays.newDevice);
        search.fillingSearchForm(current);
        driver.findElement(By.xpath("//select[@name='j_idt66:j_idt99']/option[3]")).click();
        driver.findElement(By.xpath(Paths.SUBMIT)).click();
        navigate.findAndClick(Paths.LINK_A, current[0]);
        assertEquals(current[0],driver.getTitle());
    }

    @Test
    public void d07searchingForPosterm(){
        search.chooseTheTypeOfSearch(7);
        String[] current = edit.checkChanges(Arrays.posterm, Arrays.newPosterm);
        List<WebElement> rows = driver.findElements(By.xpath(Paths.TEXT));
        rows.get(0).sendKeys(current[0]);
        rows.get(1).sendKeys(current[1]);
        rows.get(2).sendKeys(current[3]);
        rows.get(3).sendKeys(current[2]);
        driver.findElement(By.xpath("//select[@name='j_idt66:j_idt77']/option[3]")).click();
        driver.findElement(By.xpath(Paths.SUBMIT)).click();
        navigate.findAndClick(Paths.LINK_A,current[0]);
        assertEquals(current[0],driver.getTitle());
    }

    @Test
    public void d08searchingForPaybox(){
        search.chooseTheTypeOfSearch(8);
        String[] current = edit.checkChanges(Arrays.payBox, Arrays.newPayBox);
        search.fillingSearchForm(current);
        driver.findElement(By.xpath("//select[@name='j_idt66:j_idt77']/option[3]")).click();
        driver.findElement(By.xpath(Paths.SUBMIT)).click();
        navigate.findAndClick(Paths.LINK_A,current[0]);
        assertEquals(current[0],driver.getTitle());
    }

    @Test
    public void d09searchingForAtm(){
        search.chooseTheTypeOfSearch(9);
        String[] current = edit.checkChanges(Arrays.atm, Arrays.newAtm);
        search.fillingSearchForm(current);
        driver.findElement(By.xpath("//select[@name='j_idt66:j_idt77']/option[3]")).click();
        driver.findElement(By.xpath(Paths.SUBMIT)).click();
        navigate.findAndClick(Paths.LINK_A,current[0]);
        assertEquals(current[0],driver.getTitle());
    }
}
