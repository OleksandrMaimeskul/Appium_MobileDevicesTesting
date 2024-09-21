package apk.qa.generalStore.pages;

import apk.qa.generalStore.tests.CartTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class CartPage {
    public CartPage(AndroidDriver<AndroidElement> androidDriver){
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver, Duration.ofSeconds(10)),this);
    }
    @AndroidFindBy(id="com.androidsample.generalstore:id/productName")
    List<AndroidElement> allNames;
    @AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
    List<AndroidElement> allPrices;
    @AndroidBy(id="com.androidsample.generalstore:id/totalAmountLbl")
    AndroidElement totalPrice;
    @AndroidBy(xpath = "//android.widget.CheckBox[@text=\"Send me e-mails on discounts related to selected products in future\"]")
    AndroidElement checkbox;
    @AndroidBy(id = "com.androidsample.generalstore:id/btnProceed")
    AndroidElement visitStore;

    public void validateCartInfo(String product1,String product2,String price1,String price2){
        List<String> expectedNames = Arrays.asList(product1,product2);
        List<String> expectedPrices = Arrays.asList(price1,price2);
        for (int i = 0; i <allNames.size() ; i++) {
            Assert.assertEquals(allNames.get(i).getText().trim(),expectedNames.get(i));
            Assert.assertEquals(allPrices.get(i).getText().trim(),expectedPrices.get(i));

        }
        System.out.println(allPrices.get(0).getText());
        System.out.println(allPrices.get(1).getText());
        System.out.println(totalPrice.getText());
        double actualPrice = Double.parseDouble(totalPrice.getText().substring(2));
        double expectedPrice = Double.parseDouble(price1.substring(1)+Double.parseDouble(price2.substring(1)));
        Assert.assertEquals(actualPrice,expectedPrice);
        Assert.assertTrue(checkbox.isDisplayed()&&checkbox.isEnabled()&&!checkbox.isSelected());
        checkbox.click();
        Assert.assertTrue(visitStore.isDisplayed()&&visitStore.isEnabled());
    }




}
