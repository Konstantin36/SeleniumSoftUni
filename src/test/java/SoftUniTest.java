import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Konstantin on 2/26/2017.
 */
public class SoftUniTest {

    private WebDriver driver ;
    static final String LOGIN_USERNAME = "testtest";
    static final String LOGIN_PASSWORD = "testtest";
    @Before
    public void setUp(){
    this.driver = new FirefoxDriver();
    this.driver
            .manage()
            .timeouts()
            .implicitlyWait(10,TimeUnit.SECONDS);
    this.driver.manage().window().maximize();
    }
    @Test
    public void testLogin_ValidCredentials_expectedNavigationToProfile(){
    this.driver.get("https://softuni.bg");
        WebElement loginLink
                =this.driver
                .findElement(By.xpath("/html/body/div[2]/div[1]/header/nav/div[2]/ul/li[2]/span/a"));
        loginLink.click();

        WebElement usernameField
                =this.driver
                .findElement(By.id("LoginUserName"));
        usernameField.sendKeys(LOGIN_USERNAME);

        WebElement passwordField
                =this.driver
                .findElement(By.id("LoginPassword"));

        passwordField.sendKeys(LOGIN_PASSWORD);

        WebElement loginButton
                =this.driver
                .findElement(By.cssSelector("input [ @value=\'Вход\' ]"));

        loginButton.click();

        WebElement loggedUserName
                = this.driver
                .findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1/div/div/div[1]/div/div[2]/h2]/strong"));

         String loggetUserNameText =  loggedUserName.getText().trim();
         boolean expectedUserNameInBrackets = loggetUserNameText
                 .endsWith("(" + LOGIN_USERNAME + ")");

        Assert.assertTrue(expectedUserNameInBrackets);

    }

    @Test
    public void testRegister_uniqueUsername_expectedSuccessfullLogin(){

    }

    @After
    public void tearDown(){
     this.driver.quit();
    }
}
