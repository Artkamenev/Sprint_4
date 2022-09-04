package ru.yandex;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;
import static pageObjects.MainPage.expected;

public class DropDownTest extends BaseTest {

    @Test
    public void checkTextInDropDownFirst() {
        clickDropDownAndCheckText(0);
    }

    @Test
    public void checkTextInDropDownSecond() {
        clickDropDownAndCheckText(1);
    }

    @Test
    public void checkTextInDropDownThird() {
        clickDropDownAndCheckText(2);
    }

    @Test
    public void checkTextInDropDownFourth() {
        clickDropDownAndCheckText(3);
    }

    @Test
    public void checkTextInDropDownFifth() {
        clickDropDownAndCheckText(4);
    }

    @Test
    public void checkTextInDropDownSixth() {
        clickDropDownAndCheckText(5);
    }

    @Test
    public void checkTextInDropDownSeventh() {
        clickDropDownAndCheckText(6);
    }

    @Test
    public void checkTextInDropDownEighth() {
        clickDropDownAndCheckText(7);
    }

    //метод постановки и сравнения текста фактического и ожидаемого (из массива)
    private void clickDropDownAndCheckText(int index) {
        String question = String.format("accordion__heading-%d", index);
        String answer = String.format("accordion__panel-%d", index);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(question))));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(answer)));

        String actual = driver.findElement(By.id(answer)).getText();
        assertEquals(expected[index], actual);
    }
}
