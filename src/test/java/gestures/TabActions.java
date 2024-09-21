package gestures;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.MobileUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.Platform.ANDROID;

public class TabActions {

    @Test
    public void tabTest() throws MalformedURLException {
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setPlatform(ANDROID);
//        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"sdk_gphone64_x86_64");
//        desiredCapabilities.setCapability(MobileCapabilityType.APP, new File("src/test/resources/ApiDemos-debug-newVersion.apk").getAbsolutePath());
//        URL appiumServURL = new URL(("http://0.0.0.0:4723/wd/hub"));
//        AndroidDriver<AndroidElement> androidDriver = new AndroidDriver<>(appiumServURL,desiredCapabilities);
        AndroidDriver<AndroidElement> androidDriver = MobileUtils.getDriver("src/test/resources/ApiDemos-debug-newVersion.apk");
        AndroidElement contentButton = androidDriver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Content\"]"));
//        TouchAction touchAction = new TouchAction<>(androidDriver);
//        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(contentButton))).perform();
        MobileUtils.elementTab(androidDriver, contentButton);
        androidDriver.navigate().back();

    }

    @Test
    public void longPressTest() {
        AndroidDriver<AndroidElement> androidDriver = MobileUtils.getDriver("src/test/resources/ApiDemos-debug-newVersion.apk");
        AndroidElement viewButton = androidDriver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"));
        MobileUtils.elementTab(androidDriver, viewButton);
        AndroidElement expendableList = androidDriver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]"));
        MobileUtils.elementTab(androidDriver, expendableList);
        AndroidElement customAdapter = androidDriver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]"));
        MobileUtils.elementTab(androidDriver, customAdapter);
        List<AndroidElement> allNames = androidDriver.findElements(By.className("android.widget.TextView"));
        for (AndroidElement eachName : allNames) {
            System.out.println(eachName.getText());
        }

    }

    @Test
    public void longPress() {
        AndroidDriver<AndroidElement> androidDriver = MobileUtils.getDriver("src/test/resources/ApiDemos-debug-newVersion.apk");
        AndroidElement viewButton = androidDriver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"));
        MobileUtils.elementTab(androidDriver, viewButton);
        AndroidElement expendableList = androidDriver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]"));
        MobileUtils.elementTab(androidDriver, expendableList);
        AndroidElement customAdapter = androidDriver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]"));
        MobileUtils.elementTab(androidDriver, customAdapter);
        List<AndroidElement> allNames = androidDriver.findElements(By.className("android.widget.TextView"));
        for (AndroidElement eachName : allNames) {
            if (eachName.getText().endsWith("Names")) {
                System.out.println(eachName.getText());
            }
        }
//        MobileUtils.longPress(androidDriver, allNames.getLast(), 3);
        AndroidElement option = androidDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Sample menu\"]"));
        Assert.assertTrue(option.isDisplayed());
    }

    @Test
    public void scrollTest() {
        AndroidDriver<AndroidElement> androidDriver = MobileUtils.getDriver("src/test/resources/ApiDemos-debug-newVersion.apk");
        AndroidElement viewButton = androidDriver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"));
        MobileUtils.elementTab(androidDriver, viewButton);
        AndroidElement textClock = androidDriver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"TextClock\"]"));
        MobileUtils.scroll(androidDriver, "TextClock");
        MobileUtils.elementTab(androidDriver, textClock);
    }
}
