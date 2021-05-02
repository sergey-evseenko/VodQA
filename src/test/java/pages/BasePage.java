package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract public class BasePage {
    protected AppiumDriver driver;
    protected WebDriverWait wait;
    protected TouchAction touchAction;
    protected int startX, startY, endX;

    protected BasePage(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        touchAction = new TouchAction(this.driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    protected abstract BasePage openPage(String title);

    protected void clickMenu(String title){
        String locator = "//*[@text='%s']";
        driver.findElement(By.xpath(String.format(locator, title))).click();
    }
}
