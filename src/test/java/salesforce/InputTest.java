package salesforce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InputTest {

  public static final String USERNAME = "";
  public static final String PASSWORD = "";
  private WebDriver driver;

  @BeforeMethod
  public void setUp() {
    System.setProperty("webdriver.chrome.driver",
        "C:\\Users\\Anton Usik\\Downloads\\chromedriver_win32\\chromedriver.exe");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--disable-notifications");
    driver = new ChromeDriver(options);
    driver.get("https://teachmeskills2.lightning.force.com/lightning/o/Account/new?count=1&nooverride=1&useRecordTypeCheck=1&navigationLocation=LIST_VIEW&uid=162619454048164551&backgroundContext=%2Flightning%2Fo%2FAccount%2Flist%3FfilterName%3DRecent");
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login(USERNAME, PASSWORD);
  }

  @Test
  public void createAccountTest() {
    AccountPage accountPage = new AccountPage(driver);
    accountPage.createAccount("Test Account", "+375221654848");
  }

  @AfterMethod
  public void tearDown() {
    driver.close();
    driver.quit();
  }
}