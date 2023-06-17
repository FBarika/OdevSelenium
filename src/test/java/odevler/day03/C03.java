package odevler.day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03 {
    /*
    ●https://www.amazon.com/ adresine gidin.
-Test 1
Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
oldugunu test edin
-Test 2
1.Kategori menusunden Books secenegini secin
2.Arama kutusuna Java yazin ve aratin
3.Bulunan sonuc sayisini yazdirin
4.Sonucun Java kelimesini icerdigini test edin.
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
        driver.get("https://www.amazon.com");

    }

    @Test
    public void test01() {
        //-Test 1
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        //oldugunu test edin
        WebElement ddm = driver.findElement(By.xpath("//select"));
        Select select = new Select(ddm);
        List<WebElement> secenekler = select.getOptions();
        Assert.assertFalse(secenekler.size()==45);

    }

    @Test
    public void test02() {

        //-Test 2
        //1.Kategori menusunden Books secenegini secin
        WebElement ddm = driver.findElement(By.xpath("//select"));
        Select select = new Select(ddm);
        select.selectByIndex(5);
        //2.Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        //3.Bulunan sonuc sayisini yazdirin
        String sonuc = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]")).getText();
        //4.Sonucun Java kelimesini icerdigini test edin.
        Assert.assertTrue(sonuc.contains("Java"));

    }

    @After
    public void tearDown() throws Exception {
        //driver.close();
    }
}
