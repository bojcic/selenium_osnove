package p29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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


    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    driver.navigate().to("https://s.bootsnipp.com/iframe/klDWV");

    WebElement preloader =
            driver.findElement(By.className("preloader-wrap"));
    for (int i = 0; i < 20; i++) {

        System.out.println(i + " " + preloader.isDisplayed());

    }

//        wait.until(ExpectedConditions
//                .invisibilityOfElementLocated(By.className("preloader-wrap")));




//        wait.until(ExpectedConditions.textToBe(By.id("precent"), "100%"));

//        WebElement loader = driver.findElement(By.className("preloader-wrap"));
//        wait
//                .withMessage("Stranica se nije ucitala!")
//                .until(ExpectedConditions
//                        .attributeContains(
//                                loader,
//                                "style",
//                                "display: none;"));


//        wait
//                .withMessage("Stranica se nije ucitala!")
//                .until(ExpectedConditions
//                        .attributeContains(
//                                By.className("preloader-wrap"),
//                                "style",
//                                "display: none;"));




    Thread.sleep(5000);
    driver.quit();
}
}
