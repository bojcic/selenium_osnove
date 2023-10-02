package d29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Zadatak4 {
//    Napisati program koji:
//    Ucitava stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//    Vrsi klik na Primary dugme, Secondary, Sucess, Danger
//    Ceka da broj toasts-a bude 4
//    Ispisuje poruku, toasts su prikazani
//    Ceka da broj toasts-a bude 0
//    Ispisuje poruku, toasts su se izgubili
public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");

    List<WebElement> buttons = driver.findElements(By.xpath("//button[contains(@id, 'basic-')]"));
    List<WebElement> toasts = driver.findElements(By.xpath("//div[contains(@id, 'basic-')]"));

    Thread.sleep(2000);

    for (int i = 0; i < 4; i++) {
        buttons.get(i).click();
    }

    wait
            .withMessage("Toast are not visible")
            .until(ExpectedConditions.visibilityOfAllElements(toasts.get(0),toasts.get(1),toasts.get(2),toasts.get(3)));
    System.out.println("4 Toasts are visible");

    wait
            .withMessage("Toast didn't disappear")
            .until(ExpectedConditions.invisibilityOfAllElements(toasts.get(0),toasts.get(1),toasts.get(2),toasts.get(3)));
    System.out.println("Toasts disappeared");
}
}
