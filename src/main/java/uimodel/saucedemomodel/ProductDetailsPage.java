package uimodel.saucedemomodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailsPage {

  WebDriver driver;

  @FindBy(id = "add-to-cart-sauce-labs-backpack")
  private WebElement addToCartBtn;

  public ProductDetailsPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void setAddToCart() {
    Select select = new Select(addToCartBtn);
    
    addToCartBtn.click();
  }
}
