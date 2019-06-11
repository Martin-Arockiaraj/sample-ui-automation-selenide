package com.amazon.locators;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AddressPageLocators {

    // This PAGE defines the Object Repository for AMAZON: Item Delivery page

    public static SelenideElement pageHeaderTitle = $(".a-container h1.a-spacing-base");
    public static SelenideElement newDeliveryAddressLink = $("a[href='#new-address']");
    public static SelenideElement fullNameField = $$("#identity-add-new-address #enterAddressFullName").get(0);
    public static SelenideElement mobileNumberField = $$("#identity-add-new-address #enterAddressPhoneNumber").get(0);
    public static SelenideElement pinCodeField = $$("#identity-add-new-address #enterAddressPostalCode").get(0);
    public static SelenideElement companyField = $$("#identity-add-new-address #enterAddressAddressLine1").get(0);
    public static SelenideElement areaField = $$("#identity-add-new-address #enterAddressAddressLine2").get(0);
    public static SelenideElement cityField = $$("#identity-add-new-address #enterAddressCity").get(0);
    public static SelenideElement deliverToThisAddressBtn = $$(".a-form-actions span.a-button").get(0);
}