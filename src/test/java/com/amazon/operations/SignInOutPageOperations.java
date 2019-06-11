package com.amazon.operations;

import com.amazon.utilities.TestDataReader;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.amazon.locators.SignInOutPageLocators.*;

// This page defines the test operations for Sign In and Sign Out flow in the Amazon Website

public class SignInOutPageOperations {

    public void goToSignInPage() {
        Selenide.sleep(2000);
        yourOrderBtn.click();
    }

    public void enterEmailId() {
        Selenide.sleep(2000);
        Selenide.Wait().until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(TestDataReader.getDataReader().getData("user.email.id"));
        Selenide.Wait().until(ExpectedConditions.visibilityOf(continueBtn));
        continueBtn.click();
    }

    public void enterPassword() {
        Selenide.Wait().until(ExpectedConditions.visibilityOf(passwordBtn));
        passwordBtn.sendKeys(TestDataReader.getDataReader().getData("user.password"));
        Selenide.Wait().until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();
    }
}