Feature:  Click Counter

  @counter-feature
  Scenario: pulsar boton 1 vez

    Given iniciamos pantalla COUNTER
    And texto en COUNTER muestra 0
    And boton INCREMENT se encuentra ACTIVADO
    And boton RESET se encuentra DESACTIVADO
    And boton CLICKS se encuentra DESACTIVADO

    When hacemos clic en boton INCREMENT

    Then texto en COUNTER muestra 1
    And boton INCREMENT se encuentra ACTIVADO
    And boton RESET se encuentra ACTIVADO
    And boton CLICKS se encuentra ACTIVADO


  @counter-feature
  Scenario: pulsar boton 10 veces

    Given iniciamos pantalla COUNTER
    And texto en COUNTER muestra 0
    And boton INCREMENT se encuentra ACTIVADO
    And boton RESET se encuentra DESACTIVADO
    And boton CLICKS se encuentra DESACTIVADO

    When hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT

    Then texto en COUNTER muestra 0
    And boton INCREMENT se encuentra ACTIVADO
    And boton RESET se encuentra DESACTIVADO
    And boton CLICKS se encuentra ACTIVADO


  @counter-feature
  Scenario: pulsar boton 10 veces y ver numero clicks

    Given iniciamos pantalla COUNTER
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT

    When hacemos clic en boton CLICKS

    Then pausamos pantalla COUNTER
    And iniciamos pantalla CLICKS
    #And texto en COUNTER muestra 10
    And texto en CLICKS muestra 10
    And boton CLEAR se encuentra ACTIVADO
    And finalizamos pantalla CLICKS


  @counter-feature
  Scenario: pulsar boton 11 veces y resetear clicks

    Given iniciamos pantalla COUNTER
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton CLICKS
    And pausamos pantalla COUNTER
    And iniciamos pantalla CLICKS
    #And texto en COUNTER muestra 11
    And texto en CLICKS muestra 11
    And boton CLEAR se encuentra ACTIVADO

    When hacemos clic en boton CLEAR

    #Then texto en COUNTER muestra 0
    Then texto en CLICKS muestra 0
    And boton CLEAR se encuentra DESACTIVADO
    And finalizamos pantalla CLICKS
    And resumimos pantalla COUNTER
    And texto en COUNTER muestra 1
    And boton INCREMENT se encuentra ACTIVADO
    And boton RESET se encuentra ACTIVADO
    And boton CLICKS se encuentra ACTIVADO



  @counter-feature
  Scenario: pulsar boton 12 veces y resetear contador

    Given iniciamos pantalla COUNTER
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton CLICKS
    And pausamos pantalla COUNTER
    And iniciamos pantalla CLICKS
    And hacemos clic en boton CLEAR
    And finalizamos pantalla CLICKS
    And resumimos pantalla COUNTER
    And hacemos clic en boton INCREMENT
    And texto en COUNTER muestra 2
    And boton INCREMENT se encuentra ACTIVADO
    And boton RESET se encuentra ACTIVADO
    And boton CLICKS se encuentra ACTIVADO

    When hacemos clic en boton RESET

    Then texto en COUNTER muestra 0
    And boton INCREMENT se encuentra ACTIVADO
    And boton RESET se encuentra DESACTIVADO
    And boton CLICKS se encuentra ACTIVADO


  @counter-feature
  Scenario: pulsar boton 13 veces y ver numero clicks

    Given iniciamos pantalla COUNTER
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton INCREMENT
    And hacemos clic en boton CLICKS
    And pausamos pantalla COUNTER
    And iniciamos pantalla CLICKS
    And hacemos clic en boton CLEAR
    And finalizamos pantalla CLICKS
    And resumimos pantalla COUNTER
    And hacemos clic en boton INCREMENT
    And boton INCREMENT se encuentra ACTIVADO
    And boton RESET se encuentra ACTIVADO
    And boton CLICKS se encuentra ACTIVADO
    And hacemos clic en boton RESET
    And hacemos clic en boton INCREMENT
    And texto en COUNTER muestra 1
    And boton INCREMENT se encuentra ACTIVADO
    And boton RESET se encuentra ACTIVADO
    And boton CLICKS se encuentra ACTIVADO

    When hacemos clic en boton CLICKS

    Then pausamos pantalla COUNTER
    And iniciamos pantalla CLICKS
    And texto en CLICKS muestra 2
    And boton CLEAR se encuentra ACTIVADO



#  @counter-feature
#  Scenario: pulsar boton 1 vez rotando pantalla
#
#    Given iniciamos pantalla COUNTER
#    And texto en COUNTER muestra 0
#    And boton INCREMENT se encuentra ACTIVADO
#    And boton RESET se encuentra DESACTIVADO
#    And boton CLICKS se encuentra DESACTIVADO
#    And hacemos clic en boton INCREMENT
#
#    When rotamos pantalla COUNTER
#
#    Then texto en COUNTER muestra 1
#    And boton INCREMENT se encuentra ACTIVADO
#    And boton RESET se encuentra ACTIVADO
#    And boton CLICKS se encuentra ACTIVADO


