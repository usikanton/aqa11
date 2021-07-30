package moodpanda;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

  @BeforeMethod
  public void setUp() {
    Configuration.browser = "chrome";
    Configuration.baseUrl = "https://moodpanda.com/";
  }

  @AfterMethod
  public void tearDown() {
    getWebDriver().close();
  }

}
