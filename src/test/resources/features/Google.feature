
Feature: Probar la busqueda de google
@Google
  Scenario: Buscar algo en google
    Given navego a google
    When busco algo
    And hago clic en el boton de buscar
    Then obtengo resultados