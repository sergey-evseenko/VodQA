package test;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServer {
    public static AppiumDriverLocalService startServer() {
        final String url = "127.0.0.1";
        //final String appiumJsRunner = PropertyManager.getInstance().get("appium.server.js.path");
        //final String pathName = PropertyManager.getInstance().get("path.name");
        final int appiumServerPort = 4728;

        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(
                new AppiumServiceBuilder()
                        .withIPAddress(url)
                        .usingPort(appiumServerPort)
                        //.withAppiumJS(new File(appiumJsRunner))
                        //.usingDriverExecutable(new File(pathName))
                        .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                        .withArgument(GeneralServerFlag.LOG_LEVEL, "error"));
        service.start();
        return service;
    }
}
