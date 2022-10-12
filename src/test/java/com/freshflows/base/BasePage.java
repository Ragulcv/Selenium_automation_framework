package com.freshflows.base;

import com.freshflows.utils.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    private WebElement element;
    public WebDriver driver;

    public BasePage(WebDriver driver){

        this.driver = driver;
    }

    public void load(String endPoint) {
        driver.get(ConfigLoader.getInstance().getbaseUrl() + endPoint);
    }


}
