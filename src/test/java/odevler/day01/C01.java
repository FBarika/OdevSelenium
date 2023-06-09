package odevler.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
    /*
        ÖDEV
        Yeni bir package olusturalim : day01
Yeni bir class olusturalim : C03_GetMethods
Amazon sayfasina gidelim. https://www.amazon.com/
Sayfa basligini(title) yazdirin
Sayfa basliginin “Amazon” icerdigini test edin
Sayfa adresini(url) yazdirin
Sayfa url’inin “amazon” icerdigini test edin.
Sayfa handle degerini yazdirin
Sayfa HTML kodlarinda “Gateway” kelimesi gectigini test edin
Sayfayi kapatin.

         */


    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }

    @Test
    public void test1() {
        //Amazon sayfasina gidelim. https://www.amazon.com/
        //Sayfa basligini(title) yazdirin

        System.out.println(driver.getTitle());
    }

    @Test
    public void test2() {
        //Sayfa basliginin “Amazon” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
    }

    @Test
    public void test3() {
        //Sayfa adresini(url) yazdirin
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void test4() {
        //Sayfa url’inin “amazon” icerdigini test edin.
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));

    }

    @Test
    public void test5() {
        //Sayfa handle degerini yazdirin
        System.out.println(driver.getWindowHandle());

    }

    @Test
    public void test6() {
        //Sayfa HTML kodlarinda “Gateway” kelimesi gectigini test edin
        Assert.assertTrue(driver.getPageSource().contains("Gateway"));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
