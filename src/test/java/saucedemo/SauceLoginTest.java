package saucedemo;

import utils.dataproviders.LoginDataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import uimodel.saucedemomodel.HomePage;
import uimodel.saucedemomodel.LoginPage;
import uimodel.saucedemomodel.Retry;

public class SauceLoginTest {

  private static final String USERNAME = "standard_user";
  private static final String PASSWORD = "secret_sauce";
  WebDriver driver;
  LoginPage loginPage;

  @BeforeMethod
  public void setUp() {
    if (System.getProperty("browser").equalsIgnoreCase("firefox")) {
      System.setProperty("webdriver.gecko.driver",
          "C:\\Users\\Anton Usik\\Downloads\\geckodriver-v0.29.1-win64\\geckodriver.exe");
      driver = new FirefoxDriver();
    } else {
      System.setProperty("webdriver.chrome.driver",
          "C:\\Users\\Anton Usik\\Downloads\\chromedriver_win32\\chromedriver.exe");
      driver = new ChromeDriver();
    }
    driver.get("https://www.saucedemo.com/");
    loginPage = new LoginPage(driver);
  }

  @Test(dataProvider = "bla", dataProviderClass = LoginDataProvider.class, retryAnalyzer = Retry.class)
  public void loginParametrized(String username, String password) {
    HomePage homePage = loginPage.loginSuccess(username, password);
    WebElement cart = driver.findElement(homePage.getCartElement());
    Assert.assertTrue(cart.isDisplayed(), "You are not logged in");
  }

  @Parameters({"username", "password"})
  @Test
  public void login(@Optional("bla") String username, @Optional("bla-bla") String password) {
    HomePage homePage = loginPage.loginSuccess(username, password);
    WebElement cart = driver.findElement(homePage.getCartElement());
    Assert.assertTrue(cart.isDisplayed(), "You are not logged in");
  }

  @Ignore
  @Test
  public void loginNegative() {
    WebElement error = loginPage.invalidLogin(USERNAME, "");
    Assert.assertTrue(error.isDisplayed(), "You are logged in");
  }

  @AfterMethod
  public void tearDown() {
    driver.close();
    driver.quit();
  }

}
