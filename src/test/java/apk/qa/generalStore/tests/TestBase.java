package apk.qa.generalStore.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.aspectj.weaver.ast.And;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.MobileUtils;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public AndroidDriver<AndroidElement> androidDriver;
    @BeforeMethod
    public void setup(){
        androidDriver  = MobileUtils.getDriver("src/test/resources/General-Store.apk");
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown(){
//        androidDriver.guit();
    }


}
