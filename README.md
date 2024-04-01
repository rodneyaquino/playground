# TEST PROJECT
---
### The Scenario
> Our developer was not exactly focused on quality when he built this simple Tic Tac Toe game:
>
> https://roomy-fire-houseboat.glitch.me/
---
### The Task
> - Write up the bugs and issues that you find with it and publish your results in a GSuite product of your choice
> - Hand-code 3-5 automation scripts
---
### Task 1 | Bug Report
> The Bug Report was built using [Google Sites](https://workspace.google.com/products/sites/)
>
> <a href="https://sites.google.com/view/raquino-test-project/home" target="_blank" rel="noopener noreferrer">BUG REPORT - TEST PROJECT</a>
---
### Task 2 | Automation Scripts
> This repo is based off an Automation Boiler Plate | [AUTOMATION-BOILER PLATE - Adrian Distoica](https://github.com/adistoica/automation-boilerplate)
>
> The relevant code lives in 3 places
> - [HomePage](src/main/java/pages/HomePage.java) | locators, page actions, boolean checks for element visibility and additional helpers live here
> - [TicTacToe](src/test/java/automation/smoke/TicTacToe.java) | This is where our tests hangout
> - [BasePage](src/main/java/pages/BasePage.java) | Added a helper `isElementPresent` that is used frequently in [HomePage](src/main/java/pages/HomePage.java)
---
