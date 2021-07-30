package salesforce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

  private WebDriver driver;

  @FindBy(id = "username")
  private WebElement usernameInput;
  @FindBy(id = "password")
  private WebElement passwordInput;
  @FindBy(id = "Login")
  private WebElement loginBtn;

  public LoginPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void login(String username, String password) {
    usernameInput.sendKeys(username);
    passwordInput.sendKeys(password);
    loginBtn.click();
  }
}
