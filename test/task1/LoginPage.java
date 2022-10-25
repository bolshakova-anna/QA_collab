package task1;

import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.Rule;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.addListener;


public class LoginPage {

  @Rule
  public ScreenShooter screenShooter = ScreenShooter.failedTests();

  private static String loginFieldXPath = "//*[@id='field_email']";
  private static String passwordFieldXPath = "//*[@id='field_password']";

  public LoginPage openInbox() {
    timeout = 10000;
    baseUrl = "https://ok.ru/";
    startMaximized = false;
    browser = "chrome";
    browserPosition = "890x10";
    browserSize = "780x950";
    addListener(new Highlighter());
    open("/");
    return this;
  }


  public static void login(String OKUsername,String OKPassword) {
    $(By.xpath(loginFieldXPath)).val(OKUsername);
    $(By.xpath(passwordFieldXPath)).val(OKPassword).pressEnter();
  }
}
