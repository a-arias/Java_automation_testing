package com.arias;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;

public class SimpleTest {
    @Test
    public void testSomething(){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.co.in/");
        driver.manage().window().maximize();
        String str = driver.getCurrentUrl();
        System.out.println("The current URL is " + str);

    }

}
