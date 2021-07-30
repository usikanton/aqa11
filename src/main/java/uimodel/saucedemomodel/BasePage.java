package uimodel.saucedemomodel;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

  WebDriver driver;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  public abstract boolean isPageOpened();
}