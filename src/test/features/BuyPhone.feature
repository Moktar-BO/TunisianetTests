Feature: Buy a phone from Tunisianet

  @RegressionTest
  Scenario: Order an iphone until address info
    Given A user searches for an "iphone" Tunisianet
    When She selects an "Iphone" model
    And She provides personal information
    Then She is prompted to add address information

