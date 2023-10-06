package p02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.File;
import java.time.Duration;

public class Zadatak1 {
//    Napisati program koji:
//    Krairajte folder za fajlove u okviru projekta pod nazivom test_data
//    U folder skinite i postavite proizvoljnu sliku
//    Ucitava stranu https://tus.io/demo.html
//    Skrola do dela za upload fajla
//    Aploadujte sliku
//    Cekajte da se pojava dugme za download fajla

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.navigate().to("https://tus.io/demo.html");

        WebElement uploadBttn = driver.findElement(By.id("P0-0"));

        File uploadPNG = new File("test_data/George-Carlin.png");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", uploadBttn);

        uploadBttn.sendKeys(uploadPNG.getAbsolutePath());
        wait
                .withMessage("Upload not done!")
                .until(ExpectedConditions.textToBePresentInElementLocated(By.className("_heading_gq6c0_21"),"The upload is complete!"));

        driver.quit();

    }
}
