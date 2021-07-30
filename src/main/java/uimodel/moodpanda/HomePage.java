package uimodel.moodpanda;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class HomePage {

  private static final String UPD_MOOD_BTN = "#LinkUpdate";
  private static final String MOOD_SLIDER = "//a[contains(@class,'ui-slider')]";
  private static final String CONFIRM_UPDATE_BTN = "//button[contains(@class,'ButtonUpdate')]";

  public void updateMood(int moodPoints) {
    $(UPD_MOOD_BTN).click();
    $(By.xpath(MOOD_SLIDER)).click();
    //$(By.xpath(MOOD_SLIDER)).sendKeys(Keys.ARROW_RIGHT);
    generateMoodValue(moodPoints);
    $(By.xpath(CONFIRM_UPDATE_BTN)).click();
  }

  //TODO Добавить алгоритм подсчета, насколько поменять настроение в зависимости от того параметра, который мы передаем в метод (moodPoints)
  private void generateMoodValue(int moodPoints) {
    //ALGORYTHM
    int moodDefault =   getMoodValue();
    Keys direction = Keys.LEFT;
    int steps = Math.abs(moodPoints - moodDefault);
    if (moodPoints > moodDefault) {
      direction = Keys.RIGHT;
    }
    for (int i = 0; i < steps; i++) {
      $(By.xpath(MOOD_SLIDER)).sendKeys(direction);
    }
  }

  private int getMoodValue() {
    return Integer.valueOf($(By.xpath(CONFIRM_UPDATE_BTN)).getText().split(" ")[3]);
  }
}
