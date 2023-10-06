package d29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Zadatak5 {
//    Napisati program koji:
//    Ucitava stranicu https://tus.io/demo.html
//    Hvata sve linkove sa stranice
//    Skrola do svakog h3 elementa
//    Od svakog h3 elementa cita text

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://tus.io/demo.html");

        List<WebElement> links = driver.findElements(By.tagName("a"));
        List<WebElement> headlines = driver.findElements(By.tagName("h3"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i < headlines.size(); i++) {
            js.executeScript("arguments[0].scrollIntoView();", headlines.get(i));
            System.out.println("Naslov " + (i+1) + ": " + headlines.get(i).getText());
        }
        driver.quit();
    }
}
