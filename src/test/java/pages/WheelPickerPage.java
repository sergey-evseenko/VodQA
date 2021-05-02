package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static io.appium.java_client.touch.offset.PointOption.point;
import static org.testng.Assert.assertEquals;

public class WheelPickerPage extends BasePage{

    @AndroidFindBy(xpath = "//*[@text='Long Press']")
    MobileElement longPress;
    @AndroidFindBy(xpath = "//*[@class='android.widget.Spinner']")
    MobileElement spinner;

    public WheelPickerPage(AppiumDriver driver) {
        super(driver);
    }

    @Override
    public WheelPickerPage openPage(String title){
        wait.until(ExpectedConditions.visibilityOf(longPress));
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
        wait.until(ExpectedConditions.visibilityOf(spinner));
        return this;
    }

    public WheelPickerPage verifySelectedColor(String color){
        String message = " Current Color: %s ";
        List<MobileElement> textViews = driver.findElements(By.xpath("//*[@class='android.widget.TextView']"));
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
