Feature: Ver listado de proyectos

  Scenario: No hay proyectos creados
    Given No hay proyectos creados
    When El integrante de proyecto consulta el listado de proyectos
    Then Se le muestra que no hay proyectos creados

  Scenario: Hay proyectos creados
    Given Hay 3 proyectos creados
    When El integrante de proyecto consulta el listado de proyectos
    Then Se le muestran los 3 proyectos creados con su respectivos nombres, fecha de inicio y fin, líder y estados