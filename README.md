# Plataformas Especiales (Backend)

Esta aplicación backend implementa dos microservicios para procesar datos de transacciones.  
El primer microservicio valida y procesa la información, y la envía al segundo microservicio.  
El segundo microservicio almacena la transacción en una base de datos en memoria H2.

## Tecnologías utilizadas

- **Java**: Lenguaje de programación principal. Para este proyecto se utilizó `JDK 17`.
- **Spring Boot**: Framework para construir aplicaciones Java. En este proyecto se usa la versión `3.4.0`.
  - **Hibernate / JPA**: Para la gestión de la base de datos relacional.
  - **Jakarta Validation**: Para la validación de datos de entrada.
- **Maven**: Para la gestión de dependencias y construcción del proyecto.
- **H2**: Gestor de base de datos en memoria para almacenar la información de las transacciones.
- **Postman**: Para simular peticiones HTTP y probar los endpoints.
- **OpenFeign**: Dependencia utilizada para la comunicación entre microservicios.

## Características

### Endpoints

Rutas organizadas para interactuar con las transacciones. Operaciones soportadas:

- **Transaction**:
  - Obtener la lista de todas las transacciones.
  - Obtener la información de una transacción específica por su valor de referencia.
  - Crear una nueva transacción.
  - Cambiar el estatus de una transacción a `cancel`.

### Gestor de base de datos

- Integración con H2 para la manipulación de datos.
- La base de datos SQL cuenta con una tabla que gestiona la información de las transacciones.

### Validaciones

- `Transaction`:
  - No se permite que el atributo **operacion** se reciba vacío, con solo espacios en blanco o con caracteres no alfabéticos. Debe contener únicamente letras.
  - No se permite que el atributo **importe** se reciba vacío o con un formato inválido. Debe tener un formato válido de tipo moneda (por ejemplo, `100.00`, `650.00`, etc.).
  - No se permite que el atributo **cliente** se reciba vacío o con solo espacios en blanco. Debe contener únicamente letras. La longitud es definida a criterio del desarrollador.
  - El atributo **secreto** se espera cifrado en formato AES de 256 bits. Se descifra al llegar al backend para ser procesado y almacenado en texto plano.

### Patrones de diseño

- Se emplea el patrón de diseño arquitectónico **MVC** (Modelo-Vista-Controlador), para separar el código en diferentes capas.

## Estructura del proyecto

### Código fuente de la aplicación

- `controllers/`: Contiene las clases que manejan las solicitudes HTTP y definen los endpoints de la API.
- `services/`: Contiene las clases que implementan la lógica de negocio.
- `repositories/`: Contiene las interfaces que extienden de JPARepository para el manejo de datos.
- `entities/`: Contiene las clases que se mapean con sus respectivas tablas en la base de datos.
- `utils/`: Contiene clases con métodos utilitarios reutilizables en la aplicación.

## Demo

Puedes ver una demo del proyecto en el siguiente enlace: [Plataformas Especiales (Backend)](url)

----

# Special Platforms (Backend)

This backend application implements two microservices to process transaction data.  
The first microservice validates and processes the information, and sends it to the second microservice.  
The second microservice stores the transaction in an in-memory H2 database.

## Technologies Used

- **Java**: Main programming language. This project uses `JDK 17`.
- **Spring Boot**: Framework for building Java applications. This project uses version `3.4.0`.
  - **Hibernate / JPA**: For managing the relational database.
  - **Jakarta Validation**: For validating incoming data.
- **Maven**: For dependency management and project building.
- **H2**: In-memory database manager used to store transaction data.
- **Postman**: To simulate HTTP requests and test endpoints.
- **OpenFeign**: Dependency used for communication between microservices.

## Features

### Endpoints

Organized routes to interact with transactions. Supported operations:

- **Transaction**:
  - Retrieve the list of all transactions.
  - Retrieve the details of a specific transaction by its reference value.
  - Create a new transaction.
  - Update the transaction status to `cancel`.

### Database Manager

- Integration with H2 for data handling.
- The SQL database contains a table that manages transaction information.

### Validations

- `Transaction`:
  - The **operation** field must not be empty, consist only of whitespace, or contain non-alphabetic characters. It must contain only letters.
  - The **amount** field must not be empty or have an invalid format. It must follow a valid currency format (e.g., `100.00`, `650.00`, etc.).
  - The **client** field must not be empty or consist only of whitespace. It must contain only letters. Length is defined at the developer's discretion.
  - The **secret** field is expected to be encrypted using AES 256-bit format. It is decrypted upon arrival to the backend and stored in plain text.

### Design Patterns

- The **MVC** (Model-View-Controller) architectural design pattern is used to separate the code into different layers.

## Project Structure

### Application Source Code

- `controllers/`: Contains classes that handle HTTP requests and define API endpoints.
- `services/`: Contains classes implementing business logic.
- `repositories/`: Contains interfaces that extend JPARepository for data handling.
- `entities/`: Contains classes mapped to their corresponding database tables.
- `utils/`: Contains classes with utility methods reusable across the application.

## Demo

You can see a demo of the project at the following link: [Special Platforms (Backend)](url)
