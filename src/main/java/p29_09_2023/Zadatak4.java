package p29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak4 {
//    Napisati program koji
//    ucitava stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//    Klik Primary dugme
//    Ceka da se pojavi toasts u gBootstrap Toasts - examples & tutorialornjem desnom uglu
//    Ispisuje da se element pojavio
//    Ceka da se izgubi toasts u gornjem desnom uglu
//    Ispisuje da se elment izgubio
//    Klik na primary dugme
//    Ceka da se pojavi toasts u gornjem desnom uglu
//    Ispisuje da se element pojavio
//    Klik na x dugme iz toasts-a
//    Ceka da se element izgubi
//    Ispisuje da se element izgubio
public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    driver.navigate().to("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");

    driver.findElement(By.id("basic-primary-trigger")).click();

    WebElement toasts = driver.findElement(By.id("basic-primary-example"));
    wait
            .withMessage("Neka pporuka za gresku")
            .until(ExpectedConditions.visibilityOfAllElements(toasts));
    wait
            .withMessage("Neka pporuka za gresku")
            .until(ExpectedConditions.invisibilityOf(toasts));


    driver.findElement(By.id("basic-primary-trigger")).click();
    wait
            .withMessage("Neka pporuka za gresku")
            .until(ExpectedConditions.visibilityOfAllElements(toasts));
    wait
            .withMessage("Neka pporuka za gresku")
            .until(ExpectedConditions.invisibilityOf(toasts));



    Thread.sleep(5000);
    driver.quit();
}

}
