package d02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {
//    Napisati program koji:
//    Podesava:
//    implicitno cekanje za trazenje elemenata od 10s
//    implicitno cekanje za ucitavanje stranice od 10s
//    eksplicitno cekanje podeseno na 10s
//    Podaci:
//    Potrebno je u projektu ukljuciti 4 slike:
//    front.jpg
//    left.jpg
//    right.jpg
//    back.jpg
//    Koraci:
//    Ucitava stranicu https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you
//    Maksimizuje prozor
//    Klik na edit ikonicu
//    Klik na delete iz iskacuceg dijaloga
//    Klik na Add Image dugme
//    Sacekajte da se pojavi desni meni
//    Uploadujte front.jpg sliku
//    Sacekajte da je ispod uploada slike, broj slika 1.
//    Klik na sliku
//    Klik na Done dugme
//    Sacekajte 2s
//    Klik na Add Image dugme
//    Sacekajte da se pojavi desni meni
//    Uploadujte right.jpg sliku
//    Sacekajte da je ispod uploada slike, broj slika 2.
//    Klik na sliku
//    Klik na Done dugme
//    Sacekajte 2s
//    Klik na Add Image dugme
//    Sacekajte da se pojavi desni meni
//    Uploadujte back.jpg sliku
//    Sacekajte da je ispod uploada slike, broj slika 3.
//    Klik na sliku
//    Klik na Done dugme
//    Sacekajte 2s
//    Klik na Add Image dugme
//    Sacekajte da se pojavi desni meni
//    Uploadujte back.jpg sliku
//    Sacekajte da je ispod uploada slike, broj slika 3.
//    Klik na sliku
//    Klik na Done dugme
//    Sacekajte 2s
//    Sacekajte da Next dugme bude klikljivo
//    Klik na Next dugme
//    Unesite tekst
//    Klik na Next
//    Klik na Preview
//    Klik na Add to cart
//    Sacekajte 5s
//            Quit
public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    driver.manage().deleteAllCookies();
    driver.navigate().to("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");



    driver.findElement(By.id("active-face")).click();

    wait
            .withMessage("Error: Edit menu not displayed")
            .until(ExpectedConditions.elementToBeClickable(By.id("image-option-remove")))
            .click();

    driver.findElement(By.className("edit-image")).click();

    wait
            .withMessage("Error: Upload image menu not displayed")
            .until(ExpectedConditions.visibilityOfElementLocated(By.className("ihSIDX")))
            ;
    driver.findElement(By.id("imageUpload")).sendKeys("C:\\Users\\Sava\\Desktop\\PROJEKTI\\selenium_osnove\\test_data\\front.jpg");
    wait
            .withMessage("Error: Image not uploaded")
            .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".sc-fsQiph img"),1));

    driver.findElement(By.cssSelector(".sc-fsQiph:last-child div")).click();

    wait
            .withMessage("Error: Done button not displayed")
            .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")))
            .click();

    Thread.sleep(2000);

    driver.findElement(By.id("active-face")).click();

    wait
            .withMessage("Error: Upload image menu not displayed")
            .until(ExpectedConditions.visibilityOfElementLocated(By.className("ihSIDX")))
    ;
    driver.findElement(By.id("imageUpload")).sendKeys("C:\\Users\\Sava\\Desktop\\PROJEKTI\\selenium_osnove\\test_data\\right.jpg");
    wait
            .withMessage("Error: Image not uploaded")
            .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".sc-fsQiph img"),2));

    driver.findElement(By.cssSelector(".sc-fsQiph:last-child div")).click();

    wait
            .withMessage("Error: Done button not displayed")
            .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")))
            .click();

    Thread.sleep(2000);

    driver.findElement(By.id("active-face")).click();

    wait
            .withMessage("Error: Upload image menu not displayed")
            .until(ExpectedConditions.visibilityOfElementLocated(By.className("ihSIDX")))
    ;
    driver.findElement(By.id("imageUpload")).sendKeys("C:\\Users\\Sava\\Desktop\\PROJEKTI\\selenium_osnove\\test_data\\left.jpg");
    wait
            .withMessage("Error: Image not uploaded")
            .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".sc-fsQiph img"),3));

    driver.findElement(By.cssSelector(".sc-fsQiph:last-child div")).click();

    wait
            .withMessage("Error: Done button not displayed")
            .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")))
            .click();

    Thread.sleep(2000);

    driver.findElement(By.id("active-face")).click();

    wait
            .withMessage("Error: Upload image menu not displayed")
            .until(ExpectedConditions.visibilityOfElementLocated(By.className("ihSIDX")))
    ;
    driver.findElement(By.id("imageUpload")).sendKeys("C:\\Users\\Sava\\Desktop\\PROJEKTI\\selenium_osnove\\test_data\\back.jpg");
    wait
            .withMessage("Error: Image not uploaded")
            .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".sc-fsQiph img"),4));

    driver.findElement(By.cssSelector(".sc-fsQiph:last-child div")).click();

    wait
            .withMessage("Error: Done button not displayed")
            .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")))
            .click();

    Thread.sleep(2000);

    wait
            .withMessage("Error: Next button not clickable")
            .until(ExpectedConditions.elementToBeClickable(By.id("next-button")))
            .click();

    wait
            .withMessage("Error: Text input failed")
            .until(ExpectedConditions.visibilityOfElementLocated(By.id("textareaID")))
            .sendKeys("Racoons will rule the world");

    for (int i = 0; i < 4; i++) {
        wait
                .withMessage("Error: Next button not clickable")
                .until(ExpectedConditions.elementToBeClickable(By.id("next-button")))
                .click();
    }

    Thread.sleep(5000);

    driver.quit();




}

}
