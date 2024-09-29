package Pages;

import org.openqa.selenium.By;

import static Tests.SeleniumTest.driver;

public class HomePage {

    public static String menuXpath= "//input[@type='checkbox']";

    public static String onlineProducts="//li[text()='Online Products']";

   public static void clickMenu() {
        driver.findElement(By.xpath(menuXpath)).click();
   }

   public static void clickProducts() throws InterruptedException {
       Thread.sleep(2000);
       driver.findElement(By.xpath(onlineProducts)).click();

   }
}


