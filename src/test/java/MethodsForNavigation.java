import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * An additional class for Navigation.
 * Contains methods for testing navigation to the object.
 */
public class MethodsForNavigation {

    WebDriver driver;
    WebDriverWait wait;

    public void findAndClick(String objects, String title){
        List<WebElement> count = driver.findElements(By.xpath(objects));
        for (WebElement element : count){
            if (element.getText().equals(title)){
                element.click();
                break;
            }
        }
    }

    public void navigatingToAtm(){
        findAndClick(Paths.COUNTRIES, Arrays.newCountry[0]);
        findAndClick(Paths.CITIES, Arrays.newCity[0]);
        findAndClick(Paths.BUILDINGS, Arrays.newBuilding[0]);
        findAndClick(Paths.FLOORS, "Floor#" + Arrays.newFloor[0]);
        findAndClick(Paths.ROOMS, Arrays.newRoom[0]);
        findAndClick(Paths.RACKS, Arrays.newRack[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/a[text()='ATM (s)']"))).click();

    }

    public void navigatingToPayBox(){
        findAndClick(Paths.COUNTRIES, Arrays.newCountry[0]);
        findAndClick(Paths.CITIES, Arrays.newCity[0]);
        findAndClick(Paths.BUILDINGS, Arrays.newBuilding[0]);
        findAndClick(Paths.FLOORS, "Floor#" + Arrays.newFloor[0]);
        findAndClick(Paths.ROOMS, Arrays.newRoom[0]);
        findAndClick(Paths.RACKS, Arrays.newRack[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/a[text()='Pay Box (s)']"))).click();

    }

    public void navigatingToPosterm(){
        findAndClick(Paths.COUNTRIES, Arrays.newCountry[0]);
        findAndClick(Paths.CITIES, Arrays.newCity[0]);
        findAndClick(Paths.BUILDINGS, Arrays.newBuilding[0]);
        findAndClick(Paths.FLOORS, "Floor#" + Arrays.newFloor[0]);
        findAndClick(Paths.ROOMS, Arrays.newRoom[0]);
        findAndClick(Paths.RACKS, Arrays.newRack[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/a[text()='Post Terminal (s)']"))).click();
    }

    public void navigatingToDevice(){
        findAndClick(Paths.COUNTRIES, Arrays.newCountry[0]);
        findAndClick(Paths.CITIES, Arrays.newCity[0]);
        findAndClick(Paths.BUILDINGS, Arrays.newBuilding[0]);
        findAndClick(Paths.FLOORS, "Floor#" + Arrays.newFloor[0]);
        findAndClick(Paths.ROOMS, Arrays.newRoom[0]);
        findAndClick(Paths.RACKS, Arrays.newRack[0]);
    }

    public void navigatingToRack(){
        findAndClick(Paths.COUNTRIES, Arrays.newCountry[0]);
        findAndClick(Paths.CITIES, Arrays.newCity[0]);
        findAndClick(Paths.BUILDINGS, Arrays.newBuilding[0]);
        findAndClick(Paths.FLOORS, "Floor#" + Arrays.newFloor[0]);
        findAndClick(Paths.ROOMS, Arrays.newRoom[0]);
    }

    public void navigatingToRoom(){
        findAndClick(Paths.COUNTRIES, Arrays.newCountry[0]);
        findAndClick(Paths.CITIES, Arrays.newCity[0]);
        findAndClick(Paths.BUILDINGS, Arrays.newBuilding[0]);
        findAndClick(Paths.FLOORS, "Floor#" + Arrays.newFloor[0]);
    }

    public void navigatingToFloor(){
        findAndClick(Paths.COUNTRIES, Arrays.newCountry[0]);
        findAndClick(Paths.CITIES, Arrays.newCity[0]);
        findAndClick(Paths.BUILDINGS, Arrays.newBuilding[0]);
    }

    public void navigatingToBuilding(){
        findAndClick(Paths.COUNTRIES, Arrays.newCountry[0]);
        findAndClick(Paths.CITIES, Arrays.newCity[0]);
    }

    public void navigatingToCity(){
        findAndClick(Paths.COUNTRIES, Arrays.newCountry[0]);
    }
}
