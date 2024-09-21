package apk.qa.generalStore.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.commons.logging.Log;
import org.aspectj.weaver.ast.And;
import org.aspectj.weaver.loadtime.Agent;
import org.openqa.selenium.support.PageFactory;
import utils.MobileUtils;

import java.time.Duration;

public class LoginPage {
    public LoginPage(AndroidDriver<AndroidElement> androidDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver, Duration.ofSeconds(10)), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/text1\"]")
    AndroidElement country;
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.androidsample.generalstore:id/nameField\"]")
    AndroidElement name;
    @AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioFemale\"]")
    AndroidElement female;
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.androidsample.generalstore:id/btnLetsShop\"]")
    AndroidElement letsShopButton;

    public void login(AndroidDriver<AndroidElement> androidDriver, String chooseCountry, String name) {
        MobileUtils.elementTab(androidDriver, country);
        MobileUtils.scroll(androidDriver, chooseCountry).click();
        this.name.sendKeys(name);
        MobileUtils.elementTab(androidDriver, female);
        MobileUtils.elementTab(androidDriver, letsShopButton);

    }
}
