package d29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class Zadatak1 {
//    Napisati program koji testira infinity scroll.
//    Ucitati stranu https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html
//    Selektujte delay od 2000ms, koristeci Select klasu.
//            Skrol do Show more dugmeta koje se nalazi na dnu stranice
//    Sacekajte da dugme bude klikljivo
//    Klik na Show more dugme
//    Sacekjate da broj elemenata bude X (X je koliko se kod vas ucitava)
//    Sacekajte da dugme vise ne bude klikljivo

    public static void main(String[] args) throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//
//        driver.manage().window().maximize();
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//
//        driver.get("https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html");
//
//        Select delay = new Select(driver.findElement(By.id("delay-select")));
//        delay.selectByValue("2000");
//        Thread.sleep(2000);
//
//        WebElement showMore = driver.findElement(By.cssSelector("button#infinite-scroll-button"));
//        WebElement footer = driver.findElement(By.cssSelector("div.footer"));
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//
//        new Actions(driver).scrollToElement(driver.findElement(By.cssSelector("div.footer"))).perform();
//        wait
//                .withMessage("Scroll button not clickable")
//                .until(ExpectedConditions.elementToBeClickable(showMore));
//        showMore.click();
//        Thread.sleep(2000);




    }
}
