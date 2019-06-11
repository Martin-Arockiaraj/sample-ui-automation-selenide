package com.amazon.locators;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPageLocators {

    // This PAGE defines the Object Repository for AMAZON: Home Page (From Search page to Cart Page).

    public static SelenideElement searchField = $("#twotabsearchtextbox");
    public static ElementsCollection deviceNamesContainer = $$(".a-size-medium.a-color-base.a-text-normal");
    public static ElementsCollection deviceSizeName = $$(".a-button-text div.text span");
    public static SelenideElement addToCartButton = $("#add-to-cart-button");
    public static SelenideElement cartButton = $(".a-row.huc-v2-table-col .a-button-base span.a-button-inner a");
    public static SelenideElement selectedDeviceNameTitle = $$(".sc-list-item-content span.sc-product-title").get(0);
    public static SelenideElement itemQuantityDropDown = $(".a-button-text.a-declarative span.a-dropdown-prompt");
    public static ElementsCollection quantityNumber = $$(".a-dropdown-item.quantity-option");
    public static SelenideElement shoppingCartNumber = $("#sc-subtotal-label-activecart");
    public static SelenideElement proceedToBuyOutBtn = $("#sc-buy-box-ptc-button");
}