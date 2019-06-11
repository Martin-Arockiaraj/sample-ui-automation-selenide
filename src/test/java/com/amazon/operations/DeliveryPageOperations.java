package com.amazon.operations;

import com.amazon.utilities.TestDataReader;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import static com.amazon.locators.AddressPageLocators.*;

// This page defines the test operations for Product (Amazon) delivery page

public class DeliveryPageOperations {

    SoftAssert softAssertion = new SoftAssert();

    public void checkItemDeliveryTitle() {
        Selenide.Wait().until(ExpectedConditions.visibilityOf(pageHeaderTitle));
        softAssertion.assertEquals(pageHeaderTitle.getText(), TestDataReader.getDataReader().getData("delivery.page.title"));
    }

    public void clickNewAddressDeliveryLink() {
        Selenide.Wait().until(ExpectedConditions.visibilityOf(newDeliveryAddressLink));
        newDeliveryAddressLink.click();
    }

    public void enterDeliveryUserContactDetails() {
        Selenide.Wait().until(ExpectedConditions.visibilityOf(fullNameField));
        fullNameField.click();
        fullNameField.clear();
        fullNameField.sendKeys(TestDataReader.getDataReader().getData("full.name.field"));
        Selenide.sleep(2000);
        mobileNumberField.clear();
        mobileNumberField.sendKeys(TestDataReader.getDataReader().getData("mobile.number"));
    }

    public void enterDeliveryPinCodeDetails() {
        Selenide.sleep(2000);
        Selenide.Wait().until(ExpectedConditions.visibilityOf(pinCodeField));
        pinCodeField.click();
        pinCodeField.clear();
        pinCodeField.sendKeys(TestDataReader.getDataReader().getData("pin.code.number"));
    }

    public void enterAddressDetails() {
        Selenide.sleep(2000);
        Selenide.Wait().until(ExpectedConditions.visibilityOf(companyField));
        companyField.click();
        companyField.clear();
        companyField.sendKeys(TestDataReader.getDataReader().getData("company.name"));
        Selenide.sleep(2000);
        Selenide.Wait().until(ExpectedConditions.visibilityOf(areaField));
        areaField.click();
        areaField.clear();
        areaField.sendKeys(TestDataReader.getDataReader().getData("area.name"));
    }

    public void enterDeliveryCityDetails() {
        Selenide.sleep(2000);
        Selenide.Wait().until(ExpectedConditions.visibilityOf(cityField));
        cityField.click();
        cityField.clear();
        cityField.sendKeys(TestDataReader.getDataReader().getData("delivery.city.name"));
    }

    public void submitDelivery() {
        Selenide.sleep(2000);
        deliverToThisAddressBtn.scrollTo();
        Selenide.sleep(2000);
        Selenide.Wait().until(ExpectedConditions.visibilityOf(deliverToThisAddressBtn));
        deliverToThisAddressBtn.click();
    }

    public void checkItemPaymentPageRedirection() {
        Selenide.Wait().until(ExpectedConditions.visibilityOf(pageHeaderTitle));
        softAssertion.assertEquals(pageHeaderTitle.getText(), TestDataReader.getDataReader().getData("payment.page.title"));
    }
}