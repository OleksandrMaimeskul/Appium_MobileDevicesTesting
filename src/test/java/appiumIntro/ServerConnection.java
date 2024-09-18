package appiumIntro;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class ServerConnection {

    //
    @Test
    public void connectionTest() throws MalformedURLException {

        File apkFile = new File("src/test/resources/ApiDemos-debug-newVersion.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName","sdk_gphone64_x86_64");
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("app",apkFile.getAbsolutePath());

        URL appiumServerURL=new URL("http://0.0.0.0:4723/wd/hub");
        AndroidDriver androidDriver = new AndroidDriver(appiumServerURL,desiredCapabilities);
    }
}
