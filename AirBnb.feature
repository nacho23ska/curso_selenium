Feature: Simulacro de examen

  Scenario Outline: Buscar alojamiento
    Given accedo a la pagina de AirBnb
    When completo el <lugar> de destino
    And elijo la fecha y selecciono la cantidad de adultos
    Then valido el <lugar>
    And la cantidad de huespedes

  Examples:
    | lugar |
    | Bariloche |
    | Cataratas |
    | Mendoza |

  Scenario: Buscar experiencias
    Given accedo a la pagina de AirBnb
    When selecciono la opcion Experiencias
    And elijo destino y fecha y valido los datos
    Then hago la busqueda y valido los datos

  Scenario: Lugares cercanos
    Given accedo a la pagina de AirBnb
    Then muestro la lista de lugares cercanos