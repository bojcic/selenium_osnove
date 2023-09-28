package d26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Scanner;

public class Zadatak1 {
//    Napisati program koji:
//    Ucitava stranicu https://demoqa.com/automation-practice-form
//    Popunjava formu sta stranice. Korisnik unosi podatke sa tastature za popunu forme.
//            (za vezbanje) Probajte da unese i datum. Sa datumom se radi isto kao i sa obicnim inputom sa sendKeys.
//    Klik na submit
public static void main(String[] args) throws InterruptedException {
    Scanner s = new Scanner(System.in);
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();
    driver.get("https://demoqa.com/automation-practice-form");
    Thread.sleep(500);

    System.out.print("Unesite ime: ");
    driver.findElement(By.id("firstName")).clear();
    driver.findElement(By.id("firstName")).sendKeys(s.next());

    System.out.print("Unesite prezime: ");
    driver.findElement(By.id("lastName")).clear();
    driver.findElement(By.id("lastName")).sendKeys(s.next());

    System.out.print("Unesite e-mail: ");
    driver.findElement(By.id("userEmail")).clear();
    driver.findElement(By.id("userEmail")).sendKeys(s.next());

    System.out.print("Unesite pol (male/female/other): ");
    String sex = s.next();
    if (sex.equals("male")){
        driver.findElement(By.xpath("//label[@for='gender-radio-1']")).click();
    } else if (sex.equals("female")) {
        driver.findElement(By.xpath("//label[@for='gender-radio-2']")).click();
    } else {
        driver.findElement(By.xpath("//label[@for='gender-radio-3']")).click();
    }

    System.out.print("Unesite broj telefona (do 10 cifara: ");
    driver.findElement(By.id("userNumber")).clear();
    driver.findElement(By.id("userNumber")).sendKeys(s.next());

//    System.out.println("Unesite datum rođenja : ");
//
//    System.out.print("Dan : ");
//    driver.findElement(By.id("dateOfBirthInput")).sendKeys(s.next() + " ");
//    System.out.print("Mesec (slovima) : ");
//    driver.findElement(By.id("dateOfBirthInput")).sendKeys(s.next() + " ");
//    System.out.print("Godina : ");
//    driver.findElement(By.id("dateOfBirthInput")).sendKeys(s.next());

    System.out.print("Unesite predmete (za prekid unosa napišite STOP): ");
    driver.findElement(By.id("subjectsInput")).clear();
    boolean loop = true;
    while (loop){
        System.out.print("Predmet: ");
        String subject = s.next();
        if (subject.equals("STOP")){
            loop =false;
        }else {
            driver.findElement(By.id("subjectsInput")).sendKeys(subject + " ");
        }
    }

    System.out.println("Unesite hobi: ");
    String hobbies = s.next();
    if (hobbies.equals("sport")){
        driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']")).click();
    } if (hobbies.equals("reading")) {
        driver.findElement(By.id("//label[@for='hobbies-checkbox-2']")).click();
    } if (hobbies.equals("music")) {
        driver.findElement(By.id("//label[@for='hobbies-checkbox-3']")).click();
    }

//    System.out.println("Želite li da ubacite sliku? (true/false)");
//    boolean image = s.nextBoolean();
//    if (image){
//        driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\Sava\\Desktop\\PROJEKTI\\selenium_osnove\\src\\main\\java\\d26_09_2023\\image.png");
//    }


    System.out.print("Unesite trenutnu adresu: ");
    driver.findElement(By.id("currentAddress")).sendKeys(s.next());


    driver.findElement(By.id("submit")).click();

}
}
