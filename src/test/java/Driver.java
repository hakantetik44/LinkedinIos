import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class Driver {
    private static IOSDriver<IOSElement> driver;

    private Driver() {}

    public static IOSDriver<IOSElement> getDriver() {
        if (driver == null) {
            try {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("appium:platformName", "iOS");
                caps.setCapability("appium:automationName", "XCUITest");
                caps.setCapability("appium:platformVersion", "18.1.1");
                caps.setCapability("appium:deviceName", "İphone 12 pro max");
                caps.setCapability("appium:udid", "00008101-000A3DA60CD1003A");
                caps.setCapability("appium:bundleId", "com.linkedin.LinkedIn");
                caps.setCapability("appium:useNewWDA", false);
                caps.setCapability("appium:usePrebuiltWDA", false);
                caps.setCapability("appium:preventWDAAttachments", true);
                caps.setCapability("appium:simpleIsVisibleCheck", false);
                caps.setCapability("appium:showIOSLog", true);
                caps.setCapability("appium:showXcodeLog", true);

                driver = new IOSDriver<>(new URL("http://127.0.0.1:4723"), caps);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}