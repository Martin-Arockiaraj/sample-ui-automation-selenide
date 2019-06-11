package com.amazon.tests;

import com.amazon.operations.CartPageOperations;
import com.amazon.operations.DeliveryPageOperations;
import com.amazon.operations.HomePageOperations;
import com.amazon.operations.SignInOutPageOperations;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

// TEST SUITE for the AMAZON PAGE (SIGN IN, CART TILL PAYMENT CHECKOUT PAGE)

@Log4j2
public class AmazonTest {

    // Pre initialization for operations classes

    private SignInOutPageOperations signOb;
    private HomePageOperations homeObj;
    private CartPageOperations cartObj;
    private DeliveryPageOperations deliveryObj;

    @BeforeSuite(alwaysRun = true)
    public void launchSite() throws Exception {
        WebDriverManager.chromedriver().version("2.46").setup();
        signOb = new SignInOutPageOperations();
        homeObj = new HomePageOperations();
        cartObj = new CartPageOperations();
        deliveryObj = new DeliveryPageOperations();
    }
    //------------------------------------------------------------------------------------------------------------------

    @Test(priority = 0)
    public void openURL() {
        open("https://www.amazon.in/");
        log.error("TC1: Verification of Website launch executed successfully");
    }

    @Test(priority = 1)
    public void testGoToSignInPage() {
        signOb.goToSignInPage();
        log.error("TC2: Verification of Sign In Page redirection verified successfully");
    }

    @Test(priority = 2)
    public void testEnterUserCredentialsForSignIn() {
        signOb.enterEmailId();
        signOb.enterPassword();
        log.error("TC3: Verification of User Login through Email and password executed successfully");
    }

    @Test(priority = 3)
    public void testItemSearchForPurchase() {
        homeObj.searchForDevice();
        log.error("TC4: Verification of an item search for purchase in Home Page executed successfully");
    }

    @Test(priority = 4)
    public void testSelectItemForAddToCart() {
        homeObj.goToDesiredDevice();
        log.error("TC4: Verification of item selection for adding in cart executed successfully");
    }

    @Test(priority = 5)
    public void testSelectedItemBasicDetails() {
        homeObj.checkSelectedDevice();
        log.error("TC5: Verification of selected device shown in cart page or not (basic) executed successfully");
    }

    @Test(priority = 6)
    public void testMovingSelectedItemToCart() {
        homeObj.moveSelectedDeviceToCart();
        log.error("TC6: Verification of adding selected item to cart executed successfully");
    }

    @Test(priority = 7)
    public void testAddedItemInCartPage() {
        cartObj.checkAddedItemInCartPage();
        log.error("TC7: Verification of added item details in cart page executed successfully");
    }

    @Test(priority = 8)
    public void testEditItemQuantityInCartPage() {
        cartObj.editItemQuantity();
        log.error("TC8: Verification of item's quantity edit feature in cart page executed successfully");
    }

    @Test(priority = 9)
    public void testBuyOutItemInCartPage() {
        cartObj.clickItemBuyButton();
        log.error("TC9: Verification of item buy out selection in cart page executed successfully");
    }

    @Test(priority = 10)
    public void testDeliveryPageRedirection() {
        deliveryObj.checkItemDeliveryTitle();
        log.error("TC10: Verification of item cart to delivery page re-direction executed successfully");
    }

    @Test(priority = 11)
    public void testNewAddressDeliveryLinkDirection() {
        deliveryObj.clickNewAddressDeliveryLink();
        log.error("TC11: Verification of new address input link redirection in delivery page executed successfully");
    }

    @Test(priority = 12)
    public void testEnterUserContactDetails() {
        deliveryObj.enterDeliveryUserContactDetails();
        log.error("TC12: Verification of addition of User's contact details in new address section executed successfully");
    }

    @Test(priority = 13)
    public void testEnterUserPinCodeDetails() {
        deliveryObj.enterDeliveryPinCodeDetails();
        log.error("TC13: Verification of addition of User's pin code details in new address delivery section executed successfully");
    }

    @Test(priority = 14)
    public void testEnterDeliveryAddressDetails() {
        deliveryObj.enterAddressDetails();
        log.error("TC14: Verification of addition of User's address details in new address delivery section executed successfully");
    }

    @Test(priority = 15)
    public void testDeliveryCityDetails() {
        deliveryObj.enterDeliveryCityDetails();
        log.error("TC15: Verification of addition of User's city details in new address delivery section executed successfully");
    }

    @Test(priority = 16)
    public void testDeliveryAddressDetailsSubmission() {
        deliveryObj.submitDelivery();
        log.error("TC16: Verification of submission of new address delivery details executed successfully");
    }

    @Test(priority = 17)
    public void testPaymentCheckOutPageDirection() {
        deliveryObj.checkItemPaymentPageRedirection();
        log.error("TC17: Verification of payment checkout page redirection from delivery page executed successfully");
    }
}