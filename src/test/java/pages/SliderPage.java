package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static io.appium.java_client.touch.offset.PointOption.point;

public class SliderPage extends BasePage{

    @AndroidFindBy(accessibility = "slider")
    MobileElement slider;


    public SliderPage(AppiumDriver driver) {
        super(driver);
    }

    @Override
    public SliderPage openPage(String title){
        clickMenu(title);
        return this;
    }

    public SliderPage isPageOpened(){
        wait.until(ExpectedConditions.visibilityOf(slider));
        return this;
    }

    public void moveSlider(){
        startX = slider.getLocation().getX();
        startY = slider.getLocation().getY();
        endX = startX + slider.getSize().getWidth();
        touchAction
                .press(point(startX,startY))
                .moveTo(point(endX, startY))
                .release()
                .perform();
    }
}
