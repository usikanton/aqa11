import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddAndRemoveElementsTest {

  @Test
  public void addAndRemoveElementTest() {

    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anton Usik\\Downloads\\chromedriver_win32\\chromedriver.exe");
    ChromeDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("http://the-internet.herokuapp.com/hovers");

    Actions action = new Actions(driver);
    List<WebElement> elements = driver.findElements(By.xpath("//div[@class='figure']"));
    action.moveToElement(elements.get(0))
        .build()
        .perform();
    System.out.println(driver.findElement(By.xpath("//h5[contains(text(),'user1')]")).getText());
    Assert.assertNotNull(driver.findElement(By.xpath("//h5[contains(text(),'user1')]")).getText());
    driver.findElement(By.xpath("//a[@href='/users/1']")).click();
    Assert.assertFalse(driver.findElement(By.xpath("//h1")).isDisplayed(), "");
  }

}
