# Sistema de Gestión de Inventario API

API RESTful para la gestión de inventario desarrollada con Spring Boot.

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.4.4**
- **Spring Data JPA**
- **PostgreSQL**
- **Lombok**
- **Docker & Docker Compose**
- **Swagger UI** (Documentación API)

## Características

### Gestión de Categorías
- Crear, leer, actualizar y eliminar categorías
- Asociar subcategorías a categorías
- Validación de campos requeridos

### Gestión de Subcategorías
- Crear, leer, actualizar y eliminar subcategorías
- Asociación con categorías padre
- Validación de campos requeridos

### Gestión de Productos
- Crear, leer, actualizar y eliminar productos
- Asociación con categorías y subcategorías
- Control de inventario (stock)
- Precios con precisión decimal (BigDecimal)
- Validación de campos requeridos

### Gestión de Ventas
- Crear, leer, actualizar y eliminar ventas
- Gestión de items de venta
- Cálculo automático de subtotales
- Control de stock al realizar ventas
- Fechas y montos con precisión

## Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   └── com/alejandro/inventory/
│   │       ├── controller/     # Controladores REST
│   │       ├── model/          # Entidades JPA
│   │       ├── repository/     # Repositorios JPA
│   │       └── services/       # Lógica de negocio
│   └── resources/
│       └── application.yml     # Configuración
```

## Docker

El proyecto utiliza Docker para facilitar el despliegue y desarrollo:

### Requisitos
- Docker
- Docker Compose

### Estructura Docker
- **inventory-api**: Contenedor de la aplicación Spring Boot
- **postgres**: Base de datos PostgreSQL

### Comandos Docker

```bash
# Construir y levantar los contenedores
docker-compose up --build

# Detener los contenedores
docker-compose down

# Ver logs
docker-compose logs -f
```

## 🔧 Configuración

### Variables de Entorno
- `SPRING_DATASOURCE_URL`: URL de conexión a PostgreSQL
- `SPRING_DATASOURCE_USERNAME`: Usuario de PostgreSQL
- `SPRING_DATASOURCE_PASSWORD`: Contraseña de PostgreSQL
- `SPRING_JPA_HIBERNATE_DDL_AUTO`: Modo de actualización de esquema

### Base de Datos
- PostgreSQL 16
- Esquema generado automáticamente por Hibernate
- Configuración de conexión en `application.yml`

## Documentación API

La documentación de la API está disponible a través de Swagger UI:
- URL: `http://localhost:8080/swagger-ui.html`
- Incluye descripción de endpoints, modelos y ejemplos

## Seguridad

- Validación de datos de entrada
- Manejo de excepciones
- Prevención de inyección SQL
- Validación de relaciones entre entidades

## Despliegue

1. Clonar el repositorio
2. Configurar variables de entorno
3. Ejecutar `docker-compose up --build`
4. Acceder a la API en `http://localhost:8080`

## Endpoints Principales

### Categorías
- `GET /categories` - Listar todas las categorías
- `GET /categories/{id}` - Obtener categoría por ID
- `POST /categories` - Crear nueva categoría
- `PUT /categories/{id}` - Actualizar categoría
- `DELETE /categories/{id}` - Eliminar categoría

### Subcategorías
- `GET /subcategories` - Listar todas las subcategorías
- `GET /subcategories/{id}` - Obtener subcategoría por ID
- `POST /subcategories` - Crear nueva subcategoría
- `PUT /subcategories/{id}` - Actualizar subcategoría
- `DELETE /subcategories/{id}` - Eliminar subcategoría

### Productos
- `GET /products` - Listar todos los productos
- `GET /products/{id}` - Obtener producto por ID
- `POST /products` - Crear nuevo producto
- `PUT /products/{id}` - Actualizar producto
- `DELETE /products/{id}` - Eliminar producto

### Ventas
- `GET /sales` - Listar todas las ventas
- `GET /sales/{id}` - Obtener venta por ID
- `POST /sales` - Crear nueva venta
- `PUT /sales/{id}` - Actualizar venta
- `DELETE /sales/{id}` - Eliminar venta


## 📄 Licencia

Creado por Alejandro Montaño Quintero
