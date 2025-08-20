
# 📌 Foro API – Desafío con Java & Spring Boot

¡Bienvenidos y bienvenidas! 🚀
Este proyecto es parte de un desafío práctico para aplicar los conocimientos en **Java** y **Spring Boot**, construyendo una **API REST** con temática de un foro.

El objetivo es desarrollar un espacio donde las personas usuarias puedan **crear tópicos, responder preguntas y compartir sugerencias**, generando interacción dentro de una comunidad.

---

## ⚙️ Tecnologías utilizadas

* **Java 17+**
* **Spring Boot 3+**
* **Spring Data JPA**
* **Spring Security (JWT)**
* **Base de datos relacional** (PostgreSQL, MySQL o H2 para pruebas)
* **Insomnia o Postman** para pruebas de endpoints

---

## 🚀 Funcionalidades principales

1. **Listar tópicos**

    * Método: `GET /topicos`
    * Retorna todos los tópicos creados en la base de datos.

2. **Crear un tópico**

    * Método: `POST /topicos`
    * Requiere autenticación vía **JWT**.
    * Datos mínimos: `idUsuario`, `titulo`, `mensaje`, `curso`.

3. **Actualizar un tópico**

    * Método: `PUT /topicos/{id}`
    * Solo usuarios autenticados pueden actualizar.

4. **Eliminar un tópico**

    * Método: `DELETE /topicos/{id}`
    * Requiere autenticación con token válido.

5. **Autenticación de usuarios**

    * Método: `POST /auth`
    * Recibe `email` y `contraseña`.
    * Devuelve un **JWT Bearer Token** para autorización en las demás operaciones.

---

## 🔐 Seguridad

El sistema implementa **Spring Security** junto con **JSON Web Tokens (JWT)**:

* Solo usuarios registrados pueden **crear, actualizar o eliminar** tópicos.
* Los endpoints públicos como `GET /topicos` están disponibles para cualquier persona.

---

## 📋 Ejemplos de uso en Insomnia

1. **Login de usuario registrado**

   ```json
   POST /auth
   {
     "email": "usuario@ejemplo.com",
     "password": "123456"
   }
   ```

   → Respuesta:

   ```json
   {
     "token": "Bearer eyJhbGciOiJIUzI1NiIs..."
   }
   ```

2. **Crear un tópico con token válido**

   ```json
   POST /topicos
   Headers: Authorization: Bearer <token>
   {
     "titulo": "Duda sobre Spring",
     "mensaje": "¿Cómo implementar JWT en mi proyecto?",
     "curso": "Spring Boot",
     "idUsuario": 1
   }
   ```

   → Respuesta `201 Created`

---

## 📂 Organización del trabajo

El proyecto se gestiona en **Trello**, dividiendo el desafío en tareas más pequeñas que pueden moverse en el tablero según su progreso.
Cada estudiante puede personalizar su tablero y añadir más funcionalidades.

---

## 🎯 Próximos pasos

* Extender el backend con más funcionalidades (ej. comentarios, categorías, votos).
* Desarrollar un **frontend** para interactuar con la API.
* Compartir avances en comunidades y redes.

---

## 🙌 Contribución

Este desafío fomenta la **creatividad y el aprendizaje colaborativo**.
Puedes adaptar el proyecto, darle tu propio estilo y proponer nuevas ideas para enriquecer el foro.
