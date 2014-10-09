import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * An additional class for Search.
 * Contains methods for testing searching for an object.
 */
public class MethodsForSearch {

    WebDriver driver;
    WebDriverWait wait;

    public void chooseTheTypeOfSearch(int n){
        int i = 0;
        WebElement element = driver.findElement(By.xpath("//div[@id='navigation_toolbar']//input"));
        new Actions(driver).moveToElement(element).perform();
        List<WebElement> find =  driver.findElements(By.xpath(Paths.FIND));
        for (WebElement elem : find){
            if (i == n){
                new Actions(driver).moveToElement(element).perform();
                wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                new Actions(driver).moveToElement(element).click(elem).perform();
                break;
            } else i++;
        }
    }

    public void fillingSearchForm(String[] options){
        List<WebElement> rows = driver.findElements(By.xpath(Paths.TEXT));
        for(int i = 0; i < options.length; i++ ) {
            rows.get(i).sendKeys(options[i]);
        }
    }

    public boolean searchObjectOnPage(String s, String link, String link_a){
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
}
