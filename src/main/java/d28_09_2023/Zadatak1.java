package d28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {
//    1.Zadatak
//    Napisati program koji ucitava stranicu https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort=
//    Klik na Type drawdown
//    Klik na Public iz drowdowna
//    Ceka da se Clear dugme u desnom uglu prikaze koristeci explicit wait
//    Kilk na Clear filter u desnom uglu
public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    driver.get("https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort=");
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    wait.until(ExpectedConditions
            .visibilityOfElementLocated(By.cssSelector("#type-options>summary"))).click();
    wait.until(ExpectedConditions
            .visibilityOfElementLocated(By.cssSelector("#type-options>details-menu>div>div>label:nth-child(2)"))).click();
    wait.until(ExpectedConditions
            .visibilityOfElementLocated(By.cssSelector("#org-repositories>div>div>div>div:nth-child(2)>a"))).click();

    driver.quit();
}
}
