package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestotomasyonuStepdefinitions {

    TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
    String satirdakiUrunIsmi;
    Double satirdakiMinBulunacakUrunSayisi;
    Double actualSonucSayisi;
    Sheet calisilanSayfa;
    Workbook workbook;

    @Given("kullanici testotomasyonu anasayfaya gider")
    public void kullanici_testotomasyonu_anasayfaya_gider() {

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
    }

    @When("arama kutusuna phone yazip aratir")
    public void arama_kutusuna_phone_yazip_aratir() {

        testotomasyonuPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);
    }

    @Then("arama sonucunda urun bulunabildigini test eder")
    public void arama_sonucunda_urun_bulunabildigini_test_eder() {

        String unExpectedAramaSonucu = ConfigReader.getProperty("toUnexpectedSonuc");
        String actualAramaSonucu =testotomasyonuPage.aramaSonucuElementi
                                    .getText();

        Assertions.assertNotEquals(unExpectedAramaSonucu,actualAramaSonucu);

    }
    @Then("sayfayi kapatir")
    public void sayfayi_kapatir() {

        Driver.quitDriver();

    }


    @When("arama kutusuna dress yazip aratir")
    public void aramaKutusunaDressYazipAratir() {

        testotomasyonuPage.aramaKutusu.sendKeys("dress" + Keys.ENTER);
    }

    @When("arama kutusuna java yazip aratir")
    public void aramaKutusunaJavaYazipAratir() {

        testotomasyonuPage.aramaKutusu.sendKeys("java" + Keys.ENTER);
    }

    @Then("arama sonucunda urun bulunamagini test eder")
    public void aramaSonucundaUrunBulunamaginiTestEder() {

        String expectedAramaSonucu = ConfigReader.getProperty("toUnexpectedSonuc");
        String actualAramaSonucu = testotomasyonuPage.aramaSonucuElementi
                .getText();

        Assertions.assertEquals(expectedAramaSonucu,actualAramaSonucu);
    }

    @When("arama kutusuna {string} yazip aratir")
    public void aramaKutusunaYazipArar(String aranacakKelime) {

        testotomasyonuPage.aramaKutusu.sendKeys(aranacakKelime + Keys.ENTER);
    }

    @And("senkronizasyon icin {int} saniye bekler")
    public void senkronizasyonicinSaniyeBekler(int bekleneceksaniye) {

        ReusableMethods.bekle(bekleneceksaniye);
    }

    @Then("acilan sayfada urun isminde case sensetive olmadan {string} bulundugunu test eder")
    public void acilanSayfadaUrunIsmindeCaseSensetiveOlmadanBulundugunuTestEder(String arananKelime) {

    String actualUrunIsmi = testotomasyonuPage.ilkUrunSayfasindakiIsimElementi
                                                .getText()
                                                .toLowerCase();
    Assertions.assertTrue(actualUrunIsmi.contains(arananKelime));

    }

    @And("ilk urunu tiklar")
    public void ilkUrunuTiklar() {

        testotomasyonuPage.ilkUrunElementi.click();

    }

    @When("arama kutusuna test data dosyasindaki belirlenen kelimeyi yazip aratir")
    public void aramaKutusunaTestDataDosyasindakiBelirlenenKelimeyiYazipAratir() {

        testotomasyonuPage.aramaKutusu
                .sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);
    }

    @Then("acilan sayfada urun isminde case sensetive olmadan test data dosyasindaki belirlenen kelimeyi bulundugunu test eder")
    public void acilanSayfadaUrunIsmindeCaseSensetiveOlmadanTestDataDosyasindakiBelirlenenKelimeyiBulundugunuTestEder() {

        String actualUrunIsmi = testotomasyonuPage.ilkUrunSayfasindakiIsimElementi
                .getText()
                .toLowerCase();

        String expectedUrunIsmi = ConfigReader.getProperty("toAranacakKelime");

        Assertions.assertTrue(actualUrunIsmi.contains(expectedUrunIsmi));
    }



    @Given("kullanici test data dosyasinda verilen {string} anasayfaya gider")
    public void kullanici_test_data_dosyasinda_verilen_anasayfaya_gider(String configIstenenUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(configIstenenUrl));
    }
    @Then("url'in test data dosyasinda verilen {string} ile ayni oldugunu test eder")
    public void url_in_test_data_dosyasinda_verilen_ile_ayni_oldugunu_test_eder(String configIstenenUrl) {

        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = ConfigReader.getProperty(configIstenenUrl);

        Assertions.assertEquals(expectedUrl,actualUrl);
    }

    @Then("account butonuna basar")
    public void account_butonuna_basar() {
        testotomasyonuPage.accountLinki.click();
    }

    @Then("email olarak {string} girer")
    public void email_olarak_girer(String configIstenenEmail) {
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty(configIstenenEmail));
    }

    @Then("password olarak {string} girer")
    public void password_olarak_girer(String configIstenenPassword) {
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty(configIstenenPassword));
    }

    @Then("signIn butonuna basar")
    public void sign_in_butonuna_basar() {
        testotomasyonuPage.loginButonu.click();
    }

    @Then("basarili giris yapilabildigini test eder")
    public void basarili_giris_yapilabildigini_test_eder() {

        Assertions.assertTrue(testotomasyonuPage.logoutButonu.isDisplayed());

    }

    @Then("logout butonuna basar")
    public void logoutButonunaBasar() {
        testotomasyonuPage.logoutButonu.click();
    }




    @And("sisteme giris yapamadigini test eder")
    public void sistemeGirisYapamadiginiTestEder() {

        Assertions.assertTrue(testotomasyonuPage.loginButonu.isDisplayed());
    }


    @Then("arama sonucunda {string} veya daha fazla urun bulunabildigini test eder")
    public void aramaSonucundaVeyaDahaFazlaUrunBulunabildiginiTestEder(String belirlenenMiktarStr) {

          /*
        belirlenen sayida veya daha fazla urun bulunabildigini test etmek icin
        1- sonuc yazisindaki sayiyi alabiliriz
        2- bulunan urunleri findElements ile locate edip bir listeye koyabilir
           ve listenin size'ina bakabiliriz

        ANCCCAAAKKK 2.yontemi tercih ederseniz
        gosterilecek urun olmadiginda, locator implicitlyWait suresince
        elemanlari locate edebilmek icin bekleyecektir
        bu da zaman kaybi olur
      */

        String actualSonucYazisi = testotomasyonuPage.aramaSonucuElementi.getText();
                                    // 4 Product Found

        String actualSonucYazisiStr = actualSonucYazisi.replaceAll("\\D","");

        int actualSonucSayisi = Integer.parseInt(actualSonucYazisiStr);

        int expectedMinSonucsayisi = Integer.parseInt(belirlenenMiktarStr);

        Assertions.assertTrue(actualSonucSayisi>= expectedMinSonucsayisi);


    }

    @When("email olarak listede verilen {string} girer")
    public void emailOlarakListedeVerilenGirer(String direktEmail) {
        testotomasyonuPage.emailKutusu.sendKeys(direktEmail);
    }


    @And("password olarak listede verilen {string} girer")
    public void passwordOlarakListedeVerilenGirer(String direktPassword) {
        testotomasyonuPage.passwordKutusu.sendKeys(direktPassword);

    }

    @Then("urun excelindeki {string} daki urunun min. miktarini ve urun ismini kaydeder")
    public void urun_excelindeki_daki_urunun_min_miktarini_ve_urun_ismini_kaydeder(String excelSatirNoStr) throws IOException {
        //ornek satir no "3"

        String excelDosyaYolu ="src/test/resources/urunListesi.xlsx";
        FileInputStream fileInputStream = new FileInputStream(excelDosyaYolu);
        workbook = WorkbookFactory.create(fileInputStream);
        calisilanSayfa = workbook.getSheet("Sheet1");

        // sayfaya kadar gittik, bu method'a parametre olarak gelen
        // String excelsatirNoStr  degerine gore, ilgili satira gidip
        // satirdakiUrunIsmi ve satirdakiMinBulunacakurunSayisi degerlerini kaydedelim

        // once istenen satira gidelim
        int satirNo = Integer.parseInt(excelSatirNoStr); // 3

        satirdakiUrunIsmi = calisilanSayfa.getRow(satirNo-1).getCell(0).getStringCellValue();
       satirdakiMinBulunacakUrunSayisi = calisilanSayfa.getRow(satirNo-1).getCell(1).getNumericCellValue();


    }
    @Then("urun ismini testotomasyonu sayfasinda arar ve sonuc sayisini kaydeder")
    public void urun_ismini_testotomasyonu_sayfasinda_arar_ve_sonuc_sayisini_kaydeder() {

        testotomasyonuPage.aramaKutusu.sendKeys(satirdakiUrunIsmi + Keys.ENTER);
        String actualSonucYazisi = testotomasyonuPage.aramaSonucuElementi.getText();
        // 4 Product Found

        String actualSonucYazisiStr = actualSonucYazisi.replaceAll("\\D","");


         actualSonucSayisi =Double.parseDouble(actualSonucYazisiStr);


    }
    @Then("bulunan urun sayisinin {string} da verilen min. miktardan fazla oldugunu test eder")
    public void bulunan_urun_sayisinin_da_verilen_min_miktardan_fazla_oldugunu_test_eder(String satirNoStr) {

        Assertions.assertTrue(actualSonucSayisi >= satirdakiMinBulunacakUrunSayisi);



    }


    @Then("bulunan sonuc sayisini excel'de {string} daki {int}. sutuna yazdirir")
    public void bulunanSonucSayisiniExcelDeDakiSutunaYazdirir(String satirNoStr, int sutunNo) throws IOException {

        // once workbook'da istenen islemi yapalim
        int SatirNo = Integer.parseInt(satirNoStr);
        calisilanSayfa.getRow(SatirNo-1)
                .createCell(sutunNo-1)
                .setCellValue(actualSonucSayisi);



        // excel'e bilgi yazdirabilmek icin FileOutputStream'e ihtiyac var

        String excelDosyaYolu = "src/test/resources/urunListesi.xlsx";

        FileOutputStream fileOutputStream = new FileOutputStream(excelDosyaYolu);
        workbook.write(fileOutputStream);

        fileOutputStream.close();
        workbook.close();
    }


}


