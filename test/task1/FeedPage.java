package task1;

import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.Rule;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class FeedPage {

    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests();

    /*
    public UserPage openInbox() {
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
    */

    public static void searchMusic(String name){
        //тык на музыку
        $(By.xpath("//*[@id=\'music_toolbar_button\']")).click();
        //ввод названия трека - поиск
        $(By.xpath(("//*[@placeholder=\"Поиск\" and @data-l=\"t,input\"]"))).click();
        $(By.xpath(("//*[@id=\"music_layer\"]/header/div/wm-search-form/wm-search-input/input"))).val(name).pressEnter();
    }

    public static void addMusic(){
        $(By.xpath("//*[@id=\"music_layer\"]/main/div/div[2]/div/search-page/wm-portlet/slot/wm-tracks-list/main/wm-track[1]")).hover();
        $(By.xpath("//*[@title=\"В мою музыку\"]")).click();
    }

    public static void openMyMusic(){
        $(By.xpath("//div[text()='Моя музыка']")).click();
    }

}
