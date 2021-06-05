import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddAndRemoveElementsTest {

  @Test
  public void addAndRemoveElementTest() {

    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anton Usik\\Downloads\\chromedriver_win32\\chromedriver.exe");
    ChromeDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("http://the-internet.herokuapp.com/inputs");
    WebElement addElementBtn = driver.findElement(By.xpath("//input[@type]"));
    addElementBtn.click();
    addElementBtn.sendKeys("1351");
    System.out.println(addElementBtn.getCssValue("input"));
    
  }

}
