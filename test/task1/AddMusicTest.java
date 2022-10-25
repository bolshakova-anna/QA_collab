package task1;

import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.closeWebDriver;


public class AddMusicTest {

    private static String OKUsername = System.getProperty("OK.username", "technoPol27");
    private static String OKPassword = System.getProperty("OK.password", "technoPolis2022");
    private static String OKMusicRequest = System.getProperty("OK.musicRequest", "звери - для тебя");
    private static String OKMusicName = System.getProperty("OK.musicName", "Для тебя");


    @Test
    public void addMusicTest(){
        LoginPage loginpage = new LoginPage();
        loginpage.openInbox().login(OKUsername,OKPassword);
        FeedPage feedPage = new FeedPage();

        feedPage.searchMusic(OKMusicRequest);
        feedPage.addMusic();
        feedPage.openMyMusic();

        $(By.xpath("//a[contains(@data-payload, \"artistName=Звери\")]"))
                .shouldHave(text(OKMusicName))
                .shouldBe(visible);
    }

    @AfterClass
    public static void logout(){
        closeWebDriver();
    }
}
