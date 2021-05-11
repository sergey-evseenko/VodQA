package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.offset.ElementOption;

import static org.testng.Assert.assertEquals;

public class LongPressPage extends BasePage{

    @AndroidFindBy(xpath = "//*[@content-desc='longPress']")
    @iOSXCUITFindBy(xpath = "//*[@name='longPress']")
    MobileElement longPress;
    @AndroidFindBy(accessibility = "longpress")
    MobileElement longPressButton;
    @AndroidFindBy(id = "android:id/message")
    MobileElement successMessage;
    @AndroidFindBy(id = "android:id/button1")
    MobileElement okButton;

    public LongPressPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public LongPressPage openPage(){
        longPress.click();
        return this;
    }

    public LongPressPage longPress(){
        touchAction.longPress(ElementOption.element(longPressButton)).release().perform();
        return this;
    }

    public LongPressPage verifySuccessMessage(String message){
        assertEquals(successMessage.getText(), message);
        return this;
    }

    public LongPressPage clickOk(){
        okButton.click();
        return this;
    }
}
