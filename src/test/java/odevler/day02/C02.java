package odevler.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class C02 {
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

    @Test
    public void test01() {
        // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz.
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        // Add Element butonuna 100 defa basınız
        for (int i = 0; i <100 ; i++) {
            driver.findElement(By.xpath("//*[text()='Add Element']")).click();

        }

        // 100 defa basıldığını test ediniz
        List<WebElement> deleteButonlar = driver.findElements(By.xpath("//*[@class='added-manually']"));
        Assert.assertTrue(deleteButonlar.size()==100);

        // 90 defa delete butonuna basınız
        for (int i = 0; i <90 ; i++) {
            driver.findElement(By.xpath("(//*[@class='added-manually'])[1]")).click();
        }

        // 90 defa basıldığını doğrulayınız
        List<WebElement> kalanButonlar = driver.findElements(By.xpath("//*[@class='added-manually']"));
        Assert.assertTrue(kalanButonlar.size()==10);



    }
      // Sayfayı kapatınız
    @After
    public void tearDown() throws Exception {
         driver.close();
    }
}
