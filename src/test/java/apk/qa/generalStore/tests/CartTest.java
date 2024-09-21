package apk.qa.generalStore.tests;

import apk.qa.generalStore.pages.CartPage;
import apk.qa.generalStore.pages.LoginPage;
import apk.qa.generalStore.pages.ProductPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;

public class CartTest extends TestBase{
    @Test
    public void validateCartInfor(){
        LoginPage loginPage = new LoginPage(androidDriver);
        loginPage.login(androidDriver,"Belgium","Suzan");
        ProductPage productPage = new ProductPage(androidDriver);
        productPage.addingItemsInCart(androidDriver);
        CartPage cartPage=new CartPage(androidDriver);
        cartPage.validateCartInfo("Air Jordan 4 Retro","Air Jordan 1 Mid SE","$160.97","$120.0");
    }
}
