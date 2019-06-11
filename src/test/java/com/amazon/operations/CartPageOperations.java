package com.amazon.operations;

import com.amazon.utilities.TestDataReader;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import static com.amazon.locators.SearchPageLocators.*;

// This page defines the test operations for Cart Page

public class CartPageOperations {

    SoftAssert softAssertion = new SoftAssert();

    public void checkAddedItemInCartPage() {
        Selenide.Wait().until(ExpectedConditions.visibilityOf(selectedDeviceNameTitle));
        softAssertion.assertEquals(selectedDeviceNameTitle.getText(), TestDataReader.getDataReader().getData("searched.device.name"));
    }

    public void editItemQuantity() {
        Selenide.Wait().until(ExpectedConditions.visibilityOf(itemQuantityDropDown));
        Selenide.actions().moveToElement(itemQuantityDropDown).click().perform();
        Selenide.sleep(2000);
        Selenide.Wait().until(ExpectedConditions.visibilityOf(quantityNumber.get(1)));
        Selenide.actions().moveToElement(quantityNumber.get(1)).click().perform();
        Selenide.sleep(2000);
        softAssertion.assertEquals(selectedDeviceNameTitle.getText(), TestDataReader.getDataReader().getData("searched.device.name"));
        softAssertion.assertTrue(shoppingCartNumber.getText().startsWith(TestDataReader.getDataReader().getData("updated.item.cart.caption")));
    }

    public void clickItemBuyButton() {
        Selenide.Wait().until(ExpectedConditions.visibilityOf(proceedToBuyOutBtn));
        proceedToBuyOutBtn.click();
    }
}