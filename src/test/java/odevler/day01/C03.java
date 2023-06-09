package odevler.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03 {
    /*
        ÖDEV

        1.Yeni bir Class olusturalim.C06_ManageWindow
        2.Amazon soyfasina gidelim. https://www.amazon.com/
        3.Sayfanin konumunu ve boyutlarini yazdirin
        4.Sayfayi simge durumuna getirin
        5.simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        6.Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        7.Sayfayi fullscreen yapin
        8.Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        9.Sayfayi kapatin
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
        //3.Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Konum" + driver.manage().window().getPosition());
        System.out.println("Boyut" + driver.manage().window().getSize());
    }

    @Test
    public void test2() throws InterruptedException {
       //4.Sayfayi simge durumuna getirin
       driver.manage().window().minimize();
       //5.simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(3000);
        driver.manage().window().maximize();
        //6.Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        System.out.println("Konum" + driver.manage().window().getPosition());
        System.out.println("Boyut" + driver.manage().window().getSize());

    }

    @Test
    public void test3() {
        //8.Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        driver.manage().window().fullscreen();
        System.out.println("Konum" + driver.manage().window().getPosition());
        System.out.println("Boyut" + driver.manage().window().getSize());

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
