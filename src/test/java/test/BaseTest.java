package test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    DesiredCapabilities caps;
    AppiumDriverLocalService service;
    LoginPage loginPage;
    MenuPage menuPage;
    NativeViewPage nativeViewPage;
    SliderPage sliderPage;
    VerticalSwipingPage verticalSwipingPage;
    DragDropPage dragDropPage;
    DoubleTabPage doubleTabPage;
    LongPressPage longPressPage;
    CarouselPage carouselPage;
    WheelPickerPage wheelPickerPage;
    WebViewPage webViewPage;

    private AppiumDriver driver;

    @BeforeClass
    public void setDriver(){
        //set up capabilities
        caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel_3a_API_30");
        caps.setCapability("avd", "Pixel_3a_API_30");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.vodqareactnative");
        caps.setCapability("appActivity", "com.vodqareactnative.MainActivity");
        //run test.AppiumServer
        service = AppiumServer.startServer();
        //set up Appium Driver
        driver = new AppiumDriver(service, caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        menuPage = new MenuPage(driver);
        sliderPage = new SliderPage(driver);
        nativeViewPage = new NativeViewPage(driver);
        verticalSwipingPage = new VerticalSwipingPage(driver);
        dragDropPage = new DragDropPage(driver);
        doubleTabPage = new DoubleTabPage(driver);
        longPressPage = new LongPressPage(driver);
        carouselPage = new CarouselPage(driver);
        wheelPickerPage = new WheelPickerPage(driver);
        webViewPage = new WebViewPage(driver);
    }

    @AfterClass
    public void closeApp(){
        driver.closeApp();
        service.stop();
    }
}
