## TeamCity selenium project

This project is written in java, implemented with Selenium3 and Maven. Everything is set up and tests can be added straight away. Used Testrunner is the Failsafe plugin. 

To execute the tests just browse to the path where the selenium-project is located in your terminal and 
type mvn clean verify **-Pbrowser-chrome** or execute the tests in your IDE. 
Maven profiles for all browsers exists in the pom.xml

To generate the report type _mvn site_, generated report can by find under target/site/allure-maven-plugin

## Implemented Browsers
Thanks to the awesome [webdrivermanager](https://github.com/bonigarcia/webdrivermanager) it supports the following browsers and automatically downloads OS specific binaries for:
* Chrome
* Chrome Headless
* Firefox
* Firefox Headless

#### The Webdriver Setup
The webdriver setup is based on the [WebDriverBuilder](https://github.com/zeuge1983/TeamCityDmitryTestTask/blob/main/src/main/java/selenium/driver/WebDriverBuilder.java) 
and the [DesiredCapabilitiesFactory](https://github.com/zeuge1983/TeamCityDmitryTestTask/blob/main/src/main/java/selenium/driver/DesiredCapabilitiesFactory.java)
to have a separation between driver instantiation and browser specific settings.

## Page Objects Pattern
Page object pattern is used to have reusable WebElements/small helper methods separated from actual test classes

#### @UserAgent
UserAgents can be overwritten and give the possibility to emulate the behaviour of an website if special devices visiting it.
For Example if you want to test a mobile switch for devices like smartphones and/or tablets etc.
``` 
@UserAgent(IPHONE_I_OS_9)
```

## Convenient Methods
You can find a couple of convenient methods like waits, isElementPresent/Visible, hover, dragAndDrop, etc. in [SeleniumFunctions.java](https://github.com/zeuge1983/TeamCityDmitryTestTask/blob/main/src/main/java/selenium/SeleniumFunctions.java) 

## Reporting
Allure open source framework is used for report generation [Allure](http://allure.qatools.ru/)

## Test scenarious
There are a lot of possible test scenarios for such huge project, and many of them are crucial and important. Here is the list I came up with. Of course it doesn't cover the whole functionality

_Login/Registration page_
 - Happy path login flow: user can login with existing account
 - Happy path Registration flow: user can register and login with new account
 - Login validation test: verify that correct validation messages are shown when user enters incorrect username/password: 

_Wrong username/password, invalid characters_
 - Logout flow: user can logout by clicking log out button
 - Reset password: user can reset password , receive email with link to restore the password
 - Remember me check box works

_Dashboard page_
 - Dashboard view: when there is no projects available, user sees empty dashboard with "Create project" button
 - User has access to all the settings from Dashboard
 - User can create new project 
 - User can edit/delete existing project 
 - User can enter Settings and tools page
 - User can enter Administration page

_Feedback/Help_
 - User can send feedback
 - User can use Help
 - User can enter Getting started page

_User settings_
 - User can manage email settings
 - User can manage licenses
 - User can invite more users to TeamCity

_Project management_
 - Project creation
 - Build execution management
 - Build configuration management
 - template managemnt
 - VCS management
 - Access to all logs/history/statistics etc
 - Build exectuiosn
	
_Administration_
 - Project settings
 - All builds information
 - Users
 - Group
 - Tools
 - Server Administration


**For the automation part I choose three sample scenarios, to demonstrate how does framework work**

_Login with existing user_
 - open http://localhost:8111/
 - login with registered user
 - verify Home page

_New project (Manually)_
 - As a registered user perform Login
 - From Dashboard page start creating new project Manually 
 - Enter Name and Description
 - Observe Edit project page
 - Go back to Dashboard page
 - Go to project settings
 - Go to actions and choose Delete project
 - Confirm
 - Observe the result

_User settings: Automated_
 - Login with registered user
 - Go to User settings
 - Change the name of the user
 - Go back to Dashboard page and observe the changes
 
 ## Preconditions
  - TeamCity server installed and started
  - There is a registered user
  - To be able to run tests `User` enum needs to be adjusted, to use your credentials to login to TeamCity server