package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static io.appium.java_client.touch.offset.PointOption.point;

public class SliderPage extends BasePage{

    @AndroidFindBy(accessibility = "slider")
    MobileElement slider;


    public SliderPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public SliderPage openPage(String title){
        clickMenu(title);
        return this;
    }

    public SliderPage isPageOpened(){
        waitForElementToAppear(slider);
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
