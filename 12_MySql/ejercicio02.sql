###########	--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- ###########
########### Abrir el script de la base de datos llamada “tienda.sql” y ejecutarlo para crear sus tablas e insertar datos en las mismas. A continuación, generar el modelo de entidad relación ###########              
###########	--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- ###########				
					
#------------------- A continuación, se deben realizar las siguientes consultas sobre la base de datos -------------------#

# 1. Lista el nombre de todos los productos que hay en la tabla producto.
SELECT p.nombre FROM producto p;

# 2. Lista los nombres y los precios de todos los productos de la tabla producto.
SELECT p.nombre, p.precio FROM producto p;

# 3. Lista todas las columnas de la tabla producto.
SELECT * FROM producto p;

# 4. Lista los nombres y los precios de todos los productos de la tabla producto, redondeando el valor del precio.
SELECT p.nombre, ROUND(p.precio) AS precio FROM producto p;

# 5. Lista el código de los fabricantes que tienen productos en la tabla producto.
SELECT f.codigo FROM fabricante f WHERE codigo in (select codigo_fabricante from producto);


# 6. Lista el código de los fabricantes que tienen productos en la tabla producto, sin mostrar los repetidos.
SELECT f.codigo FROM fabricante f WHERE exists (select 1 from producto p WHERE f.codigo = p.codigo_fabricante);

# 7. Lista los nombres de los fabricantes ordenados de forma ascendente.
SELECT f.nombre FROM fabricante f ORDER BY f.nombre;

# 8. Lista los nombres de los productos ordenados en primer lugar por el nombre de forma ascendente y en segundo lugar por el precio de forma descendente.
SELECT p.nombre FROM producto p ORDER BY p.nombre, p.precio DESC;

# 9. Devuelve una lista con las 5 primeras filas de la tabla fabricante.
SELECT f.* FROM fabricante f LIMIT 5;

# 10. Lista el nombre y el precio del producto más barato. (Utilice solamente las cláusulas ORDER BY y LIMIT)
SELECT p.nombre, p.precio FROM producto p ORDER BY p.precio LIMIT 1;

# 11. Lista el nombre y el precio del producto más caro. (Utilice solamente las cláusulas ORDER BY y LIMIT)
SELECT p.nombre, p.precio FROM producto p ORDER BY p.precio DESC LIMIT 1;

# 12. Lista el nombre de los productos que tienen un precio menor o igual a $120.
SELECT p.nombre FROM producto p WHERE p.precio <= 120;

# 13. Lista todos los productos que tengan un precio entre $60 y $200. Utilizando el operador BETWEEN.
SELECT p.* FROM producto p WHERE p.precio BETWEEN 60 AND 200;

# 14. Lista todos los productos donde el código de fabricante sea 1, 3 o 5. Utilizando el operador IN.
SELECT p.* FROM producto p WHERE p.codigo_fabricante IN (1,3,5);

# 15. Devuelve una lista con el nombre de todos los productos que contienen la cadena Portátil en el nombre.
SELECT p.nombre FROM producto p WHERE p.nombre LIKE '%Portátil%';

#------------------- Consultas Multitabla -------------------#

# 1. Devuelve una lista con el código del producto, nombre del producto, código del fabricante y nombre del fabricante, de todos los productos de la base de datos.
SELECT p.codigo, p.nombre, p.codigo_fabricante, f.nombre FROM fabricante f JOIN producto p ON f.codigo = p.codigo_fabricante;

# 2. Devuelve una lista con el nombre del producto, precio y nombre de fabricante de todos los productos de la base de datos. Ordene el resultado por el nombre del fabricante, por orden alfabético.
SELECT p.nombre, p.precio, f.nombre FROM fabricante f JOIN producto p ON f.codigo = p.codigo_fabricante ORDER BY f.nombre;

# 3. Devuelve el nombre del producto, su precio y el nombre de su fabricante, del producto más barato.
SELECT p.nombre, p.precio, f.nombre FROM fabricante f JOIN producto p ON f.codigo = p.codigo_fabricante ORDER BY p.precio LIMIT 1;
SELECT p.nombre, p.precio, f.nombre FROM fabricante f JOIN producto p ON f.codigo = p.codigo_fabricante WHERE p.precio = (SELECT MIN(p2.precio) FROM producto p2);

# 4. Devuelve una lista de todos los productos del fabricante Lenovo.
SELECT p.nombre, p.precio FROM fabricante f JOIN producto p ON f.codigo = p.codigo_fabricante WHERE f.nombre = 'Lenovo';

# 5. Devuelve una lista de todos los productos del fabricante Crucial que tengan un precio mayor que $200.
SELECT p.nombre, p.precio FROM fabricante f JOIN producto p ON f.codigo = p.codigo_fabricante WHERE f.nombre = 'Crucial' AND p.precio > 200;

# 6. Devuelve un listado con todos los productos de los fabricantes Asus, Hewlett-Packard. Utilizando el operador IN.
SELECT p.nombre, p.precio FROM fabricante f JOIN producto p ON f.codigo = p.codigo_fabricante WHERE f.nombre IN ('Asus', 'Hewlett-Packard');

# 7. Devuelve un listado con el nombre de producto, precio y nombre de fabricante, de todos los productos que tengan un precio mayor o igual a $180. Ordene el resultado en primer lugar por el precio (en orden descendente) y en segundo lugar por el nombre (en orden ascendente)
SELECT p.nombre, p.precio FROM fabricante f JOIN producto p ON f.codigo = p.codigo_fabricante WHERE f.nombre IN ('Asus', 'Hewlett-Packard');

#------------------- Consultas Multitabla utilizando las cláusulas LEFT JOIN y RIGHT JOIN.-------------------#

# 1. Devuelve un listado de todos los fabricantes que existen en la base de datos, junto con los productos que tiene cada uno de ellos. El listado deberá mostrar también aquellos fabricantes que no tienen productos asociados.
SELECT f.*, p.* FROM fabricante f LEFT JOIN producto p ON f.codigo = p.codigo_fabricante;

# 2. Devuelve un listado donde sólo aparezcan aquellos fabricantes que no tienen ningún producto asociado.
SELECT f.*, p.* FROM fabricante f LEFT JOIN producto p ON f.codigo = p.codigo_fabricante WHERE p.codigo IS NULL;

#------------------- Subconsultas (En la cláusula WHERE)  Con operadores básicos de comparación -------------------#

# 1. Devuelve todos los productos del fabricante Lenovo. (Sin utilizar INNER JOIN).
SELECT p.* FROM producto p WHERE p.codigo_fabricante = ( SELECT f.codigo FROM fabricante f WHERE f.nombre = 'Lenovo');

# 2. Devuelve todos los datos de los productos que tienen el mismo precio que el producto más caro del fabricante Lenovo. (Sin utilizar INNER JOIN).
SELECT p.* FROM producto p WHERE p.precio = (SELECT MAX(p.precio) FROM producto p WHERE p.codigo_fabricante = ( SELECT f.codigo FROM fabricante f WHERE f.nombre = 'Lenovo'));

# 3. Lista el nombre del producto más caro del fabricante Lenovo.
SELECT p.nombre FROM producto p WHERE p.precio = (SELECT MAX(p.precio) FROM producto p WHERE p.codigo_fabricante = ( SELECT f.codigo FROM fabricante f WHERE f.nombre = 'Lenovo'));

# 4. Lista todos los productos del fabricante Asus que tienen un precio superior al precio medio de todos sus productos.
SELECT p.* FROM producto p WHERE p.precio > (SELECT AVG(p.precio) FROM producto p WHERE p.codigo_fabricante = ( SELECT f.codigo FROM fabricante f WHERE f.nombre = 'Asus'));

#------------------- Subconsultas con IN y NOT IN -------------------#

# 1. Devuelve los nombres de los fabricantes que tienen productos asociados. (Utilizando IN o NOT IN).
SELECT f.nombre FROM fabricante f WHERE f.codigo IN (SELECT p.codigo_fabricante FROM producto p);

# 2. Devuelve los nombres de los fabricantes que no tienen productos asociados. (Utilizando IN o NOT IN).
SELECT f.nombre FROM fabricante f WHERE f.codigo NOT IN (SELECT p.codigo_fabricante FROM producto p);

#------------------- Subconsultas (En la cláusula HAVING) -------------------#

# 1. Devuelve un listado con todos los nombres de los fabricantes que tienen el mismo número de productos que el fabricante Lenovo.
SELECT f.nombre, COUNT(*) FROM fabricante f JOIN producto p ON f.codigo = p.codigo_fabricante GROUP BY f.nombre HAVING COUNT(*) = (SELECT COUNT(*) FROM fabricante f JOIN producto p ON f.codigo = p.codigo_fabricante WHERE f.nombre = 'Lenovo');
