package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;

import java.util.List;

import static io.appium.java_client.touch.offset.PointOption.point;

public class VerticalSwipingPage extends BasePage{

    @AndroidFindBy(accessibility = "verticalSwipe")
    @iOSXCUITFindBy(xpath = "//*[@name='verticalSwipe']")
    MobileElement verticalSwipe;
    @AndroidFindBy(accessibility = "listview")
    @iOSXCUITFindBy(xpath = "//*[@name='listview']")
    MobileElement listview;
    @AndroidFindBy(xpath = "//*[@class='android.view.ViewGroup']")
    List<MobileElement> textBoxes;

    public VerticalSwipingPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public VerticalSwipingPage openPage(){
        verticalSwipe.click();
        return this;
    }
    public VerticalSwipingPage swipeDown(){
        waitForElementToAppear(listview);
        startY = driver.manage().window().getSize().getHeight()*99/100;

        touchAction
                .longPress(point(0, startY))
                .moveTo(point(0, 0))
                .release()
                .perform();

        return this;
    }

    public VerticalSwipingPage getTextBoxes(){
        //List<MobileElement> textBoxes = driver.findElements(By.xpath("//*[@class='android.view.ViewGroup']"));
        System.out.println(textBoxes.get(5).findElement(By.xpath("//*[@class='android.widget.TextView']")).getText());
        System.out.println(textBoxes.get(6).findElement(By.xpath("//*[@class='android.widget.TextView']")).getText());
        System.out.println(textBoxes.get(7).findElement(By.xpath("//*[@class='android.widget.TextView']")).getText());
        System.out.println(textBoxes.get(8).findElement(By.xpath("//*[@class='android.widget.TextView']")).getText());
        System.out.println(textBoxes.get(9).findElement(By.xpath("//*[@class='android.widget.TextView']")).getText());
        System.out.println(textBoxes.get(10).findElement(By.xpath("//*[@class='android.widget.TextView']")).getText());
        return this;
    }
}
