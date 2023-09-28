package p26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak5 {
//    Napisati program koji ucitava stranicu http://cms.demo.katalon.com/my-account/, cekira Remember me checkbox.
//    Posto ne radi sajt, probajte funkcionalnost checkbox-a na ovom sajtu https://demoqa.com/automation-practice-form
//    Na kraju programa proverite da li je element cekiran. Izguglajte kako mozemo da proverimo da li je element cekiran.
public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://demoqa.com/automation-practice-form");
    WebElement checkbox = driver.findElement(By.cssSelector("#hobbiesWrapper label:nth-child(2)"));
    WebElement checkboxCheck = driver.findElement(By.cssSelector("hobbies-checkbox-1"));
    checkbox.click();
    if (checkbox.isSelected()){
        System.out.println("Čekirano");
    } else {
        System.out.println("Nije čekirano");
    }
    driver.quit();
}
}
