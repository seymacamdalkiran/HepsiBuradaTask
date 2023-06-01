package com.hepsiBurada.tests;

import com.hepsiBurada.pages.LoginPage;
import com.hepsiBurada.utilities.ConfigurationReader;
import com.hepsiBurada.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class ChooseSamsung extends TestBase{
    LoginPage loginPage=new LoginPage();

    @Test
    public void test1() throws InterruptedException {
        extentLogger= report.createTest("Samsung Test");

        extentLogger.info("Go to the url");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("close the popup");
        loginPage.cookieAccept.click();

        extentLogger.info("Click on the login button");
        webDriverWait.until(ExpectedConditions.visibilityOf(loginPage.girisYapVeyaUyeOl));
        actions.moveToElement(loginPage.girisYapVeyaUyeOl);
        loginPage.girisYapVeyaUyeOl.click();
        loginPage.girisYap.click();

        extentLogger.info("Choose 'Giris yap' section");
        loginPage.giris_uyeOl.click();

        extentLogger.info("Write a valid email");
        loginPage.emailBox.sendKeys("ustunertas13@gmail.com");

        extentLogger.info("Click on the giris button");
        loginPage.enterEmail.click();

        extentLogger.info("Write a valid password");
        loginPage.passwordBox.sendKeys("Test1234");

        extentLogger.info("Click on the giris button");
        loginPage.enterPassword.click();

        extentLogger.info("");
        extentLogger.info("");


    }
}
