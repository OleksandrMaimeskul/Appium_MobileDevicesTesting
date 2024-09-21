package appiumIntro;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.By;
import org.springframework.core.NativeDetector;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.MobileUtils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PracticeAppium {
    @Test
    public void validateAppDebugFunctionality() {
        /*
1-Setup your Automation
 -->Click Ok button
2-Click + Button
3-Send your Name and Task
4-Validate Important Task is visible,enable and not selected.
5-Select important Task box button
6-Click Ok Button and Validate Name and Task shows up correctly on the list
7-Click X button and Ok Button(uio)
8-Validate the message is "The list does not contain any element !"
9-Proud of yourself
 *
         */

        AndroidDriver<AndroidElement> androidDriver = MobileUtils.getDriver("src/test/resources/app-debug.apk");
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        AndroidElement okButton = androidDriver.findElement(By.id("android:id/button1"));
        MobileUtils.elementTab(androidDriver, okButton);

        AndroidElement plusButton = androidDriver.findElement(By.id("fr.stevenfrancony.mytodolist:id/addButton"));
        MobileUtils.elementTab(androidDriver, plusButton);

        AndroidElement nameEnter = androidDriver.findElement(By.xpath("//android.widget.EditText[@text=\"Name...\"]"));
        nameEnter.sendKeys("Oleksandr");
        AndroidElement taskEnter = androidDriver.findElement(By.xpath("//android.widget.EditText[@text=\"Task...\"]"));
        taskEnter.sendKeys("Appium Practice");
        AndroidElement importantTaskCheckBox = androidDriver.findElement(By.className("android.widget.CheckBox"));
        Assert.assertTrue(importantTaskCheckBox.isDisplayed() && importantTaskCheckBox.isEnabled() && !importantTaskCheckBox.isSelected());
        MobileUtils.elementTab(androidDriver, importantTaskCheckBox);
        AndroidElement anotherOkButton = androidDriver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]"));
        MobileUtils.elementTab(androidDriver, anotherOkButton);
        AndroidElement createdTask = androidDriver.findElementByAndroidUIAutomator("text(\"Oleksandr\")");
        Assert.assertTrue(createdTask.getText().contains("Oleksandr"));
        AndroidElement xButton = androidDriver.findElement(By.xpath("//android.widget.ImageButton[@resource-id=\"fr.stevenfrancony.mytodolist:id/clearButton\"]"));
        MobileUtils.elementTab(androidDriver, xButton);
        AndroidElement OUIBUTTON = androidDriver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]"));
        MobileUtils.elementTab(androidDriver, OUIBUTTON);
        AndroidElement textAfterDeleting = androidDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"fr.stevenfrancony.mytodolist:id/list_status\"]"));
        Assert.assertTrue(textAfterDeleting.getText().contains("The list doesn't contain any element !"));
    }

    @Test
    public void validateGeneralStoreApp() {
        /*
    1-Navigate to Store apk
    2-Choose Belgium from the country drop-down
    3-Provide "Suzan" and choose Gender Female
    4-Click Lets Shop Button
    5-Add to cart first 2 elements
    6-Click Cart Button and validate the name of the products and prices
    7-Validate the total price is matching with website price
    8-Check box is displayed,enabled,not selected and click the box
    9-Validate the Visit Store button is displayed
    10-Proud of yourself
     */
//        AndroidDriver<AndroidElement> androidDriver = MobileUtils.getDriver("src/test/resources/General-Store.apk");
//        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        AndroidElement countryChoose = androidDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\"]"));
//        MobileUtils.elementTab(androidDriver, countryChoose);
//        MobileUtils.scroll(androidDriver, "Belgium");
//        MobileUtils.elementTab(androidDriver,countryChoose);
//
//        AndroidElement yourName = androidDriver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.androidsample.generalstore:id/nameField\"]"));
//        yourName.sendKeys("Suzan");
//
//        AndroidElement female = androidDriver.findElement(By.xpath("//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioFemale\"]"));
//        MobileUtils.elementTab(androidDriver, female);
//
//        AndroidElement letShopButton = androidDriver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.androidsample.generalstore:id/btnLetsShop\"]"));
//        MobileUtils.elementTab(androidDriver, letShopButton);
//
//        AndroidElement addToCart = androidDriver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[1]"));
//        MobileUtils.elementTab(androidDriver, addToCart);
//
//        AndroidElement addToCart2 = androidDriver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[2]"));
//        MobileUtils.elementTab(androidDriver, addToCart2);
//
//        AndroidElement cartButton = androidDriver.findElement(By.xpath("//android.widget.ImageButton[@resource-id=\"com.androidsample.generalstore:id/appbar_btn_cart\"]"));
//        MobileUtils.elementTab(androidDriver, cartButton);
//
////        List<AndroidElement> nameOfShoes = androidDriver.findElements(By.id("com.androidsample.generalstore:id/productName"));
////        List<String> expectedNames = Arrays.asList("Air Jordan 4 Retro", "Air Jordan 1 Mid SE");
////        for (AndroidElement eachNameOfShoes : nameOfShoes) {
////            Assert.assertEquals(expectedNames, eachNameOfShoes.getText());
////        }
//        List<AndroidElement> prices = androidDriver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
//        List<String> expectedPrices = Arrays.asList("$160.97", "$120.0");
//        int i = Integer.parseInt(String.valueOf(expectedPrices));
//        System.out.println(i);
////        for (AndroidElement eachNameOfShoes : nameOfShoes) {
////            Assert.assertEquals(expectedNames, eachNameOfShoes);
////        }


    }


}
