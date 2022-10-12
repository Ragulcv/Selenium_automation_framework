package com.freshflows.tests;

import com.freshflows.objects.Userdata;
import com.freshflows.pages.LoginPage;
import com.freshflows.base.BaseTest;
import com.freshflows.utils.JacksonUtils;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.io.IOException;

public class FirstTestCase extends BaseTest {

    @Description("login functionality ")
    @Test(description = "existing users should login into freshflows")
    public void LoginTest() throws  IOException {
        Userdata userdata = JacksonUtils.deserializeJson("logindetails.json", Userdata.class);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithCreds();
        System.out.println("successfully invoked the method");
    }
}
