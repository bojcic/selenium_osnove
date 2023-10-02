package p28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Zadatak1 {
//    Ucitati stranicu https://demoqa.com/modal-dialogs
//    Kliknuti na dugme Large modal
//    Proverite da li se prikazao dijalog i ispisite u konzoli odgovarajuce poruke
public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    driver.get("https://demoqa.com/modal-dialogs");
    driver.findElement(By.id("showLargeModal")).click();

//        WebElement dialog = null;
//        try {
//            dialog = driver.findElement(By.id("example-modal-sizes-title-lg"));
//        } catch (Exception e) {
//            dialog = null;
//        }
//
//        if (dialog != null) {
//            System.out.println("Dijalog se otvorio.");
//        } else {
//            System.out.println("Dijalog se otvorio.");
//        }
    boolean isDialogOpen = true;
    try {
        driver.findElement(By.id("example-modal-sizes-title-lg"));
    } catch (Exception e) {
        isDialogOpen = false;
    }

    if (isDialogOpen) {
        System.out.println("Dijalog se otvorio.");
    } else {
        System.out.println("Dijalog se otvorio.");
    }
}

}
