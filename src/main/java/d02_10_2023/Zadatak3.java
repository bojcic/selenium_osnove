package d02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Zadatak3 {
//    Ucitava stranicu https://demoqa.com/broken
//    Hvata oba linka sa stranice i
//    Za svaki link proverava status da je veci ili jednak od 200 i manji od 400
//    Koristan link za citanje status koda nekog url-a

    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().deleteAllCookies();
        driver.navigate().to("https://demoqa.com/broken");

        List<WebElement> links = driver.findElements(By.cssSelector(".col-md-6>div:nth-child(2) a"));

        for (WebElement link : links) {
            if (Helper.getHTTPResponseStatusCode(link.getAttribute("href"))>=200
                    && Helper.getHTTPResponseStatusCode(link.getAttribute("href"))<400){
                System.out.println("Link " + link.getAttribute("href") + " je validan");
            } else {
                System.out.println("Link " + link.getAttribute("href") + " nije validan");
            }

        }
    }
}
