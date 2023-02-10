# Llegó el momento de poner a prueba nuestros conocimientos de bases de datos, para ello nos 
# han propuesto el siguiente desafío:
# Tenemos que adivinar la clave y posición de una caja fuerte. El cerrojo consta de 4 candados, 
# cada candado tiene de clave, un número que puede ser de más de 1 cifra y una posición que 
# puede ir desde 1 a 4.
# Nosotros tenemos los 4 candados en la mano (Candado A, Candado B, Candado C y Candado D) 
# debemos averiguar la posición de cada candado y la clave del mismo.



#------------------------- CANDADO A -------------------------#

# Posición: El candado A está ubicado en la posición calculada a partir del número obtenido en la/s
# siguiente/s consulta/s:

# Teniendo el máximo de asistencias por partido, muestre cuantas veces se logró dicho máximo.
# Este resultado nos dará la posición del candado (1, 2, 3 o 4)
SELECT COUNT(*) POSICION FROM nba.estadisticas WHERE Asistencias_por_partido IN (SELECT MAX(Asistencias_por_partido) FROM nba.estadisticas);

# Clave: La clave del candado A estará con formada por la/s siguientes consulta/s a la base de 
# datos:
# Muestre la suma total del peso de los jugadores, donde la conferencia sea Este y la posición sea 
# centro o esté comprendida en otras posiciones.
SELECT 
    SUM(j.Peso) PesoTotal
FROM
    nba.jugadores j
        JOIN
    nba.equipos e ON j.Nombre_equipo = e.Nombre
WHERE
    e.Conferencia = 'East'
        AND j.Posicion LIKE '%C%';
        
# CANDADO B
# Posición: El candado B está ubicado en la posición calculada a partir del número obtenido en la/s
# siguiente/s consulta/s:
# Muestre la cantidad de jugadores que poseen más asistencias por partidos, que el numero de 
# jugadores que tiene el equipo Heat. 
# Este resultado nos dará la posición del candado (1, 2, 3 o 4) 
SELECT 
    COUNT(*)
FROM
    nba.estadisticas
WHERE
    Asistencias_por_partido > (SELECT 
            COUNT(*)
        FROM
            nba.jugadores
        WHERE
            Nombre_equipo = 'heat');

# Clave: La clave del candado B estará con formada por la/s siguientes consulta/s a la base de 
# datos:
# La clave será igual al conteo de partidos jugados durante las temporadas del año 1999.
SELECT 
    COUNT(1)
FROM
    nba.partidos
WHERE
    temporada LIKE '%99%';

# CANDADO C
# Posición: El candado C está ubicado en la posición calculada a partir del número obtenido en la/s
# siguiente/s consulta/s:
# La posición del código será igual a la cantidad de jugadores que proceden de Michigan y forman 
# parte de equipos de la conferencia oeste. 
# Al resultado obtenido lo dividiremos por la cantidad de jugadores cuyo peso es mayor o igual a 
# 195, y a eso le vamos a sumar 0.9945.
# Este resultado nos dará la posición del candado (1, 2, 3 o 4)

SELECT 
    COUNT(*) / (SELECT 
            COUNT(*)
        FROM
            nba.jugadores
        WHERE
            peso >= 195) + 0.9945 AS Total
FROM
    nba.jugadores j
WHERE
    j.Procedencia = 'Michigan'
        AND Nombre_equipo IN (SELECT 
            Nombre
        FROM
            nba.equipos
        WHERE
            Conferencia = 'West');

# Clave: La clave del candado B estará con formada por la/s siguientes consulta/s a la base de 
# datos:
# Para obtener el siguiente código deberás redondear hacia abajo el resultado que se devuelve de 
# sumar: el promedio de puntos por partido, el conteo de asistencias por partido, y la suma de 
# tapones por partido. Además, este resultado debe ser, donde la división sea central.

SELECT 
    FLOOR(AVG(Puntos_por_partido) + SUM(Asistencias_por_partido) + SUM(Tapones_por_partido)) Total
FROM
    nba.estadisticas
WHERE
    jugador IN (SELECT 
            j.codigo
        FROM
            jugadores j
                JOIN
            equipos e ON j.Nombre_equipo = e.Nombre
        WHERE
            e.Division = 'Central');  

# CANDADO D
# Posición: El candado D está ubicado en la posición calculada a partir del número obtenido en la/s 
# siguiente/s consulta/s: 
# Muestre los tapones por partido del jugador Corey Maggette durante la temporada 00/01. Este 
# resultado debe ser redondeado. Nota: el resultado debe estar redondeado
# Este resultado nos dará la posición del candado (1, 2, 3 o 4)
SELECT 
    ROUND(tapones_por_partido)
FROM
    nba.estadisticas
WHERE
    temporada = '00/01'
        AND jugador = (SELECT 
            codigo
        FROM
            jugadores
        WHERE
            Nombre = 'Corey Maggette');

# Clave: La clave del candado D estará con formada por la/s siguientes consulta/s a la base de 
# datos: 
# Para obtener el siguiente código deberás redondear hacia abajo, la suma de puntos por partido 
# de todos los jugadores de procedencia argentina
SELECT FLOOR(SUM(puntos_por_partido)) Total FROM ESTADISTICAS WHERE jugador IN (SELECT CODIGO FROM jugadores j WHERE Procedencia = 'Argentina');
;

# Candado A -> Posicion = 2 -> Clave = 14043
# Candado B -> Posicion = 3 -> Clave = 3480
# Candado C -> Posicion = 1 -> Clave = 1038
# Candado D -> Posicion = 4 -> Clave = 191