#  @counter-feature
#  Scenario: pulsar boton 10 veces rotando pantalla
#
#    Given iniciamos pantalla COUNTER
#    And texto en COUNTER muestra 0
#    And boton INCREMENT se encuentra ACTIVADO
#    And boton RESET se encuentra DESACTIVADO
#    And boton CLICKS se encuentra DESACTIVADO
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#
#    When rotamos pantalla COUNTER
#
#    Then texto en COUNTER muestra 0
#    And boton INCREMENT se encuentra ACTIVADO
#    And boton RESET se encuentra DESACTIVADO
#    And boton CLICKS se encuentra ACTIVADO


#  @counter-feature
#  Scenario: pulsar boton 10 veces y ver numero clicks rotando pantalla
#
#    Given iniciamos pantalla COUNTER
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton CLICKS
#    And pausamos pantalla COUNTER
#    And iniciamos pantalla CLICKS
#
#    When rotamos pantalla COUNTER
#    And rotamos pantalla CLICKS
#
#    #Then texto en COUNTER muestra 10
#    Then texto en CLICKS muestra 10
#    And boton CLEAR se encuentra ACTIVADO
#    And finalizamos pantalla CLICKS


#  @counter-feature
#  Scenario: pulsar boton 11 veces y resetear clicks rotando pantalla
#
#    Given iniciamos pantalla COUNTER
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton CLICKS
#    And pausamos pantalla COUNTER
#    And iniciamos pantalla CLICKS
#    #And texto en COUNTER muestra 11
#    And texto en CLICKS muestra 11
#    And boton CLEAR se encuentra ACTIVADO
#    And hacemos clic en boton CLEAR
#    #And texto en COUNTER muestra 0
#    And texto en CLICKS muestra 0
#    And boton CLEAR se encuentra DESACTIVADO
#    And finalizamos pantalla CLICKS
#    And resumimos pantalla COUNTER
#
#    When rotamos pantalla COUNTER
#    And rotamos pantalla CLICKS
#
#    Then texto en COUNTER muestra 1
#    And boton INCREMENT se encuentra ACTIVADO
#    And boton RESET se encuentra ACTIVADO
#    And boton CLICKS se encuentra ACTIVADO


#  @counter-feature
#  Scenario: pulsar boton 12 veces y resetear contador rotando pantalla
#
#    Given iniciamos pantalla COUNTER
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton CLICKS
#    And pausamos pantalla COUNTER
#    And iniciamos pantalla CLICKS
#    And hacemos clic en boton CLEAR
#    And finalizamos pantalla CLICKS
#    And resumimos pantalla COUNTER
#    And hacemos clic en boton INCREMENT
#    And texto en COUNTER muestra 2
#    And boton INCREMENT se encuentra ACTIVADO
#    And boton RESET se encuentra ACTIVADO
#    And boton CLICKS se encuentra ACTIVADO
#    And hacemos clic en boton RESET
#
#    When rotamos pantalla COUNTER
#
#    Then texto en COUNTER muestra 0
#    And boton INCREMENT se encuentra ACTIVADO
#    And boton RESET se encuentra DESACTIVADO
#    And boton CLICKS se encuentra ACTIVADO


#  @counter-feature
#  Scenario: pulsar boton 13 veces y ver numero clicks rotando pantalla
#
#    Given iniciamos pantalla COUNTER
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton INCREMENT
#    And hacemos clic en boton CLICKS
#    And pausamos pantalla COUNTER
#    And iniciamos pantalla CLICKS
#    And hacemos clic en boton CLEAR
#    And finalizamos pantalla CLICKS
#    And resumimos pantalla COUNTER
#    And hacemos clic en boton INCREMENT
#    And boton INCREMENT se encuentra ACTIVADO
#    And boton RESET se encuentra ACTIVADO
#    And boton CLICKS se encuentra ACTIVADO
#    And hacemos clic en boton RESET
#    And hacemos clic en boton INCREMENT
#    And texto en COUNTER muestra 1
#    And boton INCREMENT se encuentra ACTIVADO
#    And boton RESET se encuentra ACTIVADO
#    And boton CLICKS se encuentra ACTIVADO
#    And hacemos clic en boton CLICKS
#    And pausamos pantalla COUNTER
#    And iniciamos pantalla CLICKS
#
#    When rotamos pantalla COUNTER
#    And rotamos pantalla CLICKS
#
#    Then texto en CLICKS muestra 2
#    And boton CLEAR se encuentra ACTIVADO
