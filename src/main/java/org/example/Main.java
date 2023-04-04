package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
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


        AddDeleteUser adu = new AddDeleteUser(driver);
        adu.addDelUser(driver);

    }
}