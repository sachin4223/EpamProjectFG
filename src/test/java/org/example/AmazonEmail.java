package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class AmazonEmail {
    ChromeDriver driver = new ChromeDriver();
    @BeforeClass
    void setup()
    {

        WebDriverManager.chromedriver().setup();
        driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F%26ext_vrnc%3Dhi%26tag%3Dgooghydrabk1-21%26ref%3Dnav_signin%26adgrpid%3D58355126069%26hvpone%3D%26hvptwo%3D%26hvadid%3D610644601173%26hvpos%3D%26hvnetw%3Dg%26hvrand%3D14856131913356457293%26hvqmt%3De%26hvdev%3Dc%26hvdvcmdl%3D%26hvlocint%3D%26hvlocphy%3D9144064%26hvtargid%3Dkwd-10573980%26hydadcr%3D14453_2316415&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");

        driver.manage().window().maximize();
    }
    @Test
    public void getTitleFromPage() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("str.life.satyam@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("Str@1516");
        driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();

        Thread.sleep(15000);
        ////////HOVER////////
        WebElement ele = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span"));
        //Creating object of an Actions class
        Actions action = new Actions(driver);

        //Performing the mouse hover action on the target element.
        action.moveToElement(ele).perform();
///////////////////////////////////////////////////////////////////////
        /// CREATING WISHLIST
        driver.findElement(By.xpath("//span[normalize-space()='Create a Wish List']")).click();
        Thread.sleep(8000);
        driver.findElement(By.xpath("//input[@aria-labelledby='createList-announce']")).click();
        Thread.sleep(8000);

        driver.findElement(By.xpath("//input[@id='list-name']")).clear();
        Thread.sleep(8000);

        driver.findElement(By.xpath("//input[@id='list-name']")).sendKeys("My WishList");
        Thread.sleep(8000);
        driver.findElement(By.xpath("//*[@id=\"wl-redesigned-create-list\"]/span/span/input")).click();
        Thread.sleep(8000);
        // WISHLIST NAME EDIT
//        driver.findElement(By.xpath("//div[@class='aok-inline-block aok-align-center'][normalize-space()='More']")).click();
//        driver.findElement(By.xpath("//a[@id='editYourList']")).click();
//
//        Thread.sleep(5000);
//
//        driver.findElement(By.xpath("//input[@id='list-settings-name']")).clear();
//        Thread.sleep(8000);
//        driver.findElement(By.xpath("//input[@id='list-name']")).sendKeys("My WishList 1");
//        Thread.sleep(8000);


        //// ITEM SEARCH CLICK
        Thread.sleep(4000);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("DEATH: AN INSIDE STORY");

                Thread.sleep(10000);
        driver.findElement(By.cssSelector("#nav-search-submit-button")).click();
        Thread.sleep(10000);

        /// ITEM CLICK
        // commented out below line because due ads unable yo click the desired link
        //driver.findElement(By.cssSelector("div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1'] h2[class='a-size-mini a-spacing-none a-color-base s-line-clamp-2'] span:nth-child(4)")).click();
        Thread.sleep(8000);
        String parent=driver.getWindowHandle();

        Set<String> s=driver.getWindowHandles();

        // Now iterate using Iterator
        Iterator<String> I1= s.iterator();

        while(I1.hasNext()) {

            String child_window = I1.next();


            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);

                System.out.println(driver.switchTo().window(child_window).getTitle());
                driver.findElement(By.name("submit.add-to-registry.wishlist")).click();

                Thread.sleep(6000);
                driver.findElement(By.xpath("//*[@id=\"continue-shopping\"]/span/span/input")).click();
                driver.close();

            }
            driver.switchTo().window(parent);
        }
/// AFTER ADD TO WISHLIST SECTION
        WebElement ele1 = driver.findElement(By.xpath("//span[normalize-space()='Account & Lists']"));
        Actions action1 = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action1.moveToElement(ele1).perform();
        Thread.sleep(8000);
        driver.findElement(By.xpath("//span[normalize-space()='My WishList']")).click();
        Thread.sleep(8000);

  //// DELETE ITEM FROM WISHLIST
        driver.findElement(By.xpath("//input[@name='submit.deleteItem']")).click();
  ///// DELETE WISHLIST
        driver.findElement(By.xpath("//div[@class='aok-inline-block aok-align-center'][normalize-space()='More']")).click();
        driver.findElement(By.xpath("//a[@id='editYourList']")).click();
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0,360)");
        driver.findElement(By.cssSelector("span[class='a-button a-spacing-base a-button-base full-width-element a-button-focus'] input[type='submit']")).click();
        // above line failed because we scroll down the page but we need to scroll the pop upi.e the wishlist popup.

    }
}
