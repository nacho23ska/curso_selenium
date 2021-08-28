Feature: Examen Intermedio

  Scenario Outline: Escenario 1
    Given estoy en la pagina de Spotify
    When me encuentro en la seccion Premium
    Then valido que se encuentre el plan <nombre>

    Examples:
      |   nombre    |
      | individual  |
      |   premium   |
      |  familiar   |


  Scenario Outline: Escenario 2
    Given estoy en la pagina de Spotify
    When accedo a la pagina de registro
    And completo el campo mail con <email>
    Then se muestra el mensaje <mensaje>

    Examples:
    |  email   |   mensaje     |
    |  vecio   |   Es necesario que introduzcas tu correo electrónico.  |
    |  ffff    |   Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com |
    |  test@test.com  |   Este correo electrónico ya está conectado a una cuenta. Inicia sesión.                        |


  Scenario Outline: Escenario 3
    Given ingreso a terminos y condiciones
    Then valido que se encuentre el link <link>

    Examples:
    |   link   |
    |   Disfrutando Spotify   |
    |   Pagos, cancelaciones y periodo de reflexión   |
    |   Uso de nuestro servicio                       |
