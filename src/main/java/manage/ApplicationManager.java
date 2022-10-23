package manage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    WebDriver wd;

    UserHelper user;
    BoardHelper board;
    CardHelper card;
    ListHelper list;
    AtlassianHelper atlassian;

    public void init(){
        WebDriverListener listener= new MyListener();
        wd = new ChromeDriver();
        logger.info("Test starts---");
        wd = new EventFiringDecorator<>(listener).decorate(wd);
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wd.navigate().to("https://trello.com/");

        user=new UserHelper(wd);
        board=new BoardHelper(wd);
        list = new ListHelper(wd);
        card= new CardHelper(wd);
        atlassian = new AtlassianHelper(wd);

        user.login("juliakliot.jk@gmail.com","misha240613");

    }

    public void quit(){
        wd.close();
        wd.quit();
    }

    public UserHelper getUser() {
        return user;
    }

    public BoardHelper getBoard() {
        return board;
    }

    public CardHelper getCard() {
        return card;
    }

    public ListHelper getList() {
        return list;
    }

    public AtlassianHelper getAtlassian() {
        return atlassian;
    }

    public String getUrl(){
        return wd.getCurrentUrl();
    }
}
