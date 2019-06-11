package com.amazon.locators;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

// This PAGE defines the Object Repository AMAZON: SIGN IN & SIGN OUT Pages.

public class SignInOutPageLocators {

    // Web Elements

    public static SelenideElement yourOrderBtn = $("#nav-tools a:nth-child(1)");
    public static SelenideElement emailField = $("#ap_email");
    public static SelenideElement continueBtn = $("input#continue");
    public static SelenideElement passwordBtn = $("input#ap_password");
    public static SelenideElement loginButton = $("#auth-signin-button");
}