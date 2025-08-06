
  Feature: US1002 ortak baslangic adimları background olarak yazılabilir

    Background:
      Given kullanici testotomasyonu anasayfaya gider

    Scenario: TC04 Kullanici testotomasyonu sitesinde phone bulabilmeli
      When arama kutusuna phone yazip aratir
      Then arama sonucunda urun bulunabildigini test eder




    @paralel1
    Scenario: TC05 kullanici testotomasyonu sitesinde dress bulabilmeli
      When arama kutusuna dress yazip aratir
      Then arama sonucunda urun bulunabildigini test eder

    @paralel2
    Scenario: TC06  Kullanici testotomasyonu sitesinde java bulamamali
      Given kullanici testotomasyonu anasayfaya gider
      When arama kutusuna java yazip aratir
      Then arama sonucunda urun bulunamagini test eder
      #And sayfayi kapatir
      #Hooks kullanirken kapatma işini yaptigindan bu isleme gerek kalmadi
