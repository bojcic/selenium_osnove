package p25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
//    Napisati program koji:
//    Maksimizuje stranicu
//    Ucitava stranicu https://demoqa.com/webtables
//    Vrsi klik na edit dugme prvog reda
//    Unosi informacije za sva polja u edit formi
//    Klik na submit
//    Ceka par sekundi
//    Zatvara pretrazivac

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/webtables");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#edit-record-1")).click();
        driver.findElement(By.cssSelector("#firstName")).clear();
        driver.findElement(By.cssSelector("#firstName")).sendKeys("Vladimir");
        driver.findElement(By.cssSelector("#lastName")).clear();
        driver.findElement(By.cssSelector("#lastName")).sendKeys("Bojčić");
        driver.findElement(By.cssSelector("#age")).clear();
        driver.findElement(By.cssSelector("#age")).sendKeys("26");
        driver.findElement(By.cssSelector("#salary")).clear();
        driver.findElement(By.cssSelector("#salary")).sendKeys("0");
        driver.findElement(By.cssSelector("#department")).clear();
        driver.findElement(By.cssSelector("#department")).sendKeys("Tuga");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#submit")).click();
        Thread.sleep(3000);
        driver.quit();

    }
}
