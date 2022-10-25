package task1;

import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.Rule;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class FeedPage {

    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests();

    private static String musicToolbarButtonXPath = "//*[@id=\"music_toolbar_button\"]";
    private static String musicSearchFieldXpath1 = "//*[@placeholder=\"Поиск\" and @data-l=\"t,input\"]";
    private static String musicSearchFieldXpath2 = "//*[@id=\"music_layer\"]/header/div/wm-search-form/wm-search-input/input";
    private static String musicListElementXPath = "//a[contains(@data-payload, \"artistName=Звери\")]/../..";
    private static String addMusicButtonXPath = "//*[@title=\"В мою музыку\"]";
    private static String myMusicButtonXPath = "//div[text()=\"Моя музыка\"]";


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
        $(By.xpath(musicToolbarButtonXPath)).click();
        //ввод названия трека - поиск

        $(By.xpath((musicSearchFieldXpath1))).click();
        // по какой-то причине здесь не работает первый вариант XPath'а :\
        $(By.xpath((musicSearchFieldXpath2))).val(name).pressEnter();

    }


        public static void addMusic(){
        $(By.xpath(musicListElementXPath)).click();

        $(By.xpath(addMusicButtonXPath)).click();

    }

    public static void openMyMusic(){
        $(By.xpath(myMusicButtonXPath)).click();
    }

}
