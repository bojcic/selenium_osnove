package p25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {
//    Napisati program koji:
//    Ucitava stranicu https://demoqa.com/text-box
//    Unosi informacije za 3 osobe koristeci petlju
//    Full Name
//    Email
//    Current Address
//    Permanent Address
//    Klik na submit
//    Ceka 2 sekunde
//    Osvezava stranicu
//    Zatvara pretrazivac

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box ");
        driver.manage().window().maximize();
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.cssSelector("input#userName")).sendKeys("Nešto nešto");
            driver.findElement(By.cssSelector("input#userEmail")).sendKeys("kfkjsdbfbdsjk@gmail.com");
            driver.findElement(By.cssSelector("#currentAddress")).sendKeys("Srbija");
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("#submit")).click();
            Thread.sleep(2000);
            driver.navigate().refresh();
            Thread.sleep(1000);
        }
        driver.quit();

    }
}
