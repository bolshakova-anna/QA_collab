package task1;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class AddMusicTest {
    private static String OKUsername = System.getProperty("OK.username", "technoPol27");
    private static String OKPassword = System.getProperty("OK.password", "technoPolis2022");
    private static String OKMusicName = System.getProperty("OK.musicName", "звери - для тебя");

    @Test
    public void addMusicTest(){
        LoginPage loginpage = new LoginPage();
        loginpage.openInbox().login(OKUsername,OKPassword);
        FeedPage feedPage = new FeedPage();

        feedPage.searchMusic(OKMusicName);
        feedPage.addMusic();

        $(By.xpath(""))
                .shouldHave(text(OKMusicName))
                .shouldBe(visible);
    }

}
