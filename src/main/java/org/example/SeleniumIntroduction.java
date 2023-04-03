package org.example;

//import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class SeleniumIntroduction {
    public static void main(String[] args) throws InterruptedException {


        //BasicConfigurator.configure();//required for log4j to work

        //invoke browser (Firefox)
        System.setProperty("webdriver.gecko.driver" ,
                "C:/Users/micdro/OneDrive/Programming/AutomatedTesting/drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        //Invoke Chrome
        System.setProperty("webdriver.chrome.driver" ,
                "C:/Users/micdro/OneDrive/Programming/AutomatedTesting/drivers/chromedriver.exe");
        //WebDriver driver1 = new ChromeDriver();

        //Microsoft Edge
        System.setProperty("webdriver.edge.driver" ,
                "C:/Users/micdro/OneDrive/Programming/AutomatedTesting/drivers/msedgedriver.exe");
        //WebDriver driver2 = new EdgeDriver();

        driver.get("http://xtwlegacy.eedeco.com");
        String title = driver.getTitle();

        //This will log into the main site
        System.out.println(title);
        System.out.println("driver.getCurrentUrl()");
        driver.findElement(By.id("Organization")).sendKeys("DROUGAS");
        driver.findElement(By.id("UserName")).sendKeys("mdrougas");
        driver.findElement(By.id("Password")).sendKeys("medeco#");
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/form[2]/div/fieldset/p[1]/input")).click();
        System.out.println("\n\n\n\nHELLO");
        System.out.println(driver.findElement(By.xpath(
                "/html/body/div[1]/div[2]/form[2]/div[1]")).getText());
        System.out.println("\n\n\n\nHELLO");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); //wait two seconds before running next step
        //Will fail if error message not found
        if (!(driver.findElement(By.xpath("/html/body/div[1]/div[2]/form[2]/div[1]")).isDisplayed()))
        {
            driver.quit();
        }
        driver.findElement(By.id("Password")).sendKeys("medeco#1");

        //Main menu & select "Users" tab
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/form[2]/div/fieldset/p[1]/input")).click();
        driver.findElement(By.cssSelector("li.users > a:nth-child(1)")).click();

        //create new user
        driver.findElement(By.cssSelector("div.inline-left:nth-child(3) > div:nth-child(1) > div:nth-child(1) > " +
                "p:nth-child(1) > a:nth-child(1)")).click();
        driver.findElement(By.cssSelector("#FirstName")).sendKeys("AAASelenium");
        driver.findElement(By.cssSelector("#Context_LastName")).sendKeys("Test");
        driver.findElement(By.cssSelector("#Context_UserId")).sendKeys("AAATestUser");
        driver.findElement(By.cssSelector("#Context_Title")).sendKeys("SeleniumTest");
        driver.findElement(By.cssSelector("#Context_WorkPhone")).sendKeys("555-555-5555");
        driver.findElement(By.cssSelector("#Context_MobilePhone")).sendKeys("111-111-1111");
        driver.findElement(By.id("Context_EmailAddress")).sendKeys("SeleniumTestCase@gmail.com");
        //This is where the timezone starts...Will need to cycle through these
        driver.findElement(By.cssSelector("#Timezone > option:nth-child(1)")).click();
        //driver.findElement(By.cssSelector("#Timezone > option:nth-child(2)")).click();





    }
}
