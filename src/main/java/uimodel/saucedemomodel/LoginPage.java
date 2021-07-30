package uimodel.saucedemomodel;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

  WebDriver driver;

  private By USERNAME_INPUT = By.id("user-name");
  private By PASSWORD_INPUT = By.id("password");
  private By LOGIN_BTN = By.id("login-button");
  private By ERROR_MSG = By.xpath("//h3[@data-test]");


  @FindBy(id = "user-name")
  private WebElement usernameInput;
  @FindBy(id = "password")
  private WebElement passwordInput;
  @FindBy(id = "login-button")
  private WebElement loginBtn;
  @FindBy(xpath = "//h3[@data-test]")
  private WebElement errorMsg;

  public LoginPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @Override
  public boolean isPageOpened() {
    return loginBtn.isDisplayed();
  }

  public void login(String username, String password) {
    /*driver.findElement(USERNAME_INPUT).click();
    driver.findElement(USERNAME_INPUT).sendKeys(username);
    driver.findElement(PASSWORD_INPUT).click();
    driver.findElement(PASSWORD_INPUT).sendKeys(password);
    driver.findElement(LOGIN_BTN).click();*/
    usernameInput.click();
    usernameInput.sendKeys(username);
    passwordInput.click();
    passwordInput.sendKeys(password);
    loginBtn.click();
  }

  public HomePage loginSuccess(String username, String password) {
    this.login(username, password);
    return new HomePage(driver);
  }

  public WebElement invalidLogin(String username, String password) {
    this.login(username, password);
    return errorMsg;
  }

  public void isTextDisplayed() {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(ERROR_MSG)));
    FluentWait<WebDriver> flWait = new FluentWait<>(driver).withTimeout(10, TimeUnit.SECONDS)
        .pollingEvery(Duration.of(5, (TemporalUnit) TimeUnit.SECONDS))
        .withMessage("Still not found").ignoring(
            NoSuchElementException.class);
  }
}