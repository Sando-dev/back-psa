Feature: Cambiar estado de tarea

  Scenario: Cambio a un estado posterior
    Given Una tarea en estado Empezado
    When El integrante del proyecto cambia el estado de la tarea a En progreso
    Then El estado de la tarea pasa a ser En progreso

  Scenario: Cambio a mismo estado actual
    Given Una tarea en estado Empezado
    When El integrante del proyecto cambia el estado de la tarea a Empezado
    Then El estado de la tarea se mantiene en Empezado

  Scenario: Cambio a estado anterior
    Given Una tarea en estado Finalizado
    When El integrante del proyecto cambia el estado de la tarea a En progreso
    Then El estado de la tarea pasa a ser En progreso