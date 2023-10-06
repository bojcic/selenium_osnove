package d02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Zadatak4 {
//    Napisati program koji:
//    Ucitava stranicu https://itbootcamp.rs/
//    Skrola do slajdera na dnu stranice (u kome su slike Java, Php, Selenium, …)
//    Cita sve linkove slika iz slajdera
//    Proverava url svake slike, i za sve slike koje imaju status veci i jednak od 200 a manji od 300, skida i smesta u folder itbootcamp_slider u okviru projekta
//    Azurirajte gitignore da ignorise itbootcamp_slider folder
public static void main(String[] args) throws IOException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    driver.manage().deleteAllCookies();
    driver.navigate().to("https://itbootcamp.rs/");

    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.className("owl-stage")));

    List<WebElement> imageUrls = driver.findElements(By.cssSelector(".owl-stage img"));

    for (int i = 0; i < imageUrls.size(); i++) {
        if (Helper.getHTTPResponseStatusCode(imageUrls.get(i).getAttribute("src"))>=200
                && Helper.getHTTPResponseStatusCode(imageUrls.get(i).getAttribute("src"))<300){
            Helper.downloadUsingStream(imageUrls.get(i).getAttribute("src"),"itbootcamp_slider/pic" + i +".jpg");
        }
    }

    driver.quit();

}
}
