package p25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {
//    Napisati program koji:
//    Maksimizuje prozor
//    Ucitava stranicu https://demoqa.com/login
//    Za username unosi itbootcamp . Xpath za trazivnje ovog elementa treba da bude preko id atributa.
//    Za lozinku unosi ITBootcamp2021!  Xpath za trazenje ovog elementa treba da bude preko placeholder atributa.
//    Klikce na dugme Login. Xpath ovog elementa treba da bude tako da se prvo dohvati form element i da se od njega spusti do dugmeta
//    Ceka 5sekundi
//    Klikce na dugme Log out.Xpath ovog elementa treba da bude po tekstu elementa. Koristan link
//    Zatvara pretrazivac

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");
        driver.findElement(By.xpath("//input[@id='userName']"))
                .sendKeys("itbootcamp");
        driver.findElement(By.xpath("//input[@placeholder=\"Password\"]"))
                .sendKeys("ITBootcamp2021!");
        driver.findElement(By.xpath("//form/div[4]/div/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[text()='Log out']")).click();
        driver.quit();
    }
}
