package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WithoutIdPass {
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
        driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
    }
}
