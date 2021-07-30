package utils.dataproviders;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

  @DataProvider(name = "bla")
  public Object[][] loginCredentials() {
    return new Object[][]{{"standard_user", "secret_sauce"}, {"standard_user", ""}};
  }
}