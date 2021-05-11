package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class MenuPage extends BasePage{

    @AndroidFindBy(xpath = "//*[@text='Back']")
    @iOSXCUITFindBy(xpath = "//*[@name='Back']")
    MobileElement backButton;

    public MenuPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    protected BasePage openPage() {
        return null;
    }

    public void clickBack(){
        backButton.click();
    }
}
