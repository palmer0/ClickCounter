Feature:  Pantalla COUNTER

  Scenario: Incrementar COUNTER desde 0 a 1
    Given iniciamos pantalla COUNTER
    And texto en COUNTER muestra 0
    And botón INCREMENT se encuentra ACTIVADO
    And botón RESET se encuentra DESACTIVADO
    And botón CLICKS se encuentra DESACTIVADO
    When hacemos clic en botón INCREMENT
    Then texto en COUNTER muestra 1
    And botón INCREMENT se encuentra ACTIVADO
    And botón RESET se encuentra ACTIVADO
    And botón CLICKS se encuentra ACTIVADO