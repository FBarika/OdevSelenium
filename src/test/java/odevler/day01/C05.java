package odevler.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C05 {

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--lang=en");
        driver= new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    /*
            ÖDEV 2
            Yeni bir class olusturalim (Homework)
    ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
    oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
    Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i
    yazdirin.
    https://www.walmart.com/ sayfasina gidin.
    Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
    Tekrar “facebook” sayfasina donun
    Sayfayi yenileyin
    Sayfayi tam sayfa (maximize) yapin  9.Browser’i kapatin
             */
    @Test
    public void test01() {
        //Yeni bir class olusturalim (Homework)
        //    ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
        //    oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.

        driver.get("https://www.facebook.com/");
        if(driver.getTitle().equals("facebook")){
            System.out.println("verify");
        }else{
            System.out.println(driver.getTitle());
        }
        //Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i
        //    yazdirin.

        Assert.assertFalse(driver.getTitle().contains("facebook"));
        System.out.println(driver.getCurrentUrl());

        //https://www.walmart.com/ sayfasina gidin.
        //Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        driver.get("https://www.walmart.com/");
        Assert.assertTrue(driver.getTitle().contains("Walmart.com"));

        //Tekrar “facebook” sayfasina donun
        driver.navigate().back();
        //    Sayfayi yenileyin
        driver.navigate().refresh();
        //    Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();

    }



    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
