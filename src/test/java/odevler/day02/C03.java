package odevler.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C03 {
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
        2- https://www.amazon.com/ adresine gidin
        3- Browseri tam sayfa yapin
        - Sayfayi “refresh” yapin
        Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        Gift Cards sekmesine basin
        Birthday butonuna basin
        Best Seller bolumunden ilk urunu tiklayin
         9- Gift card details’den 25 $’i secin
        10-Urun ucretinin 25$ oldugunu test edin
        10-Sayfayi kapatin
         */

    @Test
    public void test01() {
        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        // Browseri tam sayfa yapin
        driver.manage().window().fullscreen();
        // Sayfayi “refresh” yapin
        driver.navigate().refresh();
        //Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Spend less"));
        //Gift Cards sekmesine basin
        driver.findElement(By.xpath("(//*[@tabindex='0'])[11]")).click();
        //Birthday butonuna basin
        driver.findElement(By.xpath("//img[@alt='Birthday']")).click();
        //Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//img[@alt='Amazon.com eGift Card'])[1]")).click();
        // Gift card details’den 25 $’i secin
        driver.findElement(By.id("a-autoid-28")).click();
        //Urun ucretinin 25$ oldugunu test edin
        Assert.assertTrue(driver.findElement(By.id("a-autoid-28")).getText().contains("$25"));






    }

    //Sayfayi kapatin
    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
