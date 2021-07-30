package uimodel.saucedemomodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

  WebDriver driver;

  @FindBy(id = "add-to-cart-sauce-labs-backpack")
  private WebElement addToCartBtn;
  @FindBy(xpath = "//a/span")
  private WebElement cartIndicator;

  public ProductPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public ProductPage addToCart() {
    addToCartBtn.click();
    return new ProductPage(driver);
  }

  public boolean checkCartIndicator() {
    return cartIndicator.getText() != null;
  }
}
