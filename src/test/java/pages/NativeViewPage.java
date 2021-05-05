package pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class NativeViewPage extends BasePage{

    @AndroidFindBy(xpath = "(//*[@content-desc='textView'])")
    List<MobileElement> textBoxes;

    public NativeViewPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public NativeViewPage openPage(String title){
        clickMenu(title);
        return this;
    }

    public void checkContent(){
        assertEquals(textBoxes.get(0).getText(), "Hello World, I'm View one ");
        assertEquals(textBoxes.get(1).getText(), "Hello World, I'm View two ");
        assertEquals(textBoxes.get(2).getText(), "Hello World, I'm View three ");
    }
}
