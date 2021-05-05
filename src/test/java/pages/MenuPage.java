package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class MenuPage extends BasePage{

    @AndroidFindBy(xpath = "//*[@text='Back']")
    MobileElement backButton;

    public MenuPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    protected BasePage openPage(String title) {
        return null;
    }

    public void clickBack(){
        backButton.click();
    }
}
