package Tests;

import Pages.HomePage;
import Pages.ProductPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class SeleniumTest {

    public static WebDriver driver;
    static ExtentReports report;
    public static ExtentTest test;
    static ExtentReports extent =new ExtentReports();


    @BeforeSuite
    public  static void setup() throws InterruptedException {
        driver= new ChromeDriver();
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
        ExtentSparkReporter spark = new ExtentSparkReporter("target/spark.html");
        extent.attachReporter(spark);
        HomePage.clickMenu();
        HomePage.clickProducts();

    }

    public static String capture(WebDriver driver) throws IOException {
        File srcfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File Dest=new File("target/ss/"+System.currentTimeMillis()+".png");
        String errflpath=Dest.getAbsolutePath();
        FileUtils.copyFile(srcfile,Dest);
        return errflpath;

    }

    @Test
    void validate_onlineproducts() {
        test=extent.createTest("validate Shoe Titles on product page","this validates show types are correct");
        ProductPage.formalShoesTitle();
        ProductPage.sportsShoesTitle();
        ProductPage.sneakersShoesTitle();
        extent.flush();
    }

    @Test

    void validateformalFirstname() throws IOException {
        test=extent.createTest("formal shoe","this validates formal shoe types are correct");
        ProductPage.formalShoesFirstname();
    }
    @Test
    void validateSportsFirstname() {
        test=extent.createTest("sports shoe","this validates sports shoe types are correct");
        ProductPage.sportsShoesFirstname();
    }
    @Test
    void validateSneakersFirstname() {
        test=extent.createTest("sneakers shoe","this validates sneakers shoe types are correct");
        ProductPage.sneakersShoesFirstname();
    }

    @AfterSuite
    public  static  void   cleanup(){
        extent.flush();
    }

}


