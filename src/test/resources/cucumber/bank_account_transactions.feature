Feature: Bank account transactions

  Scenario: Read all transactions
    Given Account with a balance of 500
    When Depositing 100, 200, 300
    Then Number of transactions should be 3

  Scenario: Read a transaction in particular
    Given Account with a balance of 500
    When Depositing 400, 500, 600
    Then Transaction number 2 should be 200

  Scenario: Delete a transaction
    Given Account with three deposits 100, 200, 300
    When Trying to delete transaction number 1
    Then Transaction should be deleted

  Scenario: Read a deposit transaction
    Given Account with a balance of 500
    When Trying to deposit 200
    Then Account balance should be 700
    And Last transaction should be deposit

  Scenario: Read a withdraw transaction
    Given Account with a balance of 500
    When Trying to withdraw 200
    Then Account balance should be 300
    And Last transaction should be withdraw