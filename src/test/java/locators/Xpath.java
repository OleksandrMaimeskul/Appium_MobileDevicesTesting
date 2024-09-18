package locators;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Xpath {
    @Test
    public void validateAlarmOption() throws MalformedURLException {
        //1-step provide location of application
        File file = new File("src/test/resources/ApiDemos-debug-newVersion.apk");

        //2-step Desired Capabilities
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "sdk_gphone64_x86_64");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("app", file.getAbsolutePath());

        //3-Step Connection with Appium Server
        URL appiumServerURL = new URL("http://0.0.0.0:4723/wd/hub");
        AndroidDriver<AndroidElement> androidDriver = new AndroidDriver(appiumServerURL, desiredCapabilities);
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        AndroidElement appButton = androidDriver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"App\"]"));
        Assert.assertTrue(appButton.isDisplayed());
        appButton.click();
        AndroidElement  alaramButton = androidDriver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Alarm\"]"));
        Assert.assertTrue(alaramButton.isDisplayed());
        alaramButton.click();
        AndroidElement alaramController = androidDriver.findElementByAccessibilityId("Alarm Controller");
        Assert.assertTrue(alaramController.isDisplayed());
        alaramController.click();
        List<AndroidElement> allOptions = androidDriver.findElements(By.className("android.widget.Button"));
        for (AndroidElement option :allOptions){
            System.out.println(option.getText());
        }
        AndroidElement oneShotAlarm = androidDriver.findElement(By.id("io.appium.android.apis:id/one_shot"));
        Assert.assertEquals(oneShotAlarm.getText(),"One shot Alarm");
        oneShotAlarm.click();
    }
}
