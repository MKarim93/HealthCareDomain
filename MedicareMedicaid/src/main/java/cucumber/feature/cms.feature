Feature: CMS HomePage Validations

  Scenario: Module Validations of the CMS landing page
    Given User navigates to https://www.cms.gov/
    When User validates the page has been loaded
    Then User validate all the modules on the top of the page are displayed