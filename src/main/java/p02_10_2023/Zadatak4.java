package p02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class Zadatak4 {
//    Napisati program koji:
//    Kreirati screenshots folder u projektu
//    Ucitava stranicu https://google.com
//    Kreira screenshot stranice
//    Sacuvati screenshot u folderu screenshots pod imenom screenshot1.jpg
//    Koristan link 1. LAKSE CE VAM BITI PREKO OVOG
//    Koristan link 2
//    Koristan link 3
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.manage().window().maximize();
        driver.navigate().to("https://google.com ");

        Helper.takeAScreenshot(driver);

        driver.quit();
    }
}
