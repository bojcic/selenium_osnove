package p26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak2 {
//    Napisti program koji:
//    Ucitava stranicu https://s.bootsnipp.com/iframe/z80en
//    Hvata sve elemente prve kolone i stampa tekst svakog elementa. Kako da od nekog elementa procitamo tekst imate na sledecem linku
//    Ceka 1s
//    Hvata sve elemente prvog reda i stampa tekst svakog elementa
//    Ceka 5s
//    Zatvara pretrazivac

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://s.bootsnipp.com/iframe/z80en");
        List<WebElement> firstColumn = driver.findElements(By.cssSelector("div#lorem>table>tbody>tr td:nth-child(1)"));
        for (int i = 0; i < firstColumn.size(); i++) {
            firstColumn.get(i).getText();
            Thread.sleep(1000);
        }
        List<WebElement> firsRow = driver.findElements(By.cssSelector("div#lorem>table>tbody>tr:nth-child(1) td"));
        for (int i = 0; i < firsRow.size(); i++) {
            firsRow.get(i).getText();
            Thread.sleep(5000);
        }
        driver.quit();
    }
}
