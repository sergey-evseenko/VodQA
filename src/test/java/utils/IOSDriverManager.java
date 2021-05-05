package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.util.concurrent.TimeUnit;

public class IOSDriverManager extends DriverManager{
    @Override
    protected AppiumDriver<MobileElement> createDriver(AppiumDriverLocalService service) {
        cap.setCapability("deviceName", "iPhone 12 Pro Max");
        cap.setCapability("platformName", "iOS");
        cap.setCapability("app",System.getProperty("user.dir") + "/src/test/resources/VodQAReactNative.zip");
        cap.setCapability("automationName", "XCUITest");


        driver = new IOSDriver<>(service, cap);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }
}
