package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class DragDropPage extends BasePage{

    @AndroidFindBy(accessibility = "dragAndDrop")
    @iOSXCUITFindBy(id = "dragAndDrop")
    MobileElement dragAndDrop;
    @AndroidFindBy(accessibility = "dragMe")
    @iOSXCUITFindBy(id = "Drag me!")
    MobileElement dragMeButton;
    @AndroidFindBy(xpath = "//*[@text='Drop here.']")
    @iOSXCUITFindBy(id = "dropzone")
    MobileElement dropHere;
    @AndroidFindBy(accessibility = "success")
    @iOSXCUITFindBy(id = "success")
    MobileElement successMessage;

    public DragDropPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public DragDropPage openPage(){
        dragAndDrop.click();
        return this;
    }

    public DragDropPage dragDrop(){
        touchAction
                .longPress(ElementOption.element(dragMeButton))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(ElementOption.element(dropHere))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .release()
                .perform();
        return this;
    }

    public DragDropPage verifySuccessMessage(String message){
        assertEquals(successMessage.getText(), message);
        return this;
    }
}
