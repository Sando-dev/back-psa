Feature: Editar tareas

  Scenario: Edición exitosa
    Given Hay 3 tareas creadas
    When El integrante de proyecto edita la tarea número 2
    Then Se le informa que la edición de la tarea número 2 fue exitosa