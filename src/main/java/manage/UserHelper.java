package manage;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class UserHelper extends HelperBase {

    public UserHelper(WebDriver wd) {
        super(wd);
    }
    public void logOut() {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
        click(By.cssSelector("[data-test-id='header-member-menu-logout']"));
        click(By.cssSelector("#logout-submit"));
    }
    public boolean isLogged() {
        return wd.findElements(By.cssSelector("[data-test-id='header-member-menu-button']")).size() > 0;
    }
    public void initLogin() {
        click(By.cssSelector("[href='/login']"));
    }
    public void fillLoginForm(User user) {
        type(By.cssSelector("#user"), user.getEmail());
        click (By.cssSelector("#login"));
        pause(5000);
        type(By.cssSelector("#password"), user.getPassword());
    }
    public void fillLoginForm2(String email, String password) {
        type(By.cssSelector("#user"), email);
        click (By.cssSelector("#login"));
        pause(5000);
        type(By.cssSelector("#password"), password);
    }
    public void submitLogin() {
        click(By.cssSelector("#login-submit"));
    }

    public void login(String email, String password){
        click(By.cssSelector("[href='/login']"));
        type(By.cssSelector("#user"), email);
        click(By.cssSelector("#login"));
        pause(5000);
        type(By.cssSelector("#password"), password);
        click(By.cssSelector("#login-submit"));


    }

    public void clickOnAvatar() {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public void openUserProfile() {
        click(By.cssSelector("[data-test-id='header-member-menu-profile']"));
    }

    public void goToAtlassianAccount() {
        click(By.cssSelector("[href$='manage-profile']"));
        List<String> tabs = new ArrayList<>(wd.getWindowHandles());
      //  wd.switchTo().window((tabs.get(1)));
        wd.switchTo().window(tabs.get(tabs.size()-1));
    }

    public void returnToTrello() {
        List<String> tabs = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window((tabs.get(0)));

    }
}
