package pageObjects;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;

import static org.hamcrest.core.StringContains.containsString;
import static ru.yandex.BaseTest.driver;

public class AboutRentPage {

    //локатор для поля - когда привезти самокат
    private By whenBringScooterField = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //локатор для выбора даты в календаре
    private By whenBringScooterDate = By.xpath("//div[@aria-label='Choose воскресенье, 4-е сентября 2022 г.']");
    //локатор для поля (дропдаун) - срок аренды
    private By rentalPeriodField = By.xpath("//div[@class='Dropdown-placeholder']");
    //локатор для выбора сутки
    private By rentalDay = By.xpath("//div[text()='сутки']");
    //локатор чек-бокса цвет самоката - черный жемчуг
    private By blackPearlCheckBox = By.xpath("//input[@class='Checkbox_Input__14A2w'][@id='black']");
    //локатор для поля- Комментарий для курьера
    private By commentForCourierField = By.xpath("//input[@placeholder='Комментарий для курьера']");
    //локатор для кнопки заказать
    private By orderButton = By.xpath("//button[text()='Заказать'][@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //локатор для кнопки подтверждения заказа
    private By approveOrderButtonYes = By.xpath("//button[text()='Да'][@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //локатор поля подтверждающего успешность заказа
    private By textByOrder = By.xpath("//div[text() = 'Заказ оформлен']");

    public AboutRentPage setFieldsAboutRentPage() {

        driver.findElement(whenBringScooterField).click();
        driver.findElement(whenBringScooterDate).click();
        driver.findElement(rentalPeriodField).click();
        driver.findElement(rentalDay).click();
        driver.findElement(blackPearlCheckBox).click();
        driver.findElement(commentForCourierField).sendKeys("Быстрее, пожалуйста");
        driver.findElement(orderButton).click();
        driver.findElement(approveOrderButtonYes).click();

        String expected = "Заказ оформлен";
        String actual = driver.findElement(textByOrder).getText();
        MatcherAssert.assertThat(actual, containsString(expected));
        return this;
    }
}