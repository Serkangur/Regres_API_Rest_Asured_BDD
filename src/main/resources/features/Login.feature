@LoginTest

Feature: Login islemleri

  @PositiveTest @Regression @AllTest
  Scenario: Basarili login islemi
    Given Basarili sekilde kullanici girisi


  @NegativeTest @Regression @AllTest
  Scenario: Basarisiz login islemi
    Given Gecerli mail gecersiz sifre kullanici girisi

  @NegativeTest @Regression @AllTest
  Scenario: Basarisiz login islemi
    Given Gecersiz mail gecerli sifre kullanici girisi

  @NegativeTest @Regression @AllTest
  Scenario: Basarisiz login islemi
    Given Gecersiz mail gecersiz sifre kullanici girisi


  @NegativeTest @Regression @AllTest
  Scenario: Basarisiz login islemi
    Given Bos mail ve sifre alanı ile kullanici girisi

