Feature: US1001 Testotomasyonu phone arama testi
  @deneme
  Scenario: TC01 Kullanici testotomasyonu sitesinde phone bulabilmeli
    Given kullanici testotomasyonu anasayfaya gider
    When arama kutusuna phone yazip aratir
    Then arama sonucunda urun bulunabildigini test eder




    @smoke @E2E1 @regression
    Scenario: TC02 kullanici testotomasyonu sitesinde dress bulabilmeli
      Given kullanici testotomasyonu anasayfaya gider
      When arama kutusuna dress yazip aratir
      Then arama sonucunda urun bulunabildigini test eder


    Scenario: TC03  Kullanici testotomasyonu sitesinde java bulamamalı
      Given kullanici testotomasyonu anasayfaya gider
      When arama kutusuna java yazip aratir
      Then arama sonucunda urun bulunamagini test eder

