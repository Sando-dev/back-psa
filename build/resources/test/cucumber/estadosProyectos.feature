Feature: Cambio de estado del proyecto

Scenario: Cambio a un estado posterior
Given Hay un proyecto en estado No Iniciado
When El gerente de proyecto cambia el estado del proyecto a En Progreso
Then El estado del proyecto pasa a ser En Progreso

Scenario: Cambio a mismo estado actual
Given Hay un proyecto en estado En Progreso
When El gerente de proyecto cambia el estado del proyecto a En Progreso
Then El estado del proyecto pasa a ser En Progreso

Scenario: Cambio a estado anterior
Given Hay un proyecto en estado Finalizado
When El gerente de proyecto cambia el estado del proyecto a En Progreso
Then El estado del proyecto pasa a ser En Progreso




