package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
//    Maksimizirati prozor
//    Ucitati stranicu https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
//    Prijavite se na sistem
//    Username: Admin
//    Password: admin123
//    Cekanje od 5s
//    U input za pretragu iz navigacije unesite tekst Me
//    Kliknite na prvi rezultat pretrage (to ce biti Time)
//    Cekanje od 1s
//    Kliknite u headeru na svog avatara (to ce biti na ime: Paul Collings)
//    Klinkite na logout
//    Cekanje od 5s
//    Zatvorite pretrazivac
public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    String username = "Admin";
    String password = "admin123";
    Thread.sleep(3000);
    driver.findElement(By.cssSelector("input[placeholder = 'Username']")).sendKeys(username);
    driver.findElement(By.cssSelector("input[placeholder = 'Password']")).sendKeys(password);
    driver.findElement(By.cssSelector(".oxd-button--main")).click();
    Thread.sleep(5000);
    driver.findElement(By.cssSelector(".oxd-main-menu-search input")).sendKeys("Me");
    Thread.sleep(1000);
    driver.findElement(By.cssSelector("ul.oxd-main-menu>li:nth-child(1)")).click();
    Thread.sleep(1000);
    driver.findElement(By.cssSelector(".oxd-userdropdown")).click();
    driver.findElement(By.cssSelector(".oxd-dropdown-menu>li:nth-child(4)")).click();
    Thread.sleep(5000);
    driver.quit();


}
}
