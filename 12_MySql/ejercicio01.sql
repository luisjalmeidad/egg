###########	--------------------------------------------------------------------------------------------------------------------------------------------------------------------- ###########
########### Abrir el script llamado “personal” y ejecutarlo de modo tal que se cree la base de datos  “personal”, se creen las tablas y se inserten todos los datos en las tablas ###########              
###########	--------------------------------------------------------------------------------------------------------------------------------------------------------------------- ###########				
					
#------------------- A continuación, realizar las siguientes consultas sobre la base de datos personal -------------------#

# 1. Obtener los datos completos de los empleados.
SELECT * FROM empleados emp;

# 2. Obtener los datos completos de los departamentos.
SELECT * FROM departamentos dep;

# 3. Listar el nombre de los departamentos.
SELECT nombre_depto FROM departamentos;

# 4. Obtener el nombre y salario de todos los empleados.
SELECT nombre, salario FROM empleados;

# 5. Listar todas las comisiones.
SELECT emp.comision_emp FROM empleados emp;

# 6. Obtener los datos de los empleados cuyo cargo sea ‘Secretaria’.
SELECT emp.* FROM empleados emp WHERE emp.cargo_emp = 'Secretaria';

# 7. Obtener los datos de los empleados vendedores, ordenados por nombre alfabéticamente.
SELECT emp.* FROM empleados emp WHERE emp.cargo_emp = 'Vendedor' ORDER BY emp.nombre;

# 8. Obtener el nombre y cargo de todos los empleados, ordenados por salario de menor a mayor.
SELECT emp.nombre, emp.cargo_emp FROM empleados emp ORDER BY emp.sal_emp;

# 9. Obtener el nombre de o de los jefes que tengan su departamento situado en la ciudad de “Ciudad Real”
SELECT dep.nombre_jefe_depto FROM departamentos dep WHERE ciudad = 'Ciudad Real';

# 10. Elabore un listado donde para cada fila, figure el alias ‘Nombre’ y ‘Cargo’ para las respectivas tablas de empleados.
SELECT emp.nombre AS Nombre, emp.cargo_emp AS Cargo FROM empleados emp;

# 11. Listar los salarios y comisiones de los empleados del departamento 2000, ordenado por comisión de menor a mayor.
SELECT emp.sal_emp, emp.comision_emp FROM empleados emp WHERE emp.id_depto = 2000 ORDER BY emp.comision_emp;

# 12. Obtener el valor total a pagar a cada empleado del departamento 3000, que resulta de: sumar el salario y la comisión, más una bonificación de 500. Mostrar el nombre del empleado y el total a pagar, en orden alfabético.
SELECT emp.nombre, emp.sal_emp + emp.comision_emp + 500 AS total FROM empleados emp WHERE emp.id_depto = 3000 ORDER BY emp.nombre;

# 13. Muestra los empleados cuyo nombre empiece con la letra J.
SELECT emp.* FROM empleados emp WHERE nombre LIKE 'J%';

# 14. Listar el salario, la comisión, el salario total (salario + comisión) y nombre, de aquellos empleados que tienen comisión superior a 1000.
SELECT emp.sal_emp , emp.comision_emp, emp.sal_emp + emp.comision_emp AS total, emp.nombre FROM empleados emp WHERE emp.comision_emp > 1000;

# 15. Obtener un listado similar al anterior, pero de aquellos empleados que NO tienen comisión.
SELECT emp.sal_emp , emp.comision_emp, emp.sal_emp + emp.comision_emp AS total, emp.nombre FROM empleados emp WHERE emp.comision_emp = 0;

# 16. Obtener la lista de los empleados que ganan una comisión superior a su sueldo.
SELECT emp.* FROM empleados emp WHERE emp.comision_emp > emp.sal_emp;

# 17. Listar los empleados cuya comisión es menor o igual que el 30% de su sueldo.
SELECT emp.* FROM empleados emp WHERE emp.comision_emp <= emp.sal_emp * 0.3;

# 18. Hallar los empleados cuyo nombre no contiene la cadena “MA”
SELECT * FROM empleados emp WHERE emp.nombre NOT LIKE '%MA%';

# 19. Obtener los nombres de los departamentos que sean “Ventas”, “Investigación” o ‘Mantenimiento.
SELECT dep.nombre_depto FROM departamentos dep WHERE dep.nombre_depto IN ('Ventas', 'Investigacion', 'Mantenimiento');

# 20. Ahora obtener el contrario, los nombres de los departamentos que no sean “Ventas” ni “Investigación” ni ‘Mantenimiento.
SELECT dep.nombre_depto FROM departamentos dep WHERE dep.nombre_depto NOT IN ('Ventas', 'Investigacion', 'Mantenimiento');

# 21. Mostrar el salario más alto de la empresa.
SELECT MAX(emp.sal_emp) AS salarioMax FROM empleados emp;

# 22. Mostrar el nombre del último empleado de la lista por orden alfabético.
SELECT MAX(emp.nombre) FROM empleados emp;

# 23. Hallar el salario más alto, el más bajo y la diferencia entre ellos.
SELECT salarioMax, salarioMin, salarioMax - salarioMin AS diferenciaSalario from (SELECT MAX(emp.sal_emp) AS salarioMax, MIN(emp.sal_emp) AS salarioMin  FROM empleados emp) salarios;

# 24. Hallar el salario promedio por departamento.
SELECT emp.id_depto, AVG(emp.sal_emp) AS salarioPromedio FROM empleados emp GROUP BY emp.id_depto;

#------------------- Consultas con Having -------------------#

# 25. Hallar los departamentos que tienen más de tres empleados. Mostrar el número de empleados de esos departamentos.
SELECT emp.id_depto, COUNT(*) AS numEmpleados FROM empleados emp GROUP BY emp.id_depto HAVING COUNT(*) > 3;

# 26. Hallar los departamentos que no tienen empleados
SELECT emp.id_depto, COUNT(*) AS numEmpleados FROM empleados emp GROUP BY emp.id_depto HAVING COUNT(*) < 1;

#------------------- Consulta Multitabla (Uso de la sentencia JOIN/LEFT JOIN/RIGHT JOIN) -------------------#

# 27. Mostrar la lista de empleados, con su respectivo departamento y el jefe de cada departamento.
 SELECT emp.nombre,
		emp.sex_emp,
		emp.fec_nac,
		emp.sal_emp,
		emp.comision_emp,
		emp.cargo_emp,
		dep.nombre_depto,
		dep.nombre_jefe_depto
FROM departamentos dep
LEFT JOIN empleados emp ON dep.id_depto = dep.id_depto;

#------------------- Consulta con Subconsulta -------------------#

# 28. Mostrar la lista de los empleados cuyo salario es mayor o igual que el promedio de la empresa. Ordenarlo por departamento.
SELECT * FROM empleados emp WHERE emp.sal_emp >= (SELECT AVG(emp2.sal_emp) FROM empleados emp2) ORDER BY emp.id_depto;