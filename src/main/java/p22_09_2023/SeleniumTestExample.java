package p22_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTestExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        Thread.sleep(1200);
        driver.get("https://facebook.com");
        Thread.sleep(1200);
        driver.get("https://youtube.com");
        Thread.sleep(1200);


        // Zatvoranje pretrazivaca nakon sto se zavrsi testiranje
        driver.quit();
    }
}

