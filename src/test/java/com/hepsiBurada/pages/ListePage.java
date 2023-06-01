package com.hepsiBurada.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListePage extends BasePage{
    @FindBy(xpath = "//span[@class='a-size-medium-plus huc-atwl-header-main']")
    public WebElement urunEklendi;

    @FindBy(xpath = "//button[@data-action='a-popover-close']")
    public WebElement listeKapa;

    @FindBy(xpath = "//span[@class='nav-text']")
    public WebElement setCardListe;

    @FindBy(xpath = "//a[contains(.,'Sepete Ekle')]")
    public WebElement sepeteEkle;

    @FindBy(id = "nav-cart-count-container")
    public WebElement sepetim;

    @FindBy(xpath = "//input[@class='a-button-input a-declarative'][@aria-labelledby='a-autoid-42-announce']")
    public WebElement listeOlustur;

    @FindBy(xpath = "//div[@id='wl-huc-post-create-msg']/span")
    public WebElement listeyeEklendi;

}
