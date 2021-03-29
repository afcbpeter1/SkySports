Feature: Articles feature

  Scenario: Receiving an article by it's ID
    Given I have a set of articles containing individual ID's
    When I get an the article ID
    Then I will receive an individual article


  Scenario: Receiving a list of articles
    Given I have a set of articles
    When I get the list of articles
    Then It will match the json file