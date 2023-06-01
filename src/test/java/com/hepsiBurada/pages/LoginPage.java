package com.hepsiBurada.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//div[.='Giriş yap']")
    public WebElement giris_uyeOl;

    @FindBy(id = "txtUserName")
    public WebElement emailBox;

    @FindBy(id = "btnLogin")
    public WebElement enterEmail;

    @FindBy(xpath = "//input[@placeholder='Şifre']")
    public WebElement passwordBox;

    @FindBy(id = "btnEmailSelect")
    public WebElement enterPassword;

}
