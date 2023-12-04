Feature: Consulta de tareas de un proyecto

  Scenario: Sin tareas registradas para proyecto en progreso
    Given No hay tareas registradas para el proyecto En progreso
    When El integrante de proyecto consulta las tareas del proyecto
    Then Se le informa que no hay tareas registradas

  Scenario: Con tareas registradas para proyecto en progreso
    Given Hay 2 tareas registradas para el proyecto En progreso
    When El integrante de proyecto consulta las tareas del proyecto
    Then Se le informa fecha de inicio y fin, descripción, asignado y estado para las 2 tareas

  Scenario: Sin tareas registradas para proyecto finalizado
    Given No hay tareas registradas para el proyecto Finalizado
    When El integrante de proyecto consulta las tareas del proyecto
    Then Se le informa que no hay tareas registradas

  Scenario: Con tareas registradas para proyecto finalizado
    Given Hay 2 tareas registradas para el proyecto Finalizado
    When  El integrante de proyecto consulta las tareas del proyecto
    Then Se le informa fecha de inicio y fin, descripción, asignado y estado para las 2 tareas