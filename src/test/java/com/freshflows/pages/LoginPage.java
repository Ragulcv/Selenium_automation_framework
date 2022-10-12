package com.freshflows.pages;

import com.freshflows.base.BasePage;
import com.freshflows.utils.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By txtmail = By.xpath("//input[@name='email']");
    private final By txtpwd = By.xpath("//input[@name='password']");
    private final By loginbtn = By.xpath("//button[@type='submit']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void load() {
        load("/");
    }

    public void loginWithCreds(){
        driver.get(ConfigLoader.getInstance().getbaseUrl());
        driver.findElement(txtmail).sendKeys(ConfigLoader.getInstance().getadminUser());
        driver.findElement(txtpwd).sendKeys(ConfigLoader.getInstance().getadminPwd());
        driver.findElement(loginbtn).click();
    }
}
