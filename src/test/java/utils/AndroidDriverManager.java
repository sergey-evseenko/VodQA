package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.util.concurrent.TimeUnit;

public class AndroidDriverManager extends DriverManager{
    @Override
    protected AppiumDriver<MobileElement> createDriver(AppiumDriverLocalService service) {
        //cap.setCapability("deviceName", "Pixel_3a_API_30");
        cap.setCapability("avd", "Pixel_3a_API_30");
        cap.setCapability("platformName", "Android");
        cap.setCapability("appPackage", "com.vodqareactnative");
        cap.setCapability("appActivity", "com.vodqareactnative.MainActivity");

        driver = new AndroidDriver<>(service, cap);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }
}
