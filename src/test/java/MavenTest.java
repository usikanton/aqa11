import org.testng.annotations.Test;

public class MavenTest {

  @Test
  public void runTest() {
    System.out.println(System.getProperty("testProp"));
  }

}
