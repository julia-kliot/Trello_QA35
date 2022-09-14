package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Login {
    WebDriver wd;

  //
    // @BeforeTest
   // public void preConditions() {
        //if (isLogged()) {
            //logOut();
     //  }

    //}

    @Test
    public void loginPositive() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wd.navigate().to("https://trello.com/");

        WebElement loginButton = wd.findElement(By.cssSelector("[href='/login']"));
        loginButton.click(); // click Log in button

        WebElement emailButton = wd.findElement(By.cssSelector("#user"));
        emailButton.click();
        emailButton.clear();
        emailButton.sendKeys("juliakliot.jk@gmail.com");// enter email

        WebElement attlassianButton = wd.findElement(By.cssSelector("#login"));
        attlassianButton.click();
        pause(5000);


        WebElement passwordInput = wd.findElement(By.cssSelector("#password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("misha240613");


        WebElement submitButton = wd.findElement(By.cssSelector("#login-submit"));
        submitButton.click();

        Assert.assertTrue(isLogged());


        // wd.close();
        //wd.quit();

    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isLogged() {
        return wd.findElements(By.cssSelector("[data-test-id='header-member-menu-button']")).size() > 0;
    }

    public void logOut() {
        WebElement clickAvatar = wd.findElement(By.cssSelector("[data-test-id='header-member-menu-button']"));
        clickAvatar.click();
        WebElement exit = wd.findElement(By.cssSelector("[data-test-id='header-member-menu-logout']"));
        exit.click();
        WebElement quit = wd.findElement(By.cssSelector("#logout-submit"));
        quit.click();

    }
}
