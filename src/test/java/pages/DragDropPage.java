package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.offset.ElementOption;

import static org.testng.Assert.assertEquals;

public class DragDropPage extends BasePage{

    @AndroidFindBy(xpath = "//*[@content-desc='dragAndDrop']")
    @iOSXCUITFindBy(xpath = "//*[@name='dragAndDrop']")
    MobileElement dragAndDrop;
    @AndroidFindBy(accessibility = "dragMe")
    @iOSXCUITFindBy(accessibility = "Drag me!")
    MobileElement dragMeButton;
    @AndroidFindBy(xpath = "//*[@text='Drop here.']")
    @iOSXCUITFindBy(accessibility = "dropzone")
    MobileElement dropHere;
    @AndroidFindBy(accessibility = "success")
    @iOSXCUITFindBy(accessibility = "success")
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
                .moveTo(ElementOption.element(dropHere))
                .release()
                .perform();
        return this;
    }

    public DragDropPage verifySuccessMessage(String message){
        assertEquals(successMessage.getText(), message);
        return this;
    }
}
