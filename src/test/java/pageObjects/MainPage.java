package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static ru.yandex.BaseTest.driver;

public class MainPage {

    //массив текста из каждого элемента выпадающего списка
    public static String[] expected = new String[8];

    static {
        expected[0] = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        expected[1] = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        expected[2] = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        expected[3] = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        expected[4] = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        expected[5] = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        expected[6] = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        expected[7] = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
    }

    //локатор для кнопки Заказать вверху формы
    private By orderAboveButton = By.xpath("//button[@class='Button_Button__ra12g']");
    //локатор для кнопки Заказать внизу формы
    private By orderBelowButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public MainPage createOrderThrowAboveButton() {
        //метод нажатия кнопки заказать вверху формы
        driver.findElement(orderAboveButton).click();
        return this;
    }

    public MainPage createOrderThrowBelowButton() {
        WebElement element = driver.findElement(orderBelowButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        //метод нажатия кнопки заказать внизу формы
        driver.findElement(orderBelowButton).click();
        return this;
    }
}