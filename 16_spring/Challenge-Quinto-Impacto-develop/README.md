# Challenge Quinto Impacto
### Santiago Alzamora
El proyecto se basa en una aplicacion para una universidad donde tenemos alumnos, profesores y cursos. Tenemos 3 ROLES: Admin, Alumno, Profesor.
`PARA EL ROL DEL ADMIN HAY QUE GENERAR UN PROFESOR Y CAMBIARLE EL ROL EN LA BASE DE DATOS A MANO`. 
Para crear cursos necesitamos tener el usuario ADMIN generado como dice arriba.

### Caracteristicas

- Registro y logueo de usuarios con sus roles especificos
- Busqueda por nombres para alumnos, profesores y cursos
- Pagina con mas detalles para cada entidad
- Eliminar curso para profesor
- Modificar datos para alumno
- Admin dashboard para Agregar cursos y tener propio seguimiento de las entidades (Falta funcionalidad de eliminar)

### Tecnologias

- Springboot (API Rest)
- React - Axios
- Sass

### Requisitos para ejecutar el proyecto

- MySQL (schema: escuela)
- Java 8
- Node para poder ejecutar la parte del front

Cliente:
- Node (npm)

```sh
npm install
npm start
```
Ruta
```sh
http://localhost:3000
```

Servidor:

- maven
- java 8

Ruta 
```sh
http://localhost:8080
```

### Aclaraciones

`La aplicacion carece de testeos unitarios. Sin embargo, para testear algunos endpoints se utilizo la aplicacion insomnia (aplicacion parecia a postman).`
Cualquier comentario se agradece.
