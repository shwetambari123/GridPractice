Feature: Login
  As a Admin
  I want to Login orangeHRM
  So that I can access orangeHRM

 @smoke
  Scenario:valid login

    Given I am on login page
    When I enter username as "Admin" and password "aediMNjU"
    Then I can access welcome page