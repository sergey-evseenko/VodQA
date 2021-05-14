package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;

import java.util.Set;

public class WebViewPage extends BasePage{

    @AndroidFindBy(accessibility = "webView")
    @iOSXCUITFindBy(xpath = "//*[@name='webView']")
    MobileElement webView;
    @AndroidFindBy(xpath = "//*[@text='login']")
    MobileElement loginButton;

    public WebViewPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public WebViewPage openPage(){
        webView.click();
        return this;
    }

    public WebViewPage clickLogin(){
        loginButton.click();
        return this;
    }

    public void provideLoginPass(){
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }
        driver.context((String) contextNames.toArray()[1]); // set context to WEBVIEW_1
        //do some web testing
        driver.findElement(By.xpath("(//input[@name=\"acct\"])[1]")).sendKeys("sergey.evseenko@gmail.com");
        driver.findElement(By.xpath("(//input[@name=\"pw\"])[1]")).sendKeys("Testpass1");
        driver.context("NATIVE_APP");
    }
}
