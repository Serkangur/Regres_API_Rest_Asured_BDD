@CreateNewUserTest

  Feature: Yeni kullainici olusturma islemi

    @PositiveTest @Regression @AllTest
    Scenario: Yeni kullanici olusturma
      Given Basarili sekilde kullanici olusturma

    @PositiveTest @Regression @AllTest
    Scenario: Yeni kullanici olusturma
      Given Basarili sekilde kullanici guncelleme

    @PositiveTest @Regression @AllTest
    Scenario: Yeni kullanici olusturma
      Given PATCH ile basarili sekilde kullanici guncelleme