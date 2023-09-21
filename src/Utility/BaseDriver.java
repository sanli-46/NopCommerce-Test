package Utility;

import Elements.PrElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeMethod
    public void startAnnotation() {
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.get("https://demo.nopcommerce.com");

        //loginFunction();
    }
    @AfterMethod
    public void finishAnnotation() {
        Func.Wait(3);
        driver.quit();
    }
    public void loginMethod(){
        PrElement pr=new PrElement();

        pr.loginButton.click();
        pr.loginEmail.sendKeys("Test.can@gmail.com");
        pr.loginPassword.sendKeys("123456");
        pr.log_inButton.click();
    }
    //Rasgele bir sayi uretmek icin
    public static int generalRandom(int min, int max) {
        Random rnd = new Random();
        return rnd.nextInt((max - min) + 1) + min;

    }
}