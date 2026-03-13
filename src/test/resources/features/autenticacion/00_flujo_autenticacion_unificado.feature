Feature: Flujo de autenticacion de usuarios
  Como usuario de TicketSystem
  Quiero completar el ciclo de autenticacion
  Para gestionar el acceso a mi cuenta de forma segura

  @critico @happy-path @auth-e2e
  Scenario: Registro, cierre de sesion e inicio de sesion en un flujo independiente
    Given que un usuario accede por primera vez al sistema
    When se registra con datos de usuario validos y unicos
    Then es redirigido al listado de tickets
    And su nombre de usuario es visible en la barra de navegacion
    When cierra su sesion desde la barra de navegacion
    Then es redirigido a la pantalla de inicio de sesion
    When inicia sesion con credenciales validas
    Then es redirigido al listado de tickets
    And el nombre del usuario es visible en la barra de navegacion