package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import static io.appium.java_client.touch.offset.PointOption.point;

public class SliderPage extends BasePage{

    @AndroidFindBy(xpath = "//*[@content-desc='Slider']")
    @iOSXCUITFindBy(xpath = "//*[@name='slider1']")
    MobileElement sliderMenu;
    @AndroidFindBy(accessibility = "slider")
    @iOSXCUITFindBy(xpath = "//*[@name='slider']")
    MobileElement slider;


    public SliderPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public SliderPage openPage(){
        sliderMenu.click();
        return this;
    }

    public void moveSlider(){
        waitForElementToAppear(slider);
        startX = slider.getLocation().getX();
        startY = slider.getLocation().getY();
        endX = startX + slider.getSize().getWidth();
        touchAction
                .longPress(point(startX,startY))
                .moveTo(point(endX, startY))
                .release()
                .perform();
        System.out.println();
    }
}
