Feature: Articles feature

Scenario Outline: Receiving an article by it's ID
  Given I have a set of articles containing individual ID's
  When I get an article "<ID>"
  Then I should see the response code as "200"
  And I will receive an individual article based on expected "<ID>"
  Examples:
  |ID|
  | 1 |
  | 2 |
  | 3 |
  | 4656364867443 |
  | 5 |


  Scenario: Receiving a list of articles
    Given I have a set of articles
    When I get the list of articles
    Then It will match the json file