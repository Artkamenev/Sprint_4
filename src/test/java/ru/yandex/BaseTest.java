package ru.yandex;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.AboutRentPage;
import pageObjects.MainPage;
import pageObjects.OrderPage;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    public static FirefoxDriver driver;
    /*public static WebDriver driver;*/
    public static WebDriverWait wait;

    MainPage mainPage = new MainPage();
    OrderPage orderPage = new OrderPage();
    AboutRentPage aboutRentPage = new AboutRentPage();

    @BeforeClass
    public static void setup() {
        driver = new FirefoxDriver();
        /*driver = new ChromeDriver()*/
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 3);
    }

    @Before
    public void setupBeforeTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @After
    public void clearData() {
        driver.manage().deleteAllCookies();
        ((WebStorage)driver).getSessionStorage().clear();
        ((WebStorage)driver).getLocalStorage().clear();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}