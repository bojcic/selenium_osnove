package d26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak2 {
//    apisati program koji:
//    Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
//    Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika element obrisao sa stranice i ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI PETLJOM)
//    POMOC: Brisite elemente odozdo.
//            (ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo
public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();

    driver.get("https://s.bootsnipp.com/iframe/Dq2X");
    List<WebElement> alerts = driver.findElements(By.cssSelector(".alert>button"));
    int totalAlerts = alerts.size();
    for (int i = 0; i < totalAlerts; i++) {
        driver.findElement(By.xpath("//div[@class='col-md-12']/div[last()]/button")).click();
        List<WebElement> alertsNow = driver.findElements(By.cssSelector(".alert>button"));
        if (alertsNow.size()<alerts.size()){
            System.out.println("Poruka obrisana!");
        } else {
            System.out.println("Poruka nije obrisana!");
        }
        alerts = driver.findElements(By.cssSelector(".alert>button"));
    }

    driver.navigate().refresh();

    List<WebElement> alertsTop = driver.findElements(By.cssSelector(".alert>button"));
    int totalAlertsTop = alertsTop.size();
    for (int i = 0; i < totalAlertsTop; i++) {
        driver.findElement(By.xpath("//div[@class='col-md-12']/div[1]/button")).click();
        Thread.sleep(1000);
        List<WebElement> alertsNow = driver.findElements(By.cssSelector(".alert>button"));
        if (alertsNow.size()<alertsTop.size()){
            System.out.println("Poruka obrisana!");
        } else {
            System.out.println("Poruka nije obrisana!");
        }
        alertsTop = driver.findElements(By.cssSelector(".alert>button"));
    }

}
}
