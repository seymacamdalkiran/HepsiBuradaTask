package com.hepsiBurada.tests;

import com.hepsiBurada.pages.LoginPage;
import com.hepsiBurada.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class HepsiBuradaTest extends TestBase{
    LoginPage loginPage=new LoginPage();

    @Test
    public void test1() throws InterruptedException {
        extentLogger= report.createTest("Samsung Test");

        extentLogger.info("Go to the url");
        driver.get(ConfigurationReader.get("url1"));

        extentLogger.info("close the popup");
        loginPage.cookieAccept.click();

        extentLogger.info("Click on the login button");
        webDriverWait.until(ExpectedConditions.visibilityOf(loginPage.girisYapVeyaUyeOl));
        actions.moveToElement(loginPage.girisYapVeyaUyeOl).perform();
      //  loginPage.girisYapVeyaUyeOl.click();
        loginPage.girisYap.click();

        extentLogger.info("Choose 'Giris yap' section");
        loginPage.giris_uyeOl.click();

        extentLogger.info("Write a valid email");
        loginPage.emailBox.sendKeys(ConfigurationReader.get("email1"));

        extentLogger.info("Click on the giris button");
        loginPage.enterEmail.click();

        extentLogger.info("Write a valid password");
        loginPage.passwordBox.sendKeys(ConfigurationReader.get("password1"));

        extentLogger.info("Click on the giris button");
        loginPage.enterPassword.click();


    }
}
