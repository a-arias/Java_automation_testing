package com.arias;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class MyClassTest {

    @Test
    public void VerifiedGoogleSearch() {
        File file = new File("C://Program Files (x86)/JetBrains/ChromeDriver/chromedriver.exe");
        /*WebDriver driver = new FirefoxDriver();*/
        //Se sustituyo el Driver de FireFox.
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.co.in/");

        WebElement googleInput = driver.findElement(By.id("lst-ib"));
        googleInput.sendKeys("cats");

        WebElement buttonSearch = driver.findElement(By.name("btnG"));
        buttonSearch.click();

        if(driver.getPageSource().contains("siamese")){
            System.out.print("Yes, there was seamese text on the search.");
            WebElement searchTime = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));
            Boolean strSearchTime = searchTime.isDisplayed();
            Assert.assertTrue(strSearchTime);
            driver.close();
        }
        else{
            System.out.print("There was no seamese cat text");
/*
            buttonSearch = driver.querySelector('[aria-label="Message Body"]');
*/
        driver.close();
        }
    }
}

