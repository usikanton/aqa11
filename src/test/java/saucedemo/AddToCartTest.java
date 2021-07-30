package saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import uimodel.saucedemomodel.LoginPage;

public class AddToCartTest {

  private static final String USERNAME = "standard_user";
  private static final String PASSWORD = "secret_sauce";
  WebDriver driver;
  LoginPage loginPage;

  @BeforeMethod
  public void setUp() {
    System.setProperty("webdriver.chrome.driver",
        "C:\\Users\\Anton Usik\\Downloads\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://www.saucedemo.com/");
    loginPage = new LoginPage(driver);
    Assert.assertTrue(loginPage.isPageOpened());
  }
  
  @Test(invocationCount = 2, threadPoolSize = 2)
  public void addToCartTest() {

    /*HomePage homePage = loginPage.loginSuccess(USERNAME, PASSWORD);
    Assert.assertTrue(homePage.isPageOpened(), "Page is not opened");
    ProductPage productPage = homePage.goToProductPage();
    productPage.addToCart();
    productPage.checkCartIndicator();
    Assert.assertTrue(loginPage.isPageOpened());*/

    //chain of invocations
    boolean cartIsNotEmpty = loginPage.loginSuccess(USERNAME, PASSWORD)
        .goToProductPage()
        .addToCart()
        .checkCartIndicator();
    Assert.assertTrue(cartIsNotEmpty, "Cart is empty");
  }

  @AfterMethod
  public void tearDown() {
    driver.close();
    driver.quit();
  }

}
