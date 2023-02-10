###########	--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- ###########
########### Abrir el script de la base de datos llamada “nba.sql” y ejecutarlo para crear todas las tablas e insertar datos en las mismas. ###########              
###########	--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- ###########				
					
#------------------- A continuación, se deben realizar las siguientes consultas sobre la base de datos -------------------#

# 1. Mostrar el nombre de todos los jugadores ordenados alfabéticamente.
SELECT * FROM nba.jugadores j ORDER BY j.Nombre;

# 2. Mostrar el nombre de los jugadores que sean pivots (‘C’) y que pesen más de 200 libras, ordenados por nombre alfabéticamente.
SELECT * FROM nba.jugadores j WHERE j.Posicion = 'C' AND j.Peso > 200 ORDER BY j.Nombre;

# 3. Mostrar el nombre de todos los equipos ordenados alfabéticamente.
SELECT e.Nombre FROM nba.equipos e ORDER BY e.Nombre;

# 4. Mostrar el nombre de los equipos del este (East).
SELECT e.Nombre FROM nba.equipos e WHERE e.Conferencia = 'East';

# 5. Mostrar los equipos donde su ciudad empieza con la letra ‘c’, ordenados por nombre.
SELECT e.* FROM nba.equipos e WHERE e.Ciudad LIKE 'c%' ORDER BY e.Nombre;

# 6. Mostrar todos los jugadores y su equipo ordenados por nombre del equipo.
SELECT * FROM nba.jugadores j JOIN nba.equipos e ON j.Nombre_equipo = e.Nombre ORDER BY e.Nombre;

# 7. Mostrar todos los jugadores del equipo “Raptors” ordenados por nombre.
SELECT * FROM nba.jugadores j WHERE j.Nombre_equipo = 'Raptors' ORDER BY j.Nombre;

# 8. Mostrar los puntos por partido del jugador ‘Pau Gasol’.
SELECT es.Puntos_por_partido FROM nba.jugadores j JOIN nba.estadisticas es ON j.codigo  = es.jugador WHERE j.Nombre = 'Pau Gasol' ORDER BY j.Nombre;

# 9. Mostrar los puntos por partido del jugador ‘Pau Gasol’ en la temporada ’04/05′.
SELECT es.Puntos_por_partido FROM nba.jugadores j JOIN nba.estadisticas es ON j.codigo  = es.jugador WHERE j.Nombre = 'Pau Gasol' AND es.temporada = '04/05' ORDER BY j.Nombre;

# 10. Mostrar el número de puntos de cada jugador en toda su carrera.
SELECT j.Nombre, SUM(es.Puntos_por_partido) AS Puntos_por_partido FROM nba.jugadores j JOIN nba.estadisticas es ON j.codigo  = es.jugador GROUP BY j.Nombre ORDER BY j.Nombre;

# 11. Mostrar el número de jugadores de cada equipo.
SELECT e.Nombre, COUNT(*) Cantidad_Jugadores FROM nba.equipos e LEFT JOIN nba.jugadores j ON e.Nombre = j.Nombre_equipo GROUP BY e.Nombre;

# 12. Mostrar el jugador que más puntos ha realizado en toda su carrera.
SELECT j.Nombre, SUM(es.Puntos_por_partido) AS Puntos_por_partido FROM nba.jugadores j JOIN nba.estadisticas es ON j.codigo  = es.jugador GROUP BY j.Nombre ORDER BY Puntos_por_partido DESC LIMIT 1 ;

# 13. Mostrar el nombre del equipo, conferencia y división del jugador más alto de la NBA.
SELECT e.Nombre, e.Conferencia, e.Division FROM nba.equipos e LEFT JOIN nba.jugadores j ON e.Nombre = j.Nombre_equipo WHERE j.Altura = (SELECT MAX(Altura) FROM jugadores j);

# 14. Mostrar la media de puntos en partidos de los equipos de la división Pacific.
SELECT  e.Nombre, 
		AVG(es.Puntos_por_partido) AS MediaPuntosPartidos
		FROM nba.equipos e
		JOIN nba.jugadores j 
		ON e.Nombre = j.Nombre_equipo
		JOIN nba.estadisticas es
		ON j.codigo = es.jugador
WHERE 	Division = 'Pacific'
GROUP BY e.Nombre;

select * from nba.estadisticas;

# 15. Mostrar el partido o partidos (equipo_local, equipo_visitante y diferencia) con mayordiferencia de puntos.
SELECT 
    puntos_local,
    puntos_visitante,
    ABS(puntos_local - puntos_visitante) diferenciaPuntos
FROM
    nba.partidos
WHERE
    ABS(puntos_local - puntos_visitante) IN (SELECT 
            MAX(ABS(puntos_local - puntos_visitante))
        FROM
            nba.partidos);

# 17. Mostrar los puntos de cada equipo en los partidos, tanto de local como de visitante.
SELECT 
    t.equipo,
    SUM(t.puntos_visitante) puntos_visitante,
    SUM(t.puntos_local) puntos_local
FROM
    (SELECT 
        equipo_local AS equipo,
            SUM(puntos_local) AS puntos_local,
            0 puntos_visitante
    FROM
        nba.partidos
    GROUP BY equipo UNION ALL SELECT 
        equipo_visitante AS equipo,
            0 puntos_local,
            SUM(puntos_visitante) AS puntos_visitante
    FROM
        nba.partidos
    GROUP BY equipo) t
GROUP BY t.equipo;

# 18. Mostrar quien gana en cada partido (codigo, equipo_local, equipo_visitante, equipo_ganador), en caso de empate sera null.
SELECT 
    equipo_local,
    equipo_visitante,
    CASE
        WHEN puntos_local > puntos_visitante THEN equipo_local
        WHEN puntos_local < puntos_visitante THEN equipo_visitante
    END Ganador
FROM
    nba.partidos;