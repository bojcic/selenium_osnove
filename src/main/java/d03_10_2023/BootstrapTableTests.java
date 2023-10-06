package d03_10_2023;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import p02_10_2023.Helper;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class BootstrapTableTests {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl = "https://s.bootsnipp.com/iframe/K5yrx";
    private String firstName = "Vladimir";
    private String lastName = "Bojčić";
    private String middleName = "Milan";

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @BeforeMethod
    public void beforeMethod(){
        driver.manage().deleteAllCookies();
        driver.navigate().to(baseUrl);
    }

    @Test
    public void editRow(){
        Assert.assertEquals(driver.getTitle(),"Table with Edit and Update Data - Bootsnipp.com",
                        "Error: Not on the correct page");

        driver.findElement(By.cssSelector("tr#d1 td:nth-child(5) button")).click();

        wait
                .withMessage("Error: Edit dialogue not displayed")
                .until(ExpectedConditions.attributeToBe(By.cssSelector("div#edit"),"aria-hidden","false"));

        driver.findElement(By.cssSelector("input#fn")).clear();
        driver.findElement(By.cssSelector("input#fn")).sendKeys(firstName);

        driver.findElement(By.cssSelector("input#ln")).clear();
        driver.findElement(By.cssSelector("input#ln")).sendKeys(lastName);

        driver.findElement(By.cssSelector("input#mn")).clear();
        driver.findElement(By.cssSelector("input#mn")).sendKeys(middleName);

        driver.findElement(By.cssSelector("button#up")).click();

        wait
                .withMessage("Error: Edit dialogue did not disappear")
                .until(ExpectedConditions.attributeToBe(By.cssSelector("div#edit"),"aria-hidden","true"));

        String updatedFirstName =driver.findElement(By.id("f1")).getText();
        String updatedLastName =driver.findElement(By.id("l1")).getText();
        String updatedMiddleName =driver.findElement(By.id("m1")).getText();

        Assert.assertEquals(updatedFirstName,firstName,
                "Error: First name not correct");
        Assert.assertEquals(updatedLastName,lastName,
                "Error: Last name not correct");
        Assert.assertEquals(updatedMiddleName,middleName,
                "Error: Middle name not correct");

    }

    @Test
    public void deleteRow(){
        Assert.assertEquals(driver.getTitle(),"Table with Edit and Update Data - Bootsnipp.com",
                        "Error: Not on the correct page");

        List<WebElement> elementsStart = driver.findElements(By.cssSelector("tbody tr"));

        driver.findElement(By.cssSelector("tr#d1 td:last-child>button")).click();

        wait
                .withMessage("Error: Delete dialogue not displayed")
                .until(ExpectedConditions.attributeToBe(By.cssSelector("div#delete"),"aria-hidden","false"));

        driver.findElement(By.cssSelector("button#del")).click();

        wait
                .withMessage("Error: Delete dialogue did not disappear")
                .until(ExpectedConditions.attributeToBe(By.cssSelector("div#delete"),"aria-hidden","true"));


        boolean deletedRow = driver.findElements(By.cssSelector("tr#d1 td")).isEmpty();

        Assert.assertTrue(deletedRow,"Error: Deletetion failed");
    }

    @Test
    public void takeAScreenshot() throws IOException {
        Assert.assertEquals(driver.getTitle(),"Table with Edit and Update Data - Bootsnipp.com",
                "Error: Not on the correct page");
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot,new File("screenshots/slike.png"));
    }

    @AfterClass
    public void endTest(){
        driver.quit();
    }

}
