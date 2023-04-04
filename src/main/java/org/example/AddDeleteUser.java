package org.example;

//import org.apache.log4j.BasicConfigurator;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.swing.*;
import java.time.Duration;

public class AddDeleteUser {
    public AddDeleteUser(WebDriver driver) {
        String org = "DROUGAS";
        String orgUsername = "MDrougas";
        String orgPassword = "medeco#1";
        String errorMessage;
        //This will log into the main site
        driver.get("http://xtwlegacy.eedeco.com");
        String title = driver.getTitle();
        System.out.println(title);
        System.out.println("driver.getCurrentUrl()");
        driver.findElement(By.id("Organization")).sendKeys(org);
        driver.findElement(By.id("UserName")).sendKeys(orgUsername);
        driver.findElement(By.id("Password")).sendKeys("Wrong!");
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/form[2]/div/fieldset/p[1]/input")).click();
        errorMessage = driver.findElement(By.xpath(
                "/html/body/div[1]/div[2]/form[2]/div[1]")).getText();
        if (!(errorMessage.equalsIgnoreCase("Login was unsuccessful. Please correct the " +
                "errors and try again.\n" +
                "The login information provided is incorrect."))) {
            driver.quit();
            System.out.println("Error message not displayed");
        }
        else {
            System.out.println("Error message displayed correctly");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //wait two seconds before running next step
        //Will fail if error message not found
        if (!(driver.findElement(By.xpath("/html/body/div[1]/div[2]/form[2]/div[1]")).isDisplayed()))
        {
            driver.quit();
        }
        driver.findElement(By.id("Password")).sendKeys(orgPassword);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/form[2]/div/fieldset/p[1]/input")).click();

    }

    public static void main(String[] args) throws InterruptedException {


    }
    public void addDelUser(WebDriver driver) {


        String userFirstName = "AAASelenium";
        String userLastName = "Test";
        String userID = "AAATestUser";
        String userTitle = "SeleniumTest";
        String userWorkPhone = "555-555-5555";
        String userHomePhone = "111-111-1111";
        String userMobilePhone = "222-222-2222";
        String userEmail = "SeleniumTestCase@gmail.com";
        String username = "AATester";
        String userPassword = "medeco#2";
        String userPIN = "2314";
        String userKeySerialNumber = "000-559-876";




        //Main menu & select "Users" tab
        driver.findElement(By.cssSelector("li.users > a:nth-child(1)")).click();

        //create new user
        driver.findElement(By.cssSelector("div.inline-left:nth-child(3) > div:nth-child(1) > div:nth-child(1) > " +
                "p:nth-child(1) > a:nth-child(1)")).click();
        driver.findElement(By.cssSelector("#FirstName")).sendKeys(userFirstName);
        driver.findElement(By.cssSelector("#Context_LastName")).sendKeys(userLastName);
        driver.findElement(By.cssSelector("#Context_UserId")).sendKeys(userID);
        driver.findElement(By.cssSelector("#Context_Title")).sendKeys(userTitle);
        driver.findElement(By.cssSelector("#Context_WorkPhone")).sendKeys(userWorkPhone);
        driver.findElement(By.cssSelector("#Context_HomePhone")).sendKeys(userHomePhone);
        driver.findElement(By.cssSelector("#Context_MobilePhone")).sendKeys(userMobilePhone);
        driver.findElement(By.id("Context_EmailAddress")).sendKeys(userEmail);
        //This is where the timezone starts...Will need to cycle through these
        driver.findElement(By.cssSelector("#Timezone > option:nth-child(1)")).click();
        driver.findElement(By.cssSelector("#UserClass > option:nth-child(2)")).sendKeys(username);
        driver.findElement(By.cssSelector("#Context_Password")).sendKeys(userPassword);
        driver.findElement(By.cssSelector("#UsePin")).click();
        driver.findElement(By.cssSelector("#PinValue")).sendKeys(userPIN);
        driver.findElement(By.cssSelector("#Context_KeySerialNumber")).sendKeys(userKeySerialNumber);
        driver.findElement(By.cssSelector(".btn")).click();
        driver.findElement(By.cssSelector(".dataTables_scrollHeadInner > table:nth-child(1) > thead:nth-child(1) > " +
                        "tr:nth-child(1) > th:nth-child(1) > span:nth-child(1) > input:nth-child(1)"))
                .sendKeys(userFirstName + " " + userLastName);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div[3]/div[2]/div[4]/div[2]/table" +
                "/tbody/tr/td[5]/form/button")).click();
        Alert alertOK = driver.switchTo().alert();
        alertOK.accept();

        JOptionPane.showConfirmDialog(null, "Please service key " + userKeySerialNumber + "" +
                " in XT Key Client, then press OK", "Warning", JOptionPane.DEFAULT_OPTION);

        driver.findElement(By.cssSelector(".audits > a:nth-child(1)")).click();

        if (driver.findElement(By.cssSelector(".dataTables_scrollHeadInner > table:nth-child(1) > " +
                "thead:nth-child(1) > tr:nth-child(2) > th:nth-child(1)")).isDisplayed()){
            driver.findElement(By.cssSelector("html body.audits div.page div#main div#table_wrapper" +
                    ".dataTables_wrapper " +
                    "div.dataTables_scroll div.dataTables_scrollHead div.dataTables_scrollHeadInner table.display" +
                    ".dataTable thead tr.table-header th.sorting_desc")).click();
        }









    }

    public void sharedSchedule(WebDriver driver) {

    }



}
