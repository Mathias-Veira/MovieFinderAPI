# MovieFinderAPI
Este proyecto es una API que permite gestionar información de películas. Permite filtrar películas por nombre o género, consultar valoraciones existentes y valorar películas personalmente. La API fue creada como parte del PFC del Ciclo Superior en Desarrollo de Aplicaciones Web. 
# Tecnologías Utilizadas
- Java 17
- Spring Boot 3.4.4
- JPA
- SQL SERVER
- JWT (JSON Web Tokens)
- Redis
# Funcionalidades
- Registro e inicio de sesión de usuarios.
- Autenticación mediante JWT (access y refresh token).
- Obtener listado de películas completo, por nombre y por género (con paginación).
- Obtener película por ID.
- Consultar valoraciones de una película.
- Valorar una película.
- Gestionar películas vistas y favoritas.
- Cacheo de resultados de películas paginadas usando redis para mejorar el rendimiento.