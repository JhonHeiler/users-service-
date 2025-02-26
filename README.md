Microservicio de Gestión de Usuarios
Potencia la gestión de usuarios con seguridad, escalabilidad y facilidad de uso

Este microservicio está diseñado para simplificar la gestión de usuarios en tus aplicaciones, ofreciendo un sistema robusto y seguro para el registro, inicio de sesión y administración de perfiles. Desarrollado bajo los principios de Clean Architecture, garantiza un código limpio, mantenible y escalable.

Características Principales
Registro y Autenticación Segura:

Registro de usuarios con validación y almacenamiento seguro de contraseñas usando BCrypt.

Autenticación mediante JWT (JSON Web Tokens) para garantizar la seguridad de las sesiones.

Gestión de Perfiles:

Consulta y actualización de perfiles de usuarios de manera sencilla.

Endpoints RESTful diseñados para una integración rápida y eficiente.

Persistencia de Datos:

Almacenamiento de datos en MariaDB, configurado fácilmente con Docker para entornos de desarrollo y producción.

Código Limpio y Optimizado:

Uso de Lombok para reducir el código repetitivo y mejorar la legibilidad.

Estructura modular basada en Clean Architecture, separando claramente la lógica de negocio, la infraestructura y la capa de aplicación.

Tecnologías Utilizadas
Spring Boot: Para el desarrollo rápido y eficiente del microservicio.

Spring Data JPA: Para la persistencia de datos con MariaDB.

Spring Security + JWT: Para garantizar la seguridad y autenticación de los usuarios.

Docker: Para la configuración sencilla de la base de datos MariaDB.

Lombok: Para simplificar el código y mejorar la productividad.

Estructura del Proyecto
El proyecto está organizado en tres capas principales, siguiendo los principios de Clean Architecture:

Dominio:

Contiene los modelos de negocio y las interfaces de repositorios, libres de dependencias externas.

Aplicación:

Incluye los casos de uso, DTOs y servicios que implementan la lógica de negocio.

Infraestructura:

Implementa la persistencia con JPA, la configuración de seguridad con Spring Security y JWT, y los controladores REST.

Estructura de Directorios

user-service/
├── src/
│   └── main/
│       ├── java/com/example/userservice/
│       │   ├── UserServiceApplication.java              // Aplicación principal de Spring Boot
│       │   ├── domain/
│       │   │   ├── model/
│       │   │   │    └── User.java                       // Modelo del dominio (POJO)
│       │   │   └── repository/
│       │   │         └── UserRepository.java            // Interfaz del repositorio de dominio
│       │   ├── application/
│       │   │   ├── dto/
│       │   │   │    ├── UserRegistrationDTO.java        // DTO para el registro de usuario
│       │   │   │    ├── UserLoginDTO.java               // DTO para el inicio de sesión
│       │   │   │    ├── UserProfileDTO.java             // DTO para el perfil del usuario
│       │   │   │    └── AuthResponseDTO.java            // DTO para la respuesta de autenticación
│       │   │   └── service/
│       │   │         └── UserService.java               // Servicio de la aplicación que maneja la lógica de negocio
│       │   └── infrastructure/
│       │       ├── persistence/
│       │       │    ├── UserEntity.java                 // Mapeo de la entidad JPA para el usuario
│       │       │    ├── JpaUserRepository.java          // Repositorio Spring Data JPA
│       │       │    └── UserRepositoryImpl.java         // Adaptador que implementa el repositorio de dominio
│       │       ├── config/
│       │       │    ├── SecurityConfig.java             // Configuración de Spring Security con el filtro JWT
│       │       │    ├── JwtUtil.java                    // Utilidad para la generación y validación de JWT
│       │       │    └── JwtAuthenticationFilter.java    // Filtro de autenticación JWT
│       │       └── web/
│       │            └── UserController.java             // Controlador REST que expone los endpoints de usuario
│       └── resources/
│           └── application.properties                   // Configuración de la base de datos, JWT, etc.
└── docker-compose.yml                                   // Archivo Docker Compose para ejecutar MariaDB

¿Cómo Empezar?
Sigue estos sencillos pasos para ejecutar el microservicio en tu entorno local:

Clona el repositorio:
git clone <URL_REPOSITORIO>
cd user-service

Configura MariaDB con Docker:
docker-compose up -d

Esto iniciará MariaDB en un contenedor Docker.

Compila y ejecuta la aplicación:

bash
mvn install
mvn spring-boot:run
La aplicación estará disponible en http://localhost:8080.
Endpoints de la API
Registrar Usuario
Método: POST /users/register

Cuerpo:
{
"email": "user@example.com",
"password": "password123"
}

Respuesta: 200 OK con un mensaje de confirmación.

Iniciar Sesión
Método: POST /users/login

Cuerpo:
{
"email": "user@example.com",
"password": "password123"
}

Respuesta: Token JWT para autenticación.

Obtener Perfil del Usuario
Método: GET /users/profile

Requiere: Autenticación (JWT).

Respuesta: 200 OK con los datos del perfil.

Actualizar Perfil del Usuario
Método: PUT /users/profile

Requiere: Autenticación (JWT).

Cuerpo:
{
"firstName": "Juan",
"lastName": "Pérez",
"address": "456 Calle Actualizada, Ciudad, País"
}

Respuesta: 200 OK con el perfil actualizado.

Configuración
Las propiedades de configuración se encuentran en src/main/resources/application.properties. Ejemplo:
spring.datasource.url=jdbc:mysql://localhost:3306/userdb
spring.datasource.username=root
spring.datasource.password=rootpassword
spring.jpa.hibernate.ddl-auto=update

jwt.secret=mysecretkey
jwt.expirationMs=3600000

Docker Compose
El archivo docker-compose.yml facilita la ejecución de MariaDB en Docker:
version: '3'
services:
db:
image: mariadb
environment:
MYSQL_ROOT_PASSWORD: rootpassword
MYSQL_DATABASE: userdb
ports:
- "3306:3306"
networks:
- user-network
networks:
user-network:
driver: bridge