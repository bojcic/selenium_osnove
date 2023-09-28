package p26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak4 {
//    Napisati program koji ucitava stranicu https://www.ebay.com/ i bira kategoriju “Crafts”
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        WebElement button = driver.findElement(By.cssSelector("select#gh-cat"));
        Thread.sleep(5000);


        Select options = new Select(driver.findElement(By.cssSelector("select#gh-cat")));

        options.selectByVisibleText("Crafts");
        Thread.sleep(5000);



        driver.quit();
    }
}
