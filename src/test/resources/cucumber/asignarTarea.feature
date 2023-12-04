Feature: Asignar empleado a tarea

  Scenario: Asignación de otro integrante
    Given Una tarea creada
    When El integrante de proyecto Juan asigna a Carlos como responsable
    Then La tarea pasa a tener como asignado a Carlos

  Scenario: Asignación de sí mismo
    Given Una tarea creada
    When El integrante de proyecto Juan se asigna la tarea a sí mismo
    Then La tarea pasa a tener como asignado a Juan

  Scenario: Asignación de un integrante habiendo otro antes
    Given Una tarea creada y el integrante Carlos está asignado a la tarea
    When El integrante de proyecto Juan se asigna la tarea a sí mismo
    Then La tarea pasa a tener como asignado a Juan

  Scenario: Quitar asignación de un integrante
    Given Una tarea creada y el integrante Juan está asignado a la tarea
    When El integrante de proyecto Juan se quita la asignación
    Then La tarea pasa a no tener asignados

  Scenario: Asignación de más de una tarea a un empleado
    Given Una tarea A creada y otra tarea B creada y el integrante Juan está asignado a la tarea A
    When El integrante de proyecto Juan se asigna la tarea B
    Then La tarea B pasa a tener asignado a Juan