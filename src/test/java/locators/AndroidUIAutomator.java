package locators;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.openqa.selenium.Platform.ANDROID;

public class AndroidUIAutomator {
@Test
    public void locatorTest() throws MalformedURLException {
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setPlatform(ANDROID);
    desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"sdk_gphone64_x86_64");
    desiredCapabilities.setCapability(MobileCapabilityType.APP, new File("src/test/resources/ApiDemos-debug-newVersion.apk").getAbsolutePath());
    URL appiumServURL = new URL(("http://0.0.0.0:4723/wd/hub"));
    AndroidDriver<AndroidElement> androidDriver = new AndroidDriver<>(appiumServURL,desiredCapabilities);

    AndroidElement viewsButton = androidDriver.findElementByAndroidUIAutomator("text(\"Views\")");

    viewsButton.click();
    AndroidElement buttons = androidDriver.findElementByAndroidUIAutomator("text(\"Buttons\")");
    buttons.click();
    AndroidElement normalButton = androidDriver.findElementByAndroidUIAutomator("text(\"Normal\")");
    Assert.assertEquals(normalButton.getText(),"Normal");

    androidDriver.navigate().back();
    AndroidElement autoCompleteButton = androidDriver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Auto Complete\"]"));
    autoCompleteButton.click();
    AndroidElement screenTopButton = androidDriver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Screen Top\"]"));
    screenTopButton.click();
    AndroidElement countryEnter = androidDriver.findElement(By.xpath("//android.widget.AutoCompleteTextView[@resource-id=\"io.appium.android.apis:id/edit\"]"));
   countryEnter.sendKeys("Oleksandr");
    AndroidElement giveMeFocusButton = androidDriver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Give me Focus\"]"));
    giveMeFocusButton.click();
    Assert.assertEquals(countryEnter.getText(),"Oleksandr");


}




}
