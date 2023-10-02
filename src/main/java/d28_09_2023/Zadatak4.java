package d28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak4 {
//    Ucitati stranicu http://seleniumdemo.com/?post_type=product
//    Klik na search dugme u gornjem desnom uglu
//    Cekati da forma za pretragu bude vidljiva
//    Uneti sledeci tekst za pretragu BDD Cucumber i ENTER
//    Dohvatiti prvi rezultat pretrage i proveriti da li u nazivu sadrzi tekst koji je unet za pretragu. Ispisati odgovarajuce poruke u terminalu
public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

    driver.get("http://seleniumdemo.com/?post_type=product");

    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

    driver.findElement(By.xpath("//a[contains(@class,'search-toggle_btn icn-search czr-overlay-toggle_btn')]"))
            .click();
    WebElement searchInput = driver.findElement(By.id("s-651536d633c09"));
    searchInput.sendKeys("BDD Cucumber");
    searchInput.sendKeys(Keys.ENTER);

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".grid__wrapper")));
    if (driver.findElement(By.cssSelector(".czr-title")).getText().contains("BDD Cucumber")){
        System.out.println("Result title contains \"BDD Cucumber\"");
    } else {
        System.out.println("Result title does not contain \"BDD Cucumber\"");
    }

    driver.quit();

}
}
