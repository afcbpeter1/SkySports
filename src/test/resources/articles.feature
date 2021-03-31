Feature: Articles feature

#  We can add more examples to the test to verify other fields in the response
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

# This test will validate the whole json file as well as the Schema
  Scenario: Receiving a list of articles
    Given I have a set of articles
    When I get the list of articles
    Then It will match the json file

#    Posting a new article getting a 404 response
  Scenario: Posting a new article
    Given I want to create a new article
    When I post a new article
    Then I will see the response code as "404"

#    Deleting an article getting a 404 response
  Scenario: Deleting an article
    Given I want to delete an article
    When I delete an article
    Then the response code will be "404"