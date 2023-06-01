package com.hepsiBurada.tests;

import com.hepsiBurada.pages.BasketPage;
import com.hepsiBurada.pages.ListePage;
import com.hepsiBurada.pages.LoginPage;
import com.hepsiBurada.pages.SamsungPage;
import com.hepsiBurada.utilities.BrowserUtils;
import com.hepsiBurada.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AmazonTest extends TestBase{

    @Test
    public void testAmazon() throws InterruptedException {
        LoginPage loginPage=new LoginPage();
        SamsungPage samsungPage=new SamsungPage();
        ListePage listePage=new ListePage();
        BasketPage basketPage=new BasketPage();

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
        Thread.sleep(3000);
        try {
            //her hangi bir alışveriş listesi yoksa bu adımda oluşturulur
            driver.findElement(By.xpath("(//span[@class='a-button a-button-primary'])[2]")).click();
        } catch (Exception e) {
            //önceden oluşturulmuş bir alışveriş listesi varsa
            String text = listePage.urunEklendi.getText();
            //ürün ilk defa ekleniyor ise
            if(text.equals("1 ürün şuraya eklendi:")){
                Assert.assertEquals(text,"1 ürün şuraya eklendi:");
            }//ürün zaten listede mevcut ise
            else {
                Assert.assertEquals(text,"Bu ürün zaten şurada mevcut:");
            }
        }
        listePage.listeKapa.click();


        extentLogger.info("Ekran üstündeki hesabım alanında beğenilen ürün kontrolü yapılır");
        actions.moveToElement(listePage.merhabaGirisYapin).perform();
        Thread.sleep(1000);
        listePage.alisverisListesi.click();

        extentLogger.info("Beğenilen ürün seçilir ve sepete eklenir");
        listePage.sepeteEkle.click();

        extentLogger.info("Sepetim sayfasına gidilir");
        listePage.sepetim.click();

        extentLogger.info("'Ürün sepete eklendi' kontrolü yapılır");
        Assert.assertFalse(basketPage.sepetimdekiUrunler.isEmpty());

        extentLogger.info("Ürün kaldır butonuna basılıp sepetten çıkarılır");
        basketPage.sil.click();

        extentLogger.info("Ürünün sepette olmadığı kontrol edilir");
        Assert.assertTrue(basketPage.silindiMesaji.isDisplayed());
    }
}
