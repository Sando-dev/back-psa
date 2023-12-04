Feature: Ver tablero

  Scenario: No hay tareas creadas
    Given No hay tareas creadas
    When El integrante de proyecto consulta el tablero del proyecto
    Then Se le muestra que no hay tareas creadas

  Scenario: Hay tareas creadas
    Given Hay 3 tareas creadas
    When El integrante de proyecto consulta el tablero del proyecto
    Then Se le muestran las 3 tareas creadas con sus respectivos titulos, prioridades, asignados, estados, descripciones, inicio y fin