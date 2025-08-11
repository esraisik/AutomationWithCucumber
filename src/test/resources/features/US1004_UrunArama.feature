Feature: US1004 kullanici istediği urunu aratır ve bulabildigini test eder
  @paralel1
  Scenario: TC8 kullanici istedigi urunu aratip
      bulundugunu test edebilmeli

    Given kullanici testotomasyonu anasayfaya gider
    When arama kutusuna "dress" yazip aratir
    Then arama sonucunda urun bulunabildigini test eder
    And ilk urunu tiklar
    Then acilan sayfada urun isminde case sensetive olmadan "dress" bulundugunu test eder
    And senkronizasyon icin 2 saniye bekler
