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
public class RegistrationPageTest extends Arrays{

    WebDriver driver;

    static final String USERNAME = ".//*[@id='registerForm:username']";
    static final String PASSWORD = ".//*[@id='registerForm:password']";
    static final String CONFIRM_PASSWORD = ".//*[@id='registerForm:confirmPassword']";
    static final String EMAIL = ".//*[@id='registerForm:email']";
    static final String SUBMIT = ".//*[@type='submit']";
    static final String REGISTRATION = ".//*[.='Registration']";
    static final String REGISTRATION_PAGE_URL = "http://s1.web.sumdu.edu.ua:8080/pages/registration.xhtml";
    static final String LOGIN_PAGE = "Login Page";
    static final String TITLE = "Registration";
    static final String LOGIN = ".//tr[3]/td[2]/input";

    String[] userNames = new String[]{"        ","2","b","123455781","апролджа","12345@#$"};
    String[] passwords = new String[]{"        ","@#!%^&&*","12345678","123","123456asdFGH","123#@!$%^&*","фывапрр","asdfffff"};
    String[] emails = new String[]{"asdas.rt","asd@asd.a","asdf@qwe.12","...@...","1@1.1"};

    @Before
    public void navigationToRegistrationPage() {
        System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://s1.web.sumdu.edu.ua:8080");
        driver.findElement(By.xpath(REGISTRATION)).click();
    }

    @Test
    public void a10registrationWithInvalidUserName(){
        for(String name : userNames){
            driver.findElement(By.xpath(USERNAME)).sendKeys(name);
            driver.findElement(By.xpath(PASSWORD)).sendKeys(etalon[1]);
            driver.findElement(By.xpath(CONFIRM_PASSWORD)).sendKeys(etalon[1]);
            driver.findElement(By.xpath(EMAIL)).sendKeys(etalon[2]);
            driver.findElement(By.xpath(SUBMIT)).click();
            if (LOGIN_PAGE.equals(driver.getTitle())){
                System.out.println("Name: " + name + " was passed");
            }
            assertEquals(TITLE,driver.getTitle());
            driver.get(REGISTRATION_PAGE_URL);
        }
    }

    @Test
    public void a20registrationWithInvalidPassword(){
        for(String name : passwords){
            driver.findElement(By.xpath(USERNAME)).sendKeys(etalon[0]);
            driver.findElement(By.xpath(PASSWORD)).sendKeys(name);
            driver.findElement(By.xpath(CONFIRM_PASSWORD)).sendKeys(name);
            driver.findElement(By.xpath(EMAIL)).sendKeys(etalon[2]);
            driver.findElement(By.xpath(SUBMIT)).click();
            if (LOGIN_PAGE.equals(driver.getTitle())){
                System.out.println("Password: " + name + "was passed");
            }
            assertEquals(driver.getTitle(),TITLE);
            driver.get(REGISTRATION_PAGE_URL);
        }
    }

    @Test
    public void a30registrationWithInvalidRepeatPassword(){
        for(String name : passwords){
            driver.findElement(By.xpath(USERNAME)).sendKeys(etalon[0]);
            driver.findElement(By.xpath(PASSWORD)).sendKeys(etalon[1]);
            driver.findElement(By.xpath(CONFIRM_PASSWORD)).sendKeys(name);
            driver.findElement(By.xpath(EMAIL)).sendKeys(etalon[2]);
            driver.findElement(By.xpath(SUBMIT)).click();
            assertEquals(driver.getTitle(),TITLE);
            driver.get(REGISTRATION_PAGE_URL);
        }
    }

    @Test
    public void a40registrationWithInvalidEmail(){
        for(String name : emails){
            driver.findElement(By.xpath(USERNAME)).sendKeys(etalon[0]);
            driver.findElement(By.xpath(PASSWORD)).sendKeys(etalon[1]);
            driver.findElement(By.xpath(CONFIRM_PASSWORD)).sendKeys(etalon[1]);
            driver.findElement(By.xpath(EMAIL)).sendKeys(name);
            driver.findElement(By.xpath(SUBMIT)).click();
            if (LOGIN_PAGE.equals(driver.getTitle())){
                System.out.println("Email: " + name + "was passed");
            }
            assertEquals(driver.getTitle(),TITLE);
            driver.get(REGISTRATION_PAGE_URL);
        }
    }

    @Test
    public void a50successRegistration(){
        driver.findElement(By.xpath(USERNAME)).sendKeys(etalon[0]);
        driver.findElement(By.xpath(PASSWORD)).sendKeys(etalon[1]);
        driver.findElement(By.xpath(CONFIRM_PASSWORD)).sendKeys(etalon[1]);
        driver.findElement(By.xpath(EMAIL)).sendKeys(etalon[2]);
        driver.findElement(By.xpath(SUBMIT)).click();
        assertEquals("Login Page",driver.getTitle());
    }

    @Test
    public void a60loginWithEmptyFields(){
        driver.get(LOGIN_PAGE_URL);
        driver.findElement(By.xpath(LOGIN)).click();
        assertEquals(driver.getTitle(),LOGIN_PAGE);
    }

    @Test
    public void a70successfulLogin(){
        driver.get(LOGIN_PAGE_URL);
        driver.findElement(By.xpath(".//tr[1]/td[2]/input")).sendKeys(etalon[0]);
        driver.findElement(By.xpath(".//tr[2]/td[2]/input")).sendKeys(etalon[1]);
        driver.findElement(By.xpath(".//tr[3]/td[2]/input")).click();
        assertEquals("Top",driver.getTitle());
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}

