package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public abstract class DriverManager {

    AppiumDriver<MobileElement> driver;
    DesiredCapabilities cap = new DesiredCapabilities();

    protected abstract AppiumDriver<MobileElement> createDriver(AppiumDriverLocalService service);

    public AppiumDriver<MobileElement> getDriver(AppiumDriverLocalService service) {
        if (null == driver) {
            //cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platform);
            //cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
            driver = createDriver(service);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }
        return driver;
    }
}
