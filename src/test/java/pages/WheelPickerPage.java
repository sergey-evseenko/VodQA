package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import java.util.List;

import static io.appium.java_client.touch.offset.PointOption.point;
import static org.testng.Assert.assertEquals;

public class WheelPickerPage extends BasePage{

    @AndroidFindBy(xpath = "//*[@text='Long Press']")
    MobileElement longPress;
    @AndroidFindBy(xpath = "//*[@class='android.widget.Spinner']")
    MobileElement spinner;
    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView']")
    List<MobileElement> textViews;

    public WheelPickerPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public WheelPickerPage openPage(String title){
        waitForElementToAppear(longPress);
        startY = driver.manage().window().getSize().getHeight()*99/100;
        touchAction
                .longPress(point(0, startY))
                .moveTo(point(0, 0))
                .release()
                .perform();
        clickMenu(title);
        return this;
    }

    public WheelPickerPage isPageOpened(){
        waitForElementToAppear(spinner);
        return this;
    }

    public WheelPickerPage verifySelectedColor(String color){
        String message = " Current Color: %s ";
        assertEquals(textViews.get(0).getText(), String.format(message, color), "Invalid message");
        return this;
    }

    public WheelPickerPage selectColor(String color){
        String locator = "//*[@text='%s']";
        driver.findElement(By.cssSelector(".android.widget.Spinner")).click();
        driver.findElement(By.xpath(String.format(locator, color))).click();
        return this;
    }
}
