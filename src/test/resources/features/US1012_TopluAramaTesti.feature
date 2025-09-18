
  Feature: US102012 kullaniciöliste olarak verilen urunleri aratır

    Scenario Outline: TC18 Kullanici liste olarak verilen ürünleri aratabilmeli

      Given kullanici test data dosyasinda verilen "toUrl" anasayfaya gider
      When  arama kutusuna "<aratilacakKelime>" yazip aratir
      Then arama sonucunda urun bulunabildigini test eder
      And senkronizasyon icin 1 saniye bekler




      Examples:
        |aratilacakKelime|
        |phone           |
        |samsung         |
        |apple           |
        |baby            |
        |bag             |
