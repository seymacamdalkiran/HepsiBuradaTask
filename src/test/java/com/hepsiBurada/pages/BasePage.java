package com.hepsiBurada.pages;

import com.hepsiBurada.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "myAccount")
    public WebElement girisYapVeyaUyeOl;

    @FindBy(css = "#login")
    public WebElement girisYap;

    @FindBy(xpath = "//button[.='Kabul et']")
    public WebElement cookieAccept;

}
