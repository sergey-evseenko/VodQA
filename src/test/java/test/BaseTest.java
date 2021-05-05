package test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.*;
import utils.AndroidDriverManager;
import utils.DriverManager;
import utils.IOSDriverManager;

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
    DriverManager driverManager;

    private AppiumDriver<MobileElement> driver;

    @BeforeClass
    @Parameters("platform")
    public void setDriver(@Optional("android") String platform){
        //run test.AppiumServer
        service = AppiumServer.startServer();
        //set up Appium Driver
        if (platform.equals("android")){
            driverManager = new AndroidDriverManager();
        }else {
            driverManager = new IOSDriverManager();
        }

        driver = driverManager.getDriver(service);

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
