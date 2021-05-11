package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPage extends BasePage{

    @AndroidFindBy(id = "com.android.permissioncontroller:id/continue_button")
    MobileElement continueButton;
    @AndroidFindBy(id = "android:id/button1")
    MobileElement okButton;
    @AndroidFindBy(xpath = "//*[@text='LOG IN']")
    @iOSXCUITFindBy(xpath = "//*[@name='login']")
    MobileElement loginButton;
    @AndroidFindBy(xpath = "//*[@content-desc='scrollView']")
    @iOSXCUITFindBy(xpath = "//*[@name='scrollView']")
    MobileElement scrollView;

    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    protected BasePage openPage() {
        return null;
    }

    public void login(String platform){
        if (platform.equals("android")){
            continueButton.click();
            okButton.click();
        }
        loginButton.click();
        waitForElementToAppear(scrollView);
    }
}
