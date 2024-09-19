package utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.openqa.selenium.Platform.ANDROID;

public class MobileUtils {
    public static AndroidDriver getDriver(String app) {
        URL appiumServURL = null;
        try {
            appiumServURL = new URL(("http://0.0.0.0:4723/wd/hub"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        DesiredCapabilities desiredCapabilities = getCaps(app);
        AndroidDriver<AndroidElement> androidDriver = new AndroidDriver<>(appiumServURL, desiredCapabilities);
        return androidDriver;
    }

    public static DesiredCapabilities getCaps(String app) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "sdk_gphone64_x86_64");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, new File(app).getAbsolutePath());
        return desiredCapabilities;
    }

    public static void elementTab(AndroidDriver<AndroidElement> androidDriver, AndroidElement androidElement) {
        TouchAction touchAction = new TouchAction<>(androidDriver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(androidElement))).perform();
    }
    public static void longPress(AndroidDriver<AndroidElement>androidDriver,AndroidElement androidElement, int second){
        TouchAction touchAction=new TouchAction(androidDriver);
        touchAction.longPress(LongPressOptions.longPressOptions()
                .withElement(ElementOption.element(androidElement)).withDuration(Duration.ofSeconds(second))).perform();
    }
    public static  AndroidElement scroll(AndroidDriver<AndroidElement>androidDriver,String textLocator){
        return         androidDriver.findElementByAndroidUIAutomator(
                STR."new UiScrollable(new UiSelector()).scrollIntoView(text(\"\{textLocator}\"))");
    }
}
