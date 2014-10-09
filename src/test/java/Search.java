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

    static final String FIND = "//div[@id='navigation_toolbar']//td[2]//a";
    static final String TEXT = "//form//input[@type='text']";
    static final String SEARCH = "//form//input[@type='submit']";

    public void chooseTheTypeOfSearch(int n){
        int i = 0;
        WebElement element = driver.findElement(By.xpath("//div[@id='navigation_toolbar']//input"));
        new Actions(driver).moveToElement(element).perform();
        List<WebElement> find =  driver.findElements(By.xpath(FIND));
        for (WebElement elem : find){
            if (i == n){
                new Actions(driver).moveToElement(element).perform();
                wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                new Actions(driver).moveToElement(element).click(elem).perform();
                break;
            } else i++;
        }
    }

    public void fillingForm(String[] options){
        List<WebElement> rows = driver.findElements(By.xpath(TEXT));
        for(int i = 0; i < options.length; i++ ) {
            rows.get(i).sendKeys(options[i]);
        }
    }

    @Test
    public void d00searchingForCountry(){
        chooseTheTypeOfSearch(0);
        String[] current = checkChanges(country,newCountry);
        fillingForm(current);
        driver.findElement(By.xpath("//form//select[@id='j_idt66:continent']/option[2]")).click();
        driver.findElement(By.xpath(SEARCH)).click();
        findAndClick(Remove.LINK_A,current[0]);
        assertEquals(current[0],driver.getTitle());
    }

    @Test
    public void d01searchingForCity(){
        chooseTheTypeOfSearch(1);
        String[] current = checkChanges(city,newCity);
        fillingForm(current);
        driver.findElement(By.xpath("//select[@name='j_idt66:j_idt84']/option[2]")).click();
        driver.findElement(By.xpath(SEARCH)).click();
        findAndClick(Remove.LINK_A,current[0]);
        assertEquals(current[0],driver.getTitle());
    }

    @Test
    public void d02searchingForBuilding(){
        chooseTheTypeOfSearch(2);
        String[] current = checkChanges(building, newBuilding);
        fillingForm(current);
        driver.findElement(By.xpath("//select[@name='j_idt66:j_idt100']/option[2]")).click();
        driver.findElement(By.xpath(SEARCH)).click();
        findAndClick(Remove.LINK_A,current[0]);
        assertEquals(current[0],driver.getTitle());
    }

    @Test
    public void d03searchingForFloor(){
        chooseTheTypeOfSearch(3);
        String[] curr = checkChanges(floor, newFloor);
        String[] current = {"Floor#" + curr[0],curr[0],curr[1]};
        fillingForm(current);
        driver.findElement(By.xpath(SEARCH)).click();
        findAndClick(Remove.LINK_A,current[0]);
        assertEquals(current[0],driver.getTitle());
    }

    @Test
    public void d04searchingForRoom(){
        chooseTheTypeOfSearch(4);
        String[] current = checkChanges(room,newRoom);
        fillingForm(current);
        driver.findElement(By.xpath(SEARCH)).click();
        findAndClick(Remove.LINK_A,current[0]);
        assertEquals(current[0],driver.getTitle());
    }

    @Test
    public void d05searchingForRack(){
        chooseTheTypeOfSearch(5);
        String[] current = checkChanges(rack,newRack);
        fillingForm(current);
        driver.findElement(By.xpath("//select[@name='j_idt66:j_idt77']/option[3]")).click();
        driver.findElement(By.xpath(SEARCH)).click();
        findAndClick(Remove.LINK_A,current[0]);
        assertEquals(current[0],driver.getTitle());
    }

    @Test
    public void d06searchingForDevice(){
        chooseTheTypeOfSearch(6);
        String[] current = checkChanges(device, newDevice);
        fillingForm(current);
        driver.findElement(By.xpath("//select[@name='j_idt66:j_idt99']/option[3]")).click();
        driver.findElement(By.xpath(SEARCH)).click();
        findAndClick(Remove.LINK_A,current[0]);
        assertEquals(current[0],driver.getTitle());
    }

    @Test
    public void d07searchingForPosterm(){
        chooseTheTypeOfSearch(7);
        String[] current = checkChanges(posterm, newPosterm);
        List<WebElement> rows = driver.findElements(By.xpath(TEXT));
        rows.get(0).sendKeys(current[0]);
        rows.get(1).sendKeys(current[1]);
        rows.get(2).sendKeys(current[3]);
        rows.get(3).sendKeys(current[2]);
        driver.findElement(By.xpath("//select[@name='j_idt66:j_idt77']/option[3]")).click();
        driver.findElement(By.xpath(SEARCH)).click();
        findAndClick(Remove.LINK_A,current[0]);
        assertEquals(current[0],driver.getTitle());
    }

    @Test
    public void d08searchingForPaybox(){
        chooseTheTypeOfSearch(8);
        String[] current = checkChanges(payBox, newPayBox);
        fillingForm(current);
        driver.findElement(By.xpath("//select[@name='j_idt66:j_idt77']/option[3]")).click();
        driver.findElement(By.xpath(SEARCH)).click();
        findAndClick(Remove.LINK_A,current[0]);
        assertEquals(current[0],driver.getTitle());
    }

    @Test
    public void d09searchingForAtm(){
        chooseTheTypeOfSearch(9);
        String[] current = checkChanges(atm, newAtm);
        fillingForm(current);
        driver.findElement(By.xpath("//select[@name='j_idt66:j_idt77']/option[3]")).click();
        driver.findElement(By.xpath(SEARCH)).click();
        findAndClick(Remove.LINK_A,current[0]);
        assertEquals(current[0],driver.getTitle());
    }
}
