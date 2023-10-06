package p03_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class UvodUTestNG {
    @BeforeClass
    public void beforeClass(){
        System.out.println("before class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("after class");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("before");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("after");
    }

    @Test
    public void googleTitleTest() {
        System.out.println("google title test");
    }

    @Test
    public void googleSearchTest() {
        System.out.println("google search test");
    }
}
