package p02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak2 {
//    Napisati program koji:
//    Ucitava stranu https://blueimp.github.io/jQuery-File-Upload/
//    Uploadujte sliku
//    Ceka se da se pojavi slika u listi uploadovanih fajlova
//    Koristite uslov da broj elemenata bude 1.
//    Klik na Start dugme u okviru item-a koji se uploadovao
//    Ceka se da se pojavi delete dugme pored itema
//    Klik na delete dugme pored itema
//    Ceka se da se element obrise
//    Koristite da broj elemenata bude 0

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.manage().window().maximize();
        driver.navigate().to("https://blueimp.github.io/jQuery-File-Upload/ ");

        File uploadPNG = new File("test_data/George-Carlin.png");

        driver.findElement(By.cssSelector("[type='file']")).sendKeys(uploadPNG.getAbsolutePath());

        wait
                .withMessage("File not uploaded.")
                .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("tbody.files"),1));

        driver.findElement(By.cssSelector("tbody>tr>td:last-child>button:nth-child(2)")).click();

        wait
                .withMessage("Delete button not visible")
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-type='DELETE']")));

        driver.findElement(By.cssSelector("[data-type='DELETE']")).click();

        wait
                .withMessage("File not deleted.")
                .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("tbody.files>tr"),0));

        driver.quit();
    }
}
