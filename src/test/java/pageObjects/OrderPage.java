package pageObjects;

import org.openqa.selenium.By;

public class OrderPage {

    //локатор для поля - имя
    private By nameField = By.xpath("//input[@placeholder='* Имя']");
    //локатор для поля - фамилия
    private By surnameField = By.xpath("//input[@placeholder='* Фамилия']");
    //локатор для поля - адрес куда привезти заказ
    private By addressWhereToBringField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //локатор для открытия поля (дропдаун) - станция метро
    private By dropDownMetroStationField = By.xpath("//input[@placeholder='* Станция метро']");
    //локатор для выбора станции метро Университет
    private By metroStationUniversity = By.xpath("//div[text()='Университет']");
    //локатор для поля - телефон:на него позвонит курьер
    private By phoneNumberField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    //локатор для кнопки - далее
    private By buttonNext = By.xpath("//button[text()='Далее']");

    public By getNameField() {
        return nameField;
    }

    public By getSurnameField() {
        return surnameField;
    }

    public By getAddressWhereToBringField() {
        return addressWhereToBringField;
    }

    public By getDropDownMetroStationField() {
        return dropDownMetroStationField;
    }

    public By getMetroStationUniversity() {
        return metroStationUniversity;
    }

    public By getPhoneNumberField() {
        return phoneNumberField;
    }

    public By getButtonNext() {
        return buttonNext;
    }
}