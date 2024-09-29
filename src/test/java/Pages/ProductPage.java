package Pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

import static Tests.SeleniumTest.*;

public class ProductPage {

    public static String formalShoesXpath = " //h2[text()='Formal Shoes']";
    public static String sportsShoesXpath = "//h2[text()='Sports Shoes']";
    public static String sneakersXpath = "//h2[text()='Sneakers']";

    public static String formalshoesdropdown = "//i[@class='fa fa-angle-double-down formalshoedropdown']";
    public static String formalshoesname = "//body[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]";

    public static String sportsshoesdropdown = "//i[@class='fa fa-angle-double-down sportsshoedropdown']";
    public static String sportsshoesname = "//body[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]";

    public static String sneakersshoesdropdown = "//i[@class='fa fa-angle-double-down sneakershoedropdown']";
    public static String sneakersshoesname = "//body[1]/div[4]/table[1]/tbody[1]/tr[1]/td[1]";


    public static void formalShoesTitle() {
        String expectedTitle = "Formal Shoes";
        String actualTitle = driver.findElement(By.xpath(formalShoesXpath)).getText();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    public static void sportsShoesTitle() {
        String expectedTitle = "Sports Shoes";
        String actualTitle = driver.findElement(By.xpath(sportsShoesXpath)).getText();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    public static void sneakersShoesTitle() {
        String expectedTitle = "Sneakers";
        String actualTitle = driver.findElement(By.xpath(sneakersXpath)).getText();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    public static void formalShoesFirstname() throws IOException {
        String expectedFormalname = "Classic Cheltenham";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(formalshoesdropdown)));
        driver.findElement(By.xpath(formalshoesdropdown)).click();
        String actualFormalname = driver.findElement(By.xpath(formalshoesname)).getText().trim();
        Assert.assertEquals(expectedFormalname, actualFormalname);
        if (expectedFormalname.equals(actualFormalname)) {
            test.log(Status.PASS, "Title verifed for formal shoes");
            test.log(Status.PASS,test.addScreenCaptureFromPath(capture(driver))+"Test Passed");
        }else{
            test.log(Status.FAIL,"Test failed");
        }

    }

    public static void sportsShoesFirstname() {
        String expectedsportsname = "Ultimate";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sportsshoesdropdown)));
        driver.findElement(By.xpath(sportsshoesdropdown)).click();
        String actualsportsname = driver.findElement(By.xpath(sportsshoesname)).getText().trim();
        Assert.assertEquals(expectedsportsname, actualsportsname);
        if (expectedsportsname.equals(actualsportsname)) {
            test.log(Status.PASS, "Title verifed for sports shoes");
        }else{
            test.log(Status.FAIL,"Test failed");
        }

    }

    public static void sneakersShoesFirstname() {
        String expectedSneakersname = "Archivo";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sneakersshoesdropdown)));
        driver.findElement(By.xpath(sneakersshoesdropdown)).click();
        String actualSneakersname = driver.findElement(By.xpath(sneakersshoesname)).getText().trim();
        Assert.assertEquals(expectedSneakersname, actualSneakersname);
        if (expectedSneakersname.equals(actualSneakersname)) {
            test.log(Status.PASS, "Title verifed for Sneakers shoes");
        }
        else{
            test.log(Status.FAIL,"Test failed");
        }
            }

        }



