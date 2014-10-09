import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * An additional class for Editing.
 * Contains methods for testing the editing parameters of the object.
 */
public class MethodsForEditing {

    WebDriver driver;
    WebDriverWait wait;

    public String[] checkChanges(String[] oldObject, String[] newObject){
        String [] currentObject = new String[oldObject.length];
        for(int i = 0; i < oldObject.length; i++ ) {
            if (newObject[i] != null){
                currentObject[i] = newObject[i];
            } else
                currentObject[i] = oldObject[i];
        }
        return currentObject;
    }

    public void fillingEditingForm(String[] newArray){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Paths.ROWS)));
        List<WebElement> rows = driver.findElements(By.xpath(Paths.ROWS));
        for(int i = 0; i < newArray.length; i++ ) {
            if(newArray[i] != null) {
                rows.get(i).clear();
                rows.get(i).sendKeys(newArray[i]);
            }
        }
    }

    public String[] actualParameters(){
        List<WebElement> afterEdit = driver.findElements(By.xpath(Paths.AFTER_EDIT));
        String[] actual = new String[afterEdit.size()];
        for(int i = 0; i < afterEdit.size(); i++) {
            if (i == 3 || i == 5) i++;
            actual[i] = afterEdit.get(i).getText();
        }
        return actual;
    }

    public String objectTitle(String[] object, String[] newObject){
        String[] currentArray = checkChanges(object,newObject);
        return currentArray[0];
    }
}
