import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

/**
 * An additional class for Creation.
 * Contains methods for testing the addition of object.
 */
public class MethodsForCreation{

    WebDriver driver;

    public MethodsForCreation(WebDriver driver) {
        this.driver = driver;
    }

    public void fillingCreationForm(String[] array){
        List<WebElement> arrayRows = driver.findElements(By.xpath(Paths.ROWS));
        for (int i = 0; i < array.length; i++) {
            arrayRows.get(i).sendKeys(array[i]);
        }
    }

    public String selectionFromList(int n){
        List<WebElement> select = driver.findElements(By.xpath(Paths.SELECT_OPTION));
        WebElement choose = select.get(n);
        choose.click();
        return choose.getText();
    }
}
