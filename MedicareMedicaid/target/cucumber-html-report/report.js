$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("cms.feature");
formatter.feature({
  "line": 1,
  "name": "CMS HomePage Validations",
  "description": "",
  "id": "cms-homepage-validations",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Module Validations of the CMS landing page",
  "description": "",
  "id": "cms-homepage-validations;module-validations-of-the-cms-landing-page",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "User navigates to https://www.cms.gov/",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "User validates the page has been loaded",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "User validate all the modules on the top of the page are displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "HomePageSteps.user_navigates_to_https_www_cms_gov()"
});
formatter.result({
  "duration": 425048700,
  "error_message": "java.lang.NullPointerException\r\n\tat cucumber.stepDef.HomePageSteps.user_navigates_to_https_www_cms_gov(HomePageSteps.java:19)\r\n\tat ✽.Given User navigates to https://www.cms.gov/(cms.feature:4)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "HomePageSteps.user_validates_the_page_has_been_loaded()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "HomePageSteps.user_validate_all_the_modules_on_the_top_of_the_page_are_displayed()"
});
formatter.result({
  "status": "skipped"
});
});