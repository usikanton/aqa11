package salesforce;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input {

  private WebDriver driver;
  private String label;
  private String xpath = "//*[contains(@class,'modal-body')]//span[text()='%s']/ancestor::div[contains(@class,'uiInput')]//input";

  public Input(WebDriver driver, String label) {
    this.driver = driver;
    this.label = label;
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  public void write(String value) {
    driver.findElement(By.xpath(String.format(xpath, label))).sendKeys(value);
  }
}
