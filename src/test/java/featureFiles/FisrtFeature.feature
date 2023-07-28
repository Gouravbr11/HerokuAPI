@tag
Feature: Validating heroku api
  
  Scenario Outline: Authorization by creating token
    Given Pass the valid <username> and <password>
    When submit the api with <request method>
    Then validate that status code is "200" 
    
    Examples:
    | username | password | request method | resource |
    | admin | password123 | post | auth1 |
