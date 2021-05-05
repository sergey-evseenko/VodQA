package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePage{

    @AndroidFindBy(id = "com.android.permissioncontroller:id/continue_button")
    MobileElement continueButton;
    @AndroidFindBy(id = "android:id/button1")
    MobileElement okButton;
    @AndroidFindBy(xpath = "//*[@text='LOG IN']")
    MobileElement loginButton;

    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    protected BasePage openPage(String title) {
        return null;
    }

    public void login(){
        continueButton.click();
        okButton.click();
        loginButton.click();
    }
}
