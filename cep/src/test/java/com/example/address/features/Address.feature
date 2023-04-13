Feature: Address Search

  Scenario: Search for address with valid CEP
    Given a valid Cep
    When the returnAddress function is called with the Cep
    Then the response status should be HttpStatus.OK

  Scenario: Search for address with invalid CEP
    Given an invalid Cep
    When the returnAddress function is called with the Cep
    Then the response status should be HttpStatus.NOT_FOUND