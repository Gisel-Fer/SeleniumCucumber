@TradeMe @Test
Feature: Trademe para UI y API

  #primer escenario: hay que ir a la seccion de autos y devolver la cantidad de marcas que hay en la lista
  Scenario: As a user, I can see all the car makes on the Make dropdown
    Given I navigate to the TradeMe Motor page
    Then I can verify that the number of car makes is 79

  #Comprobar la cantidad de autos devueltos cuando buscas cada una de esas marcas
  Scenario Outline: As a user I can validate that each make has the right amount of cars listed
    Given  I navigate to the TradeMe Motor page
    When I select the car make <Make>
    Then I can see it has <Amount> records in the results

      Examples:
      |Make     |Amount   |
      |Ferrari  | 44      |
      |BMW      | 3,041   |
      |Mazda    | 5,348   |
      |Honda    | 2,774   |