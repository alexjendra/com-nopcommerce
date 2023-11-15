package project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;


public class MultiBrowser {

    static String browser="Chrome";
    static String baseUrl="https://demo.nopcommerce.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        String baseUrl = "https://demo.nopcommerce.com/";
        //1. setup Chrome browser
        WebDriver driver = new ChromeDriver();
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name ");
        }

        //2.Open Url
        driver.get(baseUrl);
        driver.manage().window().maximize();  //Maximize the window
        //Give implicit wait to Driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //3.Get the Title of the page
        String title = driver.getTitle();
        System.out.println("page title is " + title);

        //4. Get the current Url
        String url = driver.getCurrentUrl();
        System.out.println("Current Url " + url);

        //5. Get the page source
        String pageSource = driver.getPageSource();
        System.out.println("Page Source  : " + pageSource);
        driver.navigate().back();   //6. Navigate to Url
        driver.navigate().refresh();  //7. Print the current Url
        driver.navigate().forward();
        System.out.println("get current url " + driver.getCurrentUrl());
        //Find the Email field Element
        WebElement emailField = driver.findElement(By.id("Email"));
        //Enter the Email Field
        emailField.sendKeys("khushi123@gmail.com");
        //Enter the password field
        driver.findElement(By.name("password")).sendKeys("abc123");
        //Wait for 10 Seconds
        Thread.sleep(10000);
        //Close the browser
        driver.quit();


    }

    }

