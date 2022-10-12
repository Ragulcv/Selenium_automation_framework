package com.freshflows.factory;

import com.freshflows.constants.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

   public WebDriver initializeDriver(String browser){
       WebDriver driver;
       switch (DriverType.valueOf(browser)) {
           case CHROME -> {
               WebDriverManager.chromedriver().cachePath("Drivers").setup();
               driver = new ChromeDriver();
           }
           case FIREFOX -> {
               WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
               driver = new ChromeDriver();
           }
           default -> throw new IllegalStateException("Invalid browser name:" + browser);
       }
       driver.manage().window().maximize();
       return driver;
   }











}
