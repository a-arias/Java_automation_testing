package com.arias;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MyClassTest {

    @Test
    public void VerifiedGoogleSearch() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.co.in/");

        WebElement googleInput = driver.findElement(By.id("lst-ib"));
        googleInput.sendKeys("cats");

        WebElement buttonSearch = driver.findElement(By.name("btnG"));
        buttonSearch.click();

        WebElement searchTime = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));
        Boolean strSearchTime = searchTime.isDisplayed();
        Assert.assertTrue(strSearchTime);
        driver.close();
    }
}
