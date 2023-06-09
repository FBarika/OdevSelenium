package odevler.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class C01 {

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
        //Amazon sayfasına gidiniz
        driver.get("https://www.amazon.com/");

        //iphone aratınız
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //çıkan sonuç yazısını konsola yazdırınız
        WebElement iphoneSonuc = driver.findElement(By.xpath("(//h1//div)[3]"));
        System.out.println(iphoneSonuc.getText());

        //çıkan ürünlerden ilk 5 tanesine tıklayıp sayfa başlıklarını yazdırınız
        List<WebElement> iphoneLinkler = driver.findElements(By.xpath("//h2//span"));
        for (int i = 0; i <5 ; i++) {
            iphoneLinkler=driver.findElements(By.xpath("//h2//span"));
            iphoneLinkler.get(i).click();
            System.out.println(driver.getTitle());
            driver.navigate().back();
        }

    }


    @After
    public void tearDown() throws Exception {
       driver.close();
    }
}
