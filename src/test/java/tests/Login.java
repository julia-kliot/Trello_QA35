package tests;

import model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class Login extends TestBase {



    @BeforeTest
   public void preConditions() {
        if (app.getUser().isLogged()) {
            app.getUser().logOut();
        }
    }



    @Test
    public void loginPositive1() {
       // User user = new User().withEmail("juliakliot.jk@gmail.com").withPassword("misha240613");
        User user= User.builder().email("juliakliot.jk@gmail.com").password("misha240613").build();

        app.getUser().initLogin();
        app.getUser().pause(2000);
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(2000);


        Assert.assertTrue(app.getUser().isLogged());

    }

   @Test
    public void loginPositive2() {

        app.getUser().initLogin();
        app.getUser().pause(2000);
        app.getUser().fillLoginForm2("juliakliot.jk@gmail.com","misha240613");
        app.getUser().submitLogin();
       app.getUser().pause(2000);


        Assert.assertTrue(app.getUser().isLogged());


    }

}





