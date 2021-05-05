package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.ElementOption;

import static org.testng.Assert.assertEquals;

public class DragDropPage extends BasePage{

    @AndroidFindBy(accessibility = "dragMe")
    MobileElement dragMeButton;
    @AndroidFindBy(xpath = "//*[@text='Drop here.']")
    MobileElement dropHere;
    @AndroidFindBy(accessibility = "success")
    MobileElement successMessage;

    public DragDropPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public DragDropPage openPage(String title){
        clickMenu(title);
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
