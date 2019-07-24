Feature: Github repository contributors

    Scenario: Repository contributors
        Given some public repository
         When I ask for this repository contributors
         Then I get listed all contributors with name and login

