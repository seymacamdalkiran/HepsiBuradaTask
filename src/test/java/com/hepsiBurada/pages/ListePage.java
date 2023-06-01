package com.hepsiBurada.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListePage extends BasePage{
    @FindBy(xpath = "//span[@class='a-size-medium-plus huc-atwl-header-main']")
    public WebElement urunEklendi;
}
