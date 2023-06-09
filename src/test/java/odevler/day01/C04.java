package odevler.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04 {
/*
        ÖDEV 1

        Yeni bir Class olusturalim.C07_ManageWindowSet
Amazon soyfasina gidelim. https://www.amazon.com/
Sayfanin konumunu ve boyutlarini yazdirin
Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
8. Sayfayi kapatin
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
    public void test1() throws InterruptedException {
        //Sayfanin konumunu ve boyutlarini yazdirin
        //Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin

        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());
        driver.manage().window().setPosition(new Point(50,50));
        Thread.sleep(3000);
        driver.manage().window().setSize(new Dimension(600,600));

        //Sayfanin sizin istediginiz konum ve boyuta geldigini test edin.

        Point actualPosition = driver.manage().window().getPosition();
        Point expectedPosition = new Point(50,50);
        Assert.assertTrue(actualPosition.equals(expectedPosition));

        Dimension actualDimension = driver.manage().window().getSize();
        Dimension expectedDimension = new Dimension(600,600);
        Assert.assertTrue(actualDimension.equals(expectedDimension));


    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
