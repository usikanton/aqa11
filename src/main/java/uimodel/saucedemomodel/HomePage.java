package uimodel.saucedemomodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

  WebDriver driver;
  private By CART_ELEMENT = By.id("shopping_cart_container");
  private By PRODUCT_4 = By.id("item_4_title_link");
  private By PRODUCTS_LIST = By.xpath("//div[@class='inventory_item']");

  public HomePage(WebDriver driver) {
    super(driver);
  }

  @Override
  public boolean isPageOpened() {
    return driver.findElements(PRODUCTS_LIST).size() == 6;
  }

  public By getCartElement() {
    return CART_ELEMENT;
  }

  public ProductPage goToProductPage() {
    driver.findElement(PRODUCT_4).click();
    return new ProductPage(driver);
  }
}
