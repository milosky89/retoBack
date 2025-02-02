# Ejercicio técnico LuloX - Automatización Backend

## Descripción
Este proyecto implementa pruebas automatizadas para interactuar con una API REST utilizando **Serenity BDD Screenplay**, **Cucumber**, y **Rest Assured**. 
Se realizan pruebas sobre los principales verbos HTTP (**GET, POST, DELETE**) con validaciones sobre las respuestas obtenidas.

## 📌 Stack Tecnológico
- **Java 17 o superior**
- **Gradle** para la gestión de dependencias
- **Serenity BDD Screenplay 4 o superior**
- **Serenity BDD Screenplay Webdriver 4 o superior**
- **Cucumber 4 o superior con Serenity BDD**
- **Rest Assured con Serenity BDD Screenplay**
- **Hamcrest** para validaciones

## 🚀 Endpoints a Probar
| Método  | Endpoint  | Descripción |
|---------|----------|-------------|
| **GET**  | `http://dummy.restapiexample.com/api/v1/employees`  | Obtener la lista de empleados |
| **POST** | `http://dummy.restapiexample.com/api/v1/create` | Crear un nuevo empleado |
| **GET**  | `http://dummy.restapiexample.com/api/v1/employee/1`  | Obtener un empleado por ID |
| **DELETE** | `http://dummy.restapiexample.com/api/v1/delete/2` | Eliminar un empleado |

## ⚙️ Configuración y Ejecución

1. **Clonar el repositorio**  
   Ejecuta el siguiente comando en tu terminal:  
   ```sh
   git clone https://github.com/milosky89/retoBack.git

2. **Ingresa al directorio del proyecto**
    ```sh
    cd tu_repositorio

3. **Compilar proyecto**
    ```sh
    ./gradlew clean build

4. **Ejecución de pruebas**
    ```sh
    ./gradlew clean test aggregate
