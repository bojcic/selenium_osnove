package d02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {
//    Napisati program koji:
//    Ucitava stranu https://itbootcamp.rs/
//    Misem prelazi preko Vesti iz navigacionog menija
//    Ceka da se prikaze padajuci meni za Vesti
//    Misem prelazi preko Kursevi iz navigacionog menija
//    Ceka da se prikaze padajuci meni za Kursevi
//    Misem prelazi preko Prijava i pravilnik iz navigacionog menija
//    Ceka da se prikaze padajuci meni za Prijava i pravilnik
//    Koristan link. Mouse over preko seleniuma https://www.selenium.dev/documentation/webdriver/actions_api/mouse/#move-to-element
public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    driver.manage().deleteAllCookies();
    driver.navigate().to("https://itbootcamp.rs/");

    new Actions(driver)
            .moveToElement(driver.findElement(By.id("menu-item-6408")))
            .perform();
    wait
            .withMessage("Error: 'Vesti' dropdown did not display")
            .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#menu-item-6408 ul")));

    new Actions(driver)
            .moveToElement(driver.findElement(By.id("menu-item-5362")))
            .perform();
    wait
            .withMessage("Error: 'Kursevi' dropdown did not display")
            .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#menu-item-5362 ul")));

    new Actions(driver)
            .moveToElement(driver.findElement(By.id("menu-item-5453")))
            .perform();
    wait
            .withMessage("Error: 'Prijava' dropdown did not display")
            .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#menu-item-5453 ul")));

    driver.quit();
}
}
