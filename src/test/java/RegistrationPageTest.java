import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.LinkedList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

/**
 * Class for testing the registration page.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegistrationPageTest {

    WebDriver driver;

    @Before
    public void navigationToRegistrationPage() {
        System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://s1.web.sumdu.edu.ua:8080");
        driver.findElement(By.xpath(Paths.REGISTRATION)).click();
    }

    @Test
    public void a10registrationWithInvalidUserName(){
        for(String name : Arrays.userNames){
            driver.findElement(By.xpath(Paths.USERNAME)).sendKeys(name);
            driver.findElement(By.xpath(Paths.PASSWORD)).sendKeys(Arrays.etalon[1]);
            driver.findElement(By.xpath(Paths.CONFIRM_PASSWORD)).sendKeys(Arrays.etalon[1]);
            driver.findElement(By.xpath(Paths.EMAIL)).sendKeys(Arrays.etalon[2]);
            driver.findElement(By.xpath(Paths.SUBMIT)).click();
            if (Paths.LOGIN_PAGE.equals(driver.getTitle())){
                System.out.println("Name: " + name + " was passed");
            }
            assertEquals(Paths.TITLE,driver.getTitle());
            driver.get(Paths.REGISTRATION_PAGE_URL);
        }
    }

    @Test
    public void a20registrationWithInvalidPassword(){
        for(String name : Arrays.passwords){
            driver.findElement(By.xpath(Paths.USERNAME)).sendKeys(Arrays.etalon[0]);
            driver.findElement(By.xpath(Paths.PASSWORD)).sendKeys(name);
            driver.findElement(By.xpath(Paths.CONFIRM_PASSWORD)).sendKeys(name);
            driver.findElement(By.xpath(Paths.EMAIL)).sendKeys(Arrays.etalon[2]);
            driver.findElement(By.xpath(Paths.SUBMIT)).click();
            if (Paths.LOGIN_PAGE.equals(driver.getTitle())){
                System.out.println("Password: " + name + "was passed");
            }
            assertEquals(driver.getTitle(),Paths.TITLE);
            driver.get(Paths.REGISTRATION_PAGE_URL);
        }
    }

    @Test
    public void a30registrationWithInvalidRepeatPassword(){
        for(String name : Arrays.passwords){
            driver.findElement(By.xpath(Paths.USERNAME)).sendKeys(Arrays.etalon[0]);
            driver.findElement(By.xpath(Paths.PASSWORD)).sendKeys(Arrays.etalon[1]);
            driver.findElement(By.xpath(Paths.CONFIRM_PASSWORD)).sendKeys(name);
            driver.findElement(By.xpath(Paths.EMAIL)).sendKeys(Arrays.etalon[2]);
            driver.findElement(By.xpath(Paths.SUBMIT)).click();
            assertEquals(driver.getTitle(),Paths.TITLE);
            driver.get(Paths.REGISTRATION_PAGE_URL);
        }
    }

    @Test
    public void a40registrationWithInvalidEmail(){
        for(String name : Arrays.emails){
            driver.findElement(By.xpath(Paths.USERNAME)).sendKeys(Arrays.etalon[0]);
            driver.findElement(By.xpath(Paths.PASSWORD)).sendKeys(Arrays.etalon[1]);
            driver.findElement(By.xpath(Paths.CONFIRM_PASSWORD)).sendKeys(Arrays.etalon[1]);
            driver.findElement(By.xpath(Paths.EMAIL)).sendKeys(name);
            driver.findElement(By.xpath(Paths.SUBMIT)).click();
            if (Paths.LOGIN_PAGE.equals(driver.getTitle())){
                System.out.println("Email: " + name + "was passed");
            }
            assertEquals(driver.getTitle(),Paths.TITLE);
            driver.get(Paths.REGISTRATION_PAGE_URL);
        }
    }

    @Test
    public void a50successRegistration(){
        driver.findElement(By.xpath(Paths.USERNAME)).sendKeys(Arrays.etalon[0]);
        driver.findElement(By.xpath(Paths.PASSWORD)).sendKeys(Arrays.etalon[1]);
        driver.findElement(By.xpath(Paths.CONFIRM_PASSWORD)).sendKeys(Arrays.etalon[1]);
        driver.findElement(By.xpath(Paths.EMAIL)).sendKeys(Arrays.etalon[2]);
        driver.findElement(By.xpath(Paths.SUBMIT)).click();
        assertEquals("Login Page",driver.getTitle());
    }

    @Test
    public void a60loginWithEmptyFields(){
        driver.get(Paths.LOGIN_PAGE_URL);
        driver.findElement(By.xpath(Paths.LOGIN)).click();
        assertEquals(driver.getTitle(),Paths.LOGIN_PAGE);
    }

    @Test
    public void a70successfulLogin(){
        driver.get(Paths.LOGIN_PAGE_URL);
        driver.findElement(By.xpath(".//tr[1]/td[2]/input")).sendKeys(Arrays.etalon[0]);
        driver.findElement(By.xpath(".//tr[2]/td[2]/input")).sendKeys(Arrays.etalon[1]);
        driver.findElement(By.xpath(".//tr[3]/td[2]/input")).click();
        assertEquals("Top",driver.getTitle());
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}

