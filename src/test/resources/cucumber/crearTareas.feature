Feature: Crear tareas

  Scenario: Creación de tarea vacía
    Given Un proyecto creado
    When El integrante de proyecto crea una tarea sin atributos
    Then Se le informa que no se pudo crear la tarea

  Scenario: Creación de tarea con nombre, fecha, descripción y estado en progreso
    Given Un proyecto creado
    When El integrante de proyecto crea una tarea con nombre, con fecha de inicio y fin, con descripción, sin asignado, y con estado “En Progreso”
    Then Se le informa que la tarea se creó exitosamente

  Scenario: Creación de tarea con nombre, fecha, descripción y sin estado
    Given Un proyecto creado
    When El integrante de proyecto crea una tarea con nombre, con fecha de inicio y fin, con descripción, sin asignado y sin estado
    Then Se le informa que no se pudo crear la tarea

  Scenario: Creación de tarea con nombre, fecha, descripción y con estado finalizado
    Given Un proyecto creado
    When El integrante de proyecto crea una tarea con nombre, con fecha de inicio y fin, con descripción, sin asignado, y con estado ”Finalizado”
    Then Se le informa que no se pudo crear la tarea

  Scenario: Creación de tarea sin nombre, fecha, descripción y con estado
    Given Un proyecto creado
    When El integrante de proyecto crea una tarea sin nombre, con fecha de inicio y fin, con descripción, sin asignado y con estado
    Then Se le informa que no se pudo crear la tarea

  Scenario: Creación de tarea con nombre, sin fecha, con descripción y con estado
    Given Un proyecto creado
    When El integrante de proyecto crea una tarea con nombre, sin fecha de inicio y fin, con descripción, sin asignado y con estado
    Then Se le informa que no se pudo crear la tarea

  Scenario: Creación de tarea con nombre, con fecha, sin descripción y con estado
    Given Un proyecto creado
    When El integrante de proyecto crea una tarea con nombre, con fecha de inicio y fin, sin descripción, sin asignado y con estado
    Then Se le informa que no se pudo crear la tarea