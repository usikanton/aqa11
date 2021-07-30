package salesforce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

  //https://teachmeskills2.lightning.force.com/lightning/o/Account/new?count=1&nooverride=1&useRecordTypeCheck=1&navigationLocation=LIST_VIEW&uid=162619454048164551&backgroundContext=%2Flightning%2Fo%2FAccount%2Flist%3FfilterName%3DRecent
  private WebDriver driver;

  @FindBy(xpath = "//button[@title='Save']")
  private WebElement saveBtn;

  public AccountPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void createAccount(String accountName, String phone) {
    new Input(driver, "Account Name").write(accountName);
    new Input(driver, "Phone").write(phone);

    //......
    // ....
    //.....
    // .....
    // можно добавить и остальные инпуты при желании
    saveBtn.click();
  }
}