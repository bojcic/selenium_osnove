package p05_10_2023;

import d02_10_2023.Helper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class SwabLabsTests {
    private WebDriver driver;
    private WebDriverWait wait;
    private String username;
    private String password;
    private String baseUrl = "https://www.saucedemo.com/";



    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void beforeEach() {
        driver.navigate().to(baseUrl);
        username = "standard_user";
        password = "secret_sauce";

    }

    @Test(priority = 1, retryAnalyzer = SwabLabsRetry.class)
    public void verifyErrorIsDisplayedWhenUsernameIsMissing() {
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "Epic sadface: Username is required",
                "Error: Required message not displayed");
    }

    @Test(priority = 2, retryAnalyzer = SwabLabsRetry.class)
    public void verifyErrorIsDisplayedWhenPasswordIsMissing() {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "Epic sadface: Password is required",
                "Error: Required message not displayed");

    }

    @Test(priority = 3, retryAnalyzer = SwabLabsRetry.class)
    public void verifyErrorIsDisplayedWhenCredentialsAreWrong() {
        password = "invalidpassword";

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "Epic sadface: Username and password do not match any user in this service",
                "Error: Required message not displayed");
    }

    @Test(priority = 4, retryAnalyzer = SwabLabsRetry.class)
    public void verifyErrorIsDisplayedWhenUserIsLocked() {
        username = "locked_out_user";

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "Epic sadface: Sorry, this user has been locked out.",
                "Error: Required message not displayed");

    }

    @Test(priority = 5, retryAnalyzer = SwabLabsRetry.class)
    public void verifySuccessfulLogin() {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "inventory.html", "Error: Page not loaded");
//        wait
//                .withMessage("Error: Page not loaded")
//                .until(ExpectedConditions.urlContains("/inventory.html"));
        driver.findElement(By.id("react-burger-menu-btn")).click();

        wait
                .withMessage("Error: Dropdown menu did not display")
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("bm-menu")));
        boolean logoutExists = !driver.findElements(By.id("logout_sidebar_link")).isEmpty();
        Assert.assertTrue(logoutExists, "Error: Logout button not displayed");
//        wait
//                .withMessage("Error: Logout button not displayed")
//                .until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));

        driver.findElement(By.id("logout_sidebar_link")).click();

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl,
                "Error: Did not redirect to Login page");
    }

    @Test(priority = 6, retryAnalyzer = SwabLabsRetry.class)
    public void addingProductsToCart() {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        wait
                .withMessage("Error: Page not loaded")
                .until(ExpectedConditions.urlContains("/inventory.html"));

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        wait
                .withMessage("Error: Remove button did not display")
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("remove-sauce-labs-backpack")));

        Assert
                .assertEquals(driver.findElement(By.className("shopping_cart_badge")).getText(), "1",
                        "Error: Added product not displayed in shopping cart");
    }

    @Test(priority = 7, retryAnalyzer = SwabLabsRetry.class)
    public void viewingProductDetails() {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        wait
                .withMessage("Error: Page not loaded")
                .until(ExpectedConditions.urlContains("/inventory.html"));
    }

    @Test(priority = 8, retryAnalyzer = SwabLabsRetry.class)
    public void removingProductsFromCart() {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        wait
                .withMessage("Error: Page not loaded")
                .until(ExpectedConditions.urlContains("/inventory.html"));

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        wait
                .withMessage("Error: Remove button did not display")
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("remove-sauce-labs-backpack")));

        Assert
                .assertEquals(driver.findElement(By.className("shopping_cart_badge")).getText(), "1",
                        "Error: Added product not displayed in shopping cart");

        driver.findElement(By.id("shopping_cart_container")).click();


        Assert.assertEquals(driver.findElement(By.className("inventory_item_name")).getText(), "Sauce Labs Backpack",
                "Error: Sauce Labs Backpack not in cart");

        driver.findElement(By.id("remove-sauce-labs-backpack")).click();

        List<WebElement> items = driver.findElements(By.cssSelector(".cart_list .cart_item"));
        Assert.assertTrue(items.isEmpty(), "Error: Item not displayed");


    }

    @Test(priority = 9, retryAnalyzer = SwabLabsRetry.class)
    public void productCheckout() {
        String checkoutName = "Pera";
        String checkoutLastName = "Peric";
        String checkoutZip = "18000";

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        wait
                .withMessage("Error: Page not loaded")
                .until(ExpectedConditions.urlContains("/inventory.html"));

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        wait
                .withMessage("Error: Remove button did not display")
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("remove-sauce-labs-backpack")));

        Assert
                .assertEquals(driver.findElement(By.className("shopping_cart_badge")).getText(), "1",
                        "Error: Added product not displayed in shopping cart");

        driver.findElement(By.id("shopping_cart_container")).click();

        Assert.assertEquals(driver.findElement(By.className("inventory_item_name")).getText(), "Sauce Labs Backpack",
                "Error: Sauce Labs Backpack not in cart");

        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.name("firstName")).sendKeys(checkoutName);
        driver.findElement(By.name("lastName")).sendKeys(checkoutLastName);
        driver.findElement(By.name("postalCode")).sendKeys(checkoutZip);

        driver.findElement(By.id("continue")).click();

        Assert.assertEquals(driver.findElement(By.className("inventory_item_name")).getText(), "Sauce Labs Backpack",
                "Error: Item is not correct");
        Assert.assertEquals(driver.findElement(By.className("inventory_item_desc")).getText(), "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.",
                "Error: Item is not correct");

        Assert.assertEquals(driver.findElement(By.className("cart_quantity")).getText(), "1",
                "Error: Item is not correct");

        Assert.assertEquals(driver.findElement(By.className("inventory_item_price")).getText(), "$29.99",
                "Error: Item is not correct");


        driver.findElement(By.id("finish")).click();

        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(), "Thank you for your order!",
                "Error: Message not correct");

    }

    @Test(priority = 10)
    public void validateSocialLinksInFooter() throws InterruptedException, IOException {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        wait
                .withMessage("Error: Page not loaded")
                .until(ExpectedConditions.urlContains("/inventory.html"));

        new Actions(driver)
                .scrollToElement(driver.findElement(By.className("footer")))
                .perform();

        List<WebElement> socialLinks = driver.findElements(By.cssSelector(".social a"));

        for (WebElement socialLink : socialLinks) {
            Assert.assertEquals(
                    Helper.getHTTPResponseStatusCode(socialLink.getAttribute("href")),
                    200,
                    "Error: Response Status Code should be 200");
        }

        }



        @AfterMethod
        public void afterEvery() {
            ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
            driver.manage().deleteAllCookies();
        }

        @AfterClass
        public void endTest () {
            driver.quit();
        }
    }

