package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import static io.appium.java_client.touch.offset.PointOption.point;

public class CarouselPage extends BasePage{

    @AndroidFindBy(xpath = "//*[@content-desc='carousel']")
    @iOSXCUITFindBy(xpath = "//*[@name='carousel']")
    MobileElement carousel;
    @AndroidFindBy(xpath = "//*[@text='1']")
    MobileElement element1;
    @AndroidFindBy(xpath = "//*[@text='2']")
    MobileElement element2;

    public CarouselPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public CarouselPage openPage(){
        startY = driver.manage().window().getSize().getHeight()/2;
        touchAction
                .longPress(point(0, startY))
                .moveTo(point(0, 0))
                .release()
                .perform();
        waitForElementToAppear(carousel);
        carousel.click();
        return this;
    }

    public CarouselPage scrollRight(){
        waitForElementToAppear(element1);
        startX = driver.manage().window().getSize().getWidth()*99/100;
        startY = driver.manage().window().getSize().getHeight()/2;
        touchAction
                .longPress(point(startX, startY))
                .moveTo(point(0, startY))
                .release()
                .perform();
        return this;
    }

    public CarouselPage scrollLeft(){
        waitForElementToAppear(element2);
        touchAction
                .longPress(point(100, startY))
                .moveTo(point(startX, startY))
                .release()
                .perform();
        waitForElementToAppear(element1);
        return this;
    }
}
