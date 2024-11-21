import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class LinkedinTest {
    private static IOSDriver<IOSElement> driver;
    @BeforeClass
    public static void setup() {
        driver = Driver.getDriver();
        System.out.println("Test başlatılıyor...");
    }

    @Test(priority = 1,description = "LinkedIn Ana Sayfa Testi")
    public void anaSayfaTesti() {
        WebElement anaSayfaButon = driver.findElement(MobileBy.AccessibilityId("12000"));
        anaSayfaButon.click();
        Assert.assertTrue(anaSayfaButon.isDisplayed(),"Ana sayfa butonu görünür değil");
    }

    @Test(dependsOnMethods = {"anaSayfaTesti"},description = "LinkedIn Ağ Sayfasi Testi"  )
    public void agTesti() {
        WebElement agButon = driver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeImage[`name == \"system-icons_people_medium_24x24\"`]"));
        agButon.click();
        Assert.assertTrue(agButon.isEnabled(),"Giriş butonu aktif değil");
    }

    @Test(dependsOnMethods = {"agTesti"}, description = "LinkedIn İş İlanları Testi")
    public void isIlanlariTesti() {
        WebElement isIlanlariButon = driver.findElement(MobileBy.iOSNsPredicateString("name == \"system-icons_job_medium_24x24\""));
        Assert.assertTrue(isIlanlariButon.isDisplayed(),"İş ilanları butonu görünür değil");
        isIlanlariButon.click();

    }
    @Test(dependsOnMethods = {"isIlanlariTesti"}, description = "LinkedIn Bildirimler Testi")
    public void bildirimTesti() {
        WebElement bildirimButon = driver.findElement(MobileBy.AccessibilityId("5500"));
        Assert.assertTrue(bildirimButon.isDisplayed(),"Bildirimler butonu görünür değil");
        bildirimButon.click();

    }

    @Test(dependsOnMethods = {"bildirimTesti"}, description = "LinkedIn Arama Testi")
    public void aramaTesti() throws InterruptedException {

        WebElement aramaAlani = driver.findElement(MobileBy.AccessibilityId("5501_placeholder"));
        Assert.assertTrue(aramaAlani.isDisplayed(), "Arama alanı görünür değil");
        aramaAlani.click();

        Thread.sleep(2000);

        WebElement aramaAlaniText = driver.findElement(MobileBy.AccessibilityId("5418"));
        aramaAlaniText.sendKeys("Appium", Keys.ENTER);


        System.out.println("✓ Arama testi başarılı");






    }



    @AfterClass
    public static void tearDown() {
        Driver.closeDriver();
        System.out.println("Test bitti...");
    }

}
