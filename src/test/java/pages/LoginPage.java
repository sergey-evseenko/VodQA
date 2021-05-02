package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    @Override
    protected BasePage openPage(String title) {
        return null;
    }

    public void login(){
        driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.xpath("//*[@text='LOG IN']")).click();
    }
}
