package com.hepsiBurada.tests;

import com.hepsiBurada.pages.ListePage;
import com.hepsiBurada.pages.LoginPage;
import com.hepsiBurada.pages.SamsungPage;
import com.hepsiBurada.utilities.BrowserUtils;
import com.hepsiBurada.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AmazonTest extends TestBase{

    @Test
    public void testAmazon() {
        LoginPage loginPage=new LoginPage();
        SamsungPage samsungPage=new SamsungPage();
        ListePage listePage=new ListePage();

        extentLogger=report.createTest("amazon login ol");

        extentLogger.info("https://www.amazon.com.tr/ sitesi açılır.");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Ana sayfanın açıldığı kontrol edilir.");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.amazon.com.tr/");

        extentLogger.info("Çerez tercihlerinden Çerezleri kabul et seçilir.");
        try {
            loginPage.cerezleriKabulEt.click();
        } catch (Exception e) {}

        extentLogger.info("Siteye login olunur.");
        loginPage.loginOl(ConfigurationReader.get("email"),ConfigurationReader.get("password"));

        extentLogger.info("Login işlemi kontrol edilir.");
        Assert.assertEquals(loginPage.hesapVeListeler.getText(),ConfigurationReader.get("name"));

        extentLogger.info("Arama alanına 'Samsung' yazılır ve aratılır");
        loginPage.aramaCubugu.sendKeys("Samsung");
        loginPage.searchButton.click();

        extentLogger.info("Cep telefonları sekmesi seçilir");
        samsungPage.cepTelefonu.click();

        extentLogger.info("Gelen sayfada samsung ürün bulunduğu doğrulanır");
        Assert.assertFalse(samsungPage.samsung.isEmpty());
        List<String> elementsText = BrowserUtils.getElementsText(samsungPage.samsung);
        Assert.assertTrue(elementsText.get(0).contains("Samsung"));

        extentLogger.info("Arama sonuçlarından 2. sayfa tıklanır");
        samsungPage.sonrakiSayfa(2);

        extentLogger.info("2. sayfanın gösterimde olduğu onaylanır.");
        Assert.assertTrue(samsungPage.gosterilenUrunSayisi.getText().contains("25-48"));
        //Assert.assertTrue(samsungPage.ikinciSayfa.isSelected());

        extentLogger.info("Üstten 5. ürün seçilir");
        samsungPage.samsung.get(4).click();

        extentLogger.info("Beğen butonuna tıklanılır");
        samsungPage.listeyeEkle.click();

        extentLogger.info("'Ürün listenize eklendi' popup kontrolü yapılır");
        String text = listePage.urunEklendi.getText();
        try {
            Assert.assertEquals(text,"1 ürün şuraya eklendi:");
        } catch (Exception e) {
            Assert.assertEquals(text,"Bu ürün zaten şurada mevcut:");
        }

        extentLogger.info("Ekran üstündeki hesabım alanında beğenilen ürün kontrolü yapılır");

        extentLogger.info("Beğenilen ürün seçilir ve sepete eklenir");

        extentLogger.info("'Ürün sepete eklendi' kontrolü yapılır");

        extentLogger.info("Sepetim sayfasına gidilir");

        extentLogger.info("Ürün kaldır butonuna basılıp sepetten çıkarılır");

        extentLogger.info("Ürünün sepette olmadığı kontrol edilir");

    }
}
