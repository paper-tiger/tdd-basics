Feature: Posting 

  Scenario: Alice can publish messages to a personal timeline
    When "ALICE" publishes "This is a test"
    Then "This is a test" is added to "Alice" timeline



    