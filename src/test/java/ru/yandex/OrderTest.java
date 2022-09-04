package ru.yandex;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageObjects.OrderPage;

@RunWith(Parameterized.class)

public class OrderTest extends BaseTest {

    private final String name;
    private final String surname;
    private final String address;
    private final String phoneNumber;

    public OrderTest(String name, String surname, String address, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}, {1}, {2}, {3}")
    public static Object[][] getSumData() {
        return new Object[][]{
                {"Артем", "Каменев", "Санкт-Петербург", "89650022044"},
                {"Виктор", "Бардюров", "Москва", "89650022099"},
                {"Алеша", "Хромосомов", "Новосибирск", "89650022077"},
        };
    }

    @Test
    public void createOrderThrowAboveButton() {
        mainPage
                .createOrderThrowAboveButton();

        setFieldsOrderPage();
        aboutRentPage
                .setFieldsAboutRentPage();
    }

    @Test
    public void createOrderThrowBelowButton() {
        mainPage
                .createOrderThrowBelowButton();

        setFieldsOrderPage();
        aboutRentPage
                .setFieldsAboutRentPage();
    }

    //метод генерации значений
    private OrderPage setFieldsOrderPage() {
        driver.findElement(orderPage.getNameField()).sendKeys(name);
        driver.findElement(orderPage.getSurnameField()).sendKeys(surname);
        driver.findElement(orderPage.getAddressWhereToBringField()).sendKeys(address);
        driver.findElement(orderPage.getDropDownMetroStationField()).click();
        driver.findElement(orderPage.getMetroStationUniversity()).click();
        driver.findElement(orderPage.getPhoneNumberField()).sendKeys(phoneNumber);
        driver.findElement(orderPage.getButtonNext()).click();
        return orderPage;
    }
}