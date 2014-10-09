import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

/**
 * An additional class for Creation.
 * Contains methods for testing the addition of object.
 */
public class MethodsForCreation {

    WebDriver driver;
    WebDriverWait wait;

    public void fillingCreationForm(String[] array){
        List<WebElement> arrayRows = driver.findElements(By.xpath(Paths.ROWS));
        for (int i = 0; i < array.length; i++) {
            arrayRows.get(i).sendKeys(array[i]);
        }
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



    public String selectionFromList(int n){
        List<WebElement> select = driver.findElements(By.xpath(Paths.SELECT_OPTION));
        WebElement choose = select.get(n);
        choose.click();
        return choose.getText();
    }
}
