Feature: Test QualityPointTech empdetails scenario
@TC_01
  Scenario: Test login with valid credentials 
    Given Open chrome and start application
    When Entering Username,Password and Click on Login button 
    Then user should be able to login
    
    When user clicks on Employee Details Button
    And user clicks on edit option
    And user update mail id 
    And user clicks on update employee details
    And user clicks on logout
    Then application should be closed
  
  