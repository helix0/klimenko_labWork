/**
 * Created by user on 09.10.2014.
 */
public class Paths {
    static final String LOGIN_PAGE_URL = "http://s1.web.sumdu.edu.ua:8080";
    static final String SELECT_OPTION = "//select/option";

    //CREATION
    static final String CREATE = "//div[@id='table_header']//a[contains(.,'Create')]";
    static final String ROWS = "//div[@id='table_data']//td/input";
    static final String SAVE = ".//*[@id='table_header']//*/input";
    static final String COUNTRIES = "//tbody[@id='j_idt76:tabView:j_idt89_data']//a";
    static final String CITIES = "//tbody[@id='j_idt76:tabView:j_idt109_data']//a";
    static final String BUILDINGS = "//tbody[@id='j_idt76:tabView:j_idt109_data']//a";
    static final String FLOORS = "//tbody[@id='j_idt76:tabView:j_idt113_data']//a";
    static final String ROOMS = "//tbody[@id='j_idt76:tabView:j_idt109_data']//a";
    static final String RACKS = "//tbody[@id='j_idt76:tabView:j_idt107_data']//a";
    static final String POSTERM = "//tbody[@id='j_idt76:tabView:j_idt158_data']//a";
    static final String DEVICE = "//tbody[@id='j_idt76:tabView:j_idt113_data']//a";
    static final String PAYBOX = "//tbody[@id='j_idt76:tabView:j_idt143_data']//a";
    static final String ATM = "//tbody[@id='j_idt76:tabView:j_idt128_data']//a";

    //search
    static final String FIND = "//div[@id='navigation_toolbar']//td[2]//a";
    static final String TEXT = "//form//input[@type='text']";
    static final String SUBMIT = "//form//input[@type='submit']";

    //registration
    static final String USERNAME = ".//*[@id='registerForm:username']";
    static final String PASSWORD = ".//*[@id='registerForm:password']";
    static final String CONFIRM_PASSWORD = ".//*[@id='registerForm:confirmPassword']";
    static final String EMAIL = ".//*[@id='registerForm:email']";
    static final String REGISTRATION = ".//*[.='Registration']";
    static final String REGISTRATION_PAGE_URL = "http://s1.web.sumdu.edu.ua:8080/pages/registration.xhtml";
    static final String LOGIN_PAGE = "Login Page";
    static final String TITLE = "Registration";
    static final String LOGIN = ".//tr[3]/td[2]/input";

    //editing
    static final String PARAMETERS = "//div[@id='j_idt76:tabView']//a[text()='Parameters']";
    static final String EDIT = "//div[@id='j_idt76:tabView']//a[contains(.,'Edit')]";
    static final String AFTER_EDIT = "//div[@id='j_idt76:tabView:tab2']//div[@id='table_data']//td[@class='parameter']";
    static final String SAVE_EDITING = "//form[@id='j_idt74']//input[@value='Save']";
    static final String SELECTED = "//select/option[@selected]";

    //remove
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
    static final String ATM_CHECKBOX = "//div[@id='j_idt76:tabView:j_idt128']//td[@class='object_name']/input[@type='checkbox']";
    static final String ATM_A = "//div[@id='j_idt76:tabView:j_idt128']//td[@class='object_name']/a";
    static final String PAYBOX_CHECKBOX = "//div[@id='j_idt76:tabView:j_idt136']//td[@class='object_name']/input[@type='checkbox']";
    static final String PAYBOX_A = "//div[@id='j_idt76:tabView:j_idt136']//td[@class='object_name']/a";
    static final String POSTERM_CHECKBOX = "//div[@id='j_idt76:tabView:j_idt158']//td[@class='object_name']/input[@type='checkbox']";
    static final String POSTERM_A = "//div[@id='j_idt76:tabView:j_idt158']//td[@class='object_name']/a";
    static final String LINK_CHECKBOX = "//input[@type='checkbox']";
    static final String LINK_A = "//td[@class='object_name']/a[@class='link']";
}
