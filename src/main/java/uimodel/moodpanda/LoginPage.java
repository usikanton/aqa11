package uimodel.moodpanda;

import static com.codeborne.selenide.Selenide.$;


public class LoginPage {

  private static final String EMAIL_INPUT = "#ContentPlaceHolderContent_TextBoxEmail";
  private static final String PASSWORD_INPUT = "#ContentPlaceHolderContent_TextBoxPassword";
  private static final String LOGIN_BUTTON = "#ContentPlaceHolderContent_ButtonLogin";

  public HomePage login(String email, String password) {
    $(EMAIL_INPUT).sendKeys(email);
    $(PASSWORD_INPUT).sendKeys(password);
    $(LOGIN_BUTTON).click();
    return new HomePage();
  }

}