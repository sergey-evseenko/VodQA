package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

import static org.testng.Assert.assertEquals;

public class DoubleTabPage extends BasePage{

    @AndroidFindBy(accessibility = "doubleTapMe")
    MobileElement doubleTabButton;
    @AndroidFindBy(id = "android:id/message")
    MobileElement successMessage;
    @AndroidFindBy(id = "android:id/button1")
    MobileElement okButton;

    public DoubleTabPage(AppiumDriver driver) {
        super(driver);
    }

    @Override
    public DoubleTabPage openPage(String title){
        clickMenu(title);
        return this;
    }

    public DoubleTabPage doubleTab(){
        touchAction.tap(TapOptions
                .tapOptions()
                .withTapsCount(2)
                .withElement(ElementOption.element(doubleTabButton)))
                .perform();
        return this;
    }

    public DoubleTabPage verifySuccessMessage(String message){
        assertEquals(successMessage.getText(), message);
        return this;
    }

    public DoubleTabPage clickOk(){
        okButton.click();
        return this;
    }
}