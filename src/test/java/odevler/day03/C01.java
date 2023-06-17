package odevler.day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01 {
    /*
    *** Aşağıdaki task'i Junit framework'ü ile yapınız

-Amazon sayfasına gidelim
-Arama Kutusundaki Dropdown menuyu yazdıralım
-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
Not: Select Class'ı kullanalım
     */

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
    public void test01()  {
        //-Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //-Arama Kutusundaki Dropdown menuyu yazdıralım
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        select.getOptions().forEach(t-> System.out.println(t.getText()));
        System.out.println("************************************");

        //-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
        //başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
        for (int i = 1; i <6; i++) {
           select.selectByIndex(i);
           System.out.println(driver.getTitle());
           bekle(3);
        }

        //Not: Select Class'ı kullanalım

    }



    @After
    public void tearDown() throws Exception {
       // driver.close();
    }

    public void bekle(int saniye) {
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
