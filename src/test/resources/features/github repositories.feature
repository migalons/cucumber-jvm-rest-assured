Feature: Github user repositories

    @mytest
    Scenario: Users repository details
        Given a user with some repositories
         When I ask for user's repositories
         Then I get listed all his repositories

