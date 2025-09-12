
  Feature: US1008 Kullanici yanlis bilgilerle giris yapamaz
    @smoke @json
    Scenario: TC12 kullanici yanlis password ile giris yapamamali

      Given kullanici testotomasyonu anasayfaya gider
      Then account butonuna basar
      And email olarak "toGecerliEmail" girer
      And password olarak "toGecersizPassword" girer
      Then signIn butonuna basar
      And sisteme giris yapamadigini test eder
      And senkronizasyon icin 3 saniye bekler

  @paralel2
    Scenario: TC13 kullanici yanlis email ile giris yapamamali

      Given kullanici testotomasyonu anasayfaya gider
      Then account butonuna basar
      And email olarak "toGecersizEmail" girer
      And password olarak "toGecerliPassword" girer
      Then signIn butonuna basar
      And sisteme giris yapamadigini test eder
      And senkronizasyon icin 3 saniye bekler


    Scenario: TC14 kullanici yanlis password yanlis email ile giris yapamamali

      Given kullanici testotomasyonu anasayfaya gider
      Then account butonuna basar
      And email olarak "toGecersizEmail" girer
      And password olarak "toGecersizPassword" girer
      Then signIn butonuna basar
      And sisteme giris yapamadigini test eder
      And senkronizasyon icin 3 saniye bekler
