package com.amazon.operations;

import com.amazon.utilities.TestDataReader;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import static com.amazon.locators.SearchPageLocators.*;

// This page defines the test operations for Home Page (From Search to Cart operations)

public class HomePageOperations {

    SoftAssert softAssertion = new SoftAssert();

    public void searchForDevice() {
        Selenide.sleep(2000);
        Selenide.Wait().until(ExpectedConditions.visibilityOf(searchField));
        searchField.sendKeys(TestDataReader.getDataReader().getData("device.search.name"));
        Selenide.sleep(2000);
        searchField.sendKeys(Keys.ENTER);
    }

    public void goToDesiredDevice() {
        Selenide.sleep(2000);
        for (SelenideElement element : deviceNamesContainer) {
            if (element.getText().equalsIgnoreCase(TestDataReader.getDataReader().getData("searched.device.name"))) {
                element.parent().click();
                break;
            } else {
                element.scrollTo();
            }
        }
    }

    public void checkSelectedDevice() {
        Selenide.Wait().until(ExpectedConditions.numberOfWindowsToBe(2));
        Selenide.switchTo().window(1);
        Selenide.sleep(2000);
        deviceSizeName.get(1).scrollTo();
        Selenide.Wait().until(ExpectedConditions.visibilityOf(deviceSizeName.get(1)));
        softAssertion.assertEquals(deviceSizeName.get(1).getText(), TestDataReader.getDataReader().getData("device.size"));
    }

    public void moveSelectedDeviceToCart() {
        Selenide.sleep(2000);
        Selenide.Wait().until(ExpectedConditions.visibilityOf(addToCartButton));
        addToCartButton.click();
        Selenide.sleep(2000);
        Selenide.Wait().until(ExpectedConditions.visibilityOf(cartButton));
        cartButton.click();
    }
}