package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Zadatak2 {
//    Niz todo-a (niz stringova) koje treba da uneti. Niz je:
//    Visit Paris
//    Visit Prague
//    Visit London
//    Visit New York
//    Visit Belgrade
//    Maksimizirati prozor
//    Ucitati stranicu https://example.cypress.io/todo
//    Program petljom prolazi kroz niz todo-a i svaki unosi na stranicu
//    Nakon svakog unosa todo-a, unosi se enter. Koristan link
//    Nakon svih unosa proci petljom kroz svaki todo koji je na stranici i za svaki cekirati da je completed.
//    Cekanje od 5s
//    Zatvorite pretrazivac
public static void main(String[] args) throws InterruptedException {
    ArrayList<String> todos = new ArrayList<>();
    todos.add("Visit Paris");
    todos.add("Visit Prague");
    todos.add("Visit London");
    todos.add("Visit New York");
    todos.add("Visit Belgrade");
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://example.cypress.io/todo");
    for (int i = 0; i < todos.size(); i++) {
        driver.findElement(By.cssSelector(".new-todo")).clear();
        driver.findElement(By.cssSelector(".new-todo")).sendKeys(todos.get(i));
        driver.findElement(By.cssSelector(".new-todo")).sendKeys(Keys.ENTER);
    }

    List<WebElement> tasks = driver.findElements(By.cssSelector(".todo-list li input"));
    for (int i = 0; i < tasks.size(); i++) {
        tasks.get(i).click();
    }
    Thread.sleep(5000);
    driver.quit();
}

}
