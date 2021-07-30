package moodpanda;

import static com.codeborne.selenide.Selenide.open;

import org.testng.annotations.Test;
import uimodel.moodpanda.HomePage;
import uimodel.moodpanda.LoginPage;

public class MoodPandaLoginTest extends BaseTest {

  public static final String EMAIL = "moustacheby@gmail.com";
  public static final String PASSWORD = "2@WC83EWxgF86R3";

  @Test
  public void loginTest() {
    open("Login");
    LoginPage loginPage = new LoginPage();
    loginPage.login(EMAIL, PASSWORD);
  }

  @Test
  public void updateMood() {
    open("Login");
    LoginPage loginPage = new LoginPage();
    HomePage homePage = loginPage.login(EMAIL,PASSWORD);
    homePage.updateMood(2);
  }


}
