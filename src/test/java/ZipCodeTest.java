import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ZipCodeTest {

  @Test
  public void enterValidZipCode() {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anton Usik\\Downloads\\chromedriver_win32\\chromedriver.exe");
    ChromeDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://www.sharelane.com/cgi-bin/register.py");
    driver.findElementByName("zip_code").click();
    driver.findElement(By.name("zip_code")).clear();
    driver.findElementByName("zip_code").sendKeys("15354");
    driver.findElementByXPath("//input[@value='Continue']").click();
    Assert.assertTrue(driver.findElementByName("password2686t87t").isDisplayed());
  }
}
