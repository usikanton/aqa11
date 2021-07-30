package HerokuApp;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HerokuTests {

  public static final String TEXT_MESSAGE = "It's gone!";
  WebDriver driver;
  private static final String ALERT_TEXT = "You selected a context menu";

  @BeforeMethod
  public void setUp() {
    System.setProperty("webdriver.chrome.driver",
        "C:\\Users\\Anton Usik\\Downloads\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }

  @Test
  public void getAlertTextTest() {
    driver.get("http://the-internet.herokuapp.com/context_menu");
    Actions actions = new Actions(driver);
    actions.moveToElement(driver.findElement(By.id("hot-spot"))).contextClick().build().perform();
    String alertText = driver.switchTo().alert().getText();
    driver.switchTo().alert().accept();
    Assert.assertTrue(driver.findElement(By.id("content")).isDisplayed(), "Alert is still opened");
    Assert.assertEquals(alertText, ALERT_TEXT, "Texts are not equals");
  }

  //TODO: add comments to steps

  @Test
  public void checkDynamicControls() {
    driver.get("http://the-internet.herokuapp.com/dynamic_controls");
    WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
    Assert.assertTrue(checkbox.isDisplayed(),
        "No checkboxes here");
    driver.findElement(By.cssSelector("button[onclick='swapCheckbox()']")).click();
    /*WebDriverWait waiter = new WebDriverWait(driver, 10);
    waiter.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("message"))));*/
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    String removeConfirm = driver.findElement(By.id("message")).getText();
    Assert.assertEquals(removeConfirm, TEXT_MESSAGE,
        "Texts are different");
    HashSet<String> stringHashSet = new HashSet<>();
    Assert.assertEquals(null, checkbox, "Checkbox is still present");
  }

  @AfterMethod
  public void tearDown() {
    driver.close();
    driver.quit();
  }

}
