# Cree una bbdd llamada “Música” con codificación utf-8.
CREATE DATABASE musica
DEFAULT CHARACTER SET utf8
DEFAULT COLLATE utf8_general_ci;

USE musica;

# Cree la tabla “Artistas”, con los siguientes campos:
# ID: número entero con 4 dígitos, autoincremental y clave primaria.
# Nombre: texto con máximo 50 caracteres y no nulo.
# País: texto tamaño fijo de 2 caracteres y no nulo.
CREATE TABLE artistas 
	(id INT(4) AUTO_INCREMENT, 
	nombre VARCHAR(50) NOT NULL, 
	pais VARCHAR(2) NOT NULL,
	PRIMARY KEY(id)
);

# Cree la tabla “Ratings”, con los siguientes campos:
# ID: número entero con 2 dígitos y clave primaria.
# Nombre: texto con máximo 50 caracteres y no nulo.
CREATE TABLE ratings 
	(id INT(2), 
	nombre VARCHAR(50) NOT NULL
);

# Cree la tabla “Canciones”, con los siguientes campos:
# ID: número entero con 4 dígitos, autoincremental y clave primaria.
# Título: texto con máximo 100 caracteres y no nulo.
# Artista: numero entero con 4 dígitos y no nulo.
# Rating: numero entero con 2 dígitos y no nulo.
CREATE TABLE canciones 
	(id INT(4) AUTO_INCREMENT, 
	titulo VARCHAR(100) NOT NULL, 
	artista INT(4) NOT NULL, 
	rating INT(2) NOT NULL,
	PRIMARY KEY(id)
);

# Inserte los siguientes registros de “Artistas”:
INSERT INTO artistas (nombre, pais) VALUES ('Aerosmith', 'US'),
('Abba', 'SE'),
 ('Timbaland', 'US'),
('Take That', 'UK'),
('Girls Aloud', 'UK'),
('Cubanismo', 'CU');

# Inserte los siguientes registros de “Rantings”:
INSERT INTO ratings (id, nombre) VALUES (3, 'Aceptable'),
(4, 'Buena'),
(5, 'Excelente');

# Inserte los siguientes registros de canciones:
('Crazy', 1, 5),
('Crazy', 1, 5), 
('En Las Delicious', 6, 5), 
('Sure', 4, 3), 
('Pray', 4, 4), 
('Another Crack In My Heart', 4, 3), 
('Apologize', 3, 4),
('Gimme Gimme Gimme', 2, 4),
('SOS', 2, 4),
('Dancing Queen', 2, 5),
('Voulez Vous', 2, 3),
('Babe', 4, 4);


# Ejecute una consulta en la que se vean todos los datos de los artistas.
SELECT * FROM artistas;

# Ejecute una consulta en la que muestre el nombre de los artistas de Estados Unidos.
SELECT * FROM artistas WHERE pais = 'US';

# Muestre la lista de las canciones que tienen un rating de 4 o mayor.
SELECT titulo FROM canciones where rating >= 4; 

# Cambie el rating 'Excelente' por 'Fantástico'.
UPDATE ratings SET nombre='Fantastico' WHERE nombre='Excelente';

# Consulta que muestra una lista con los artistas de Estados Unidos y el Reino Unido.
SELECT nombre, pais FROM artistas WHERE pais IN ('US', 'UK'); 

# Muestre una lista de canciones ordenadas alfabéticamente por su título.
SELECT titulo FROM canciones ORDER BY titulo ASC; 

# Muestre una lista de canciones en orden inverso a su introducción.
SELECT titulo FROM canciones ORDER BY id DESC; 

# Muestre una lista de 4 canciones ordenadas alfabéticamente por su título.
SELECT titulo FROM canciones ORDER BY titulo ASC LIMIT 4; 

# Muestre una lista de canciones en cuyo título aparezca la letra “g”.
SELECT titulo FROM canciones WHERE titulo LIKE '%g%'; 

# Muestre una lista de todas las canciones con su título y nombre de artista.
SELECT c.titulo, a.nombre FROM canciones c INNER JOIN artistas a ON c.artista=a.id; 

# Muestre una lista de todas las canciones con nombre de artista, título y nombre de rating.
SELECT a.nombre, c.titulo, r.nombre artista FROM canciones c INNER JOIN artistas a ON c.artista=a.id INNER JOIN ratings r ON c.rating=r.id; 

# Muestre una lista de las canciones con nombre de artista, título y nombre de rating cuyo artista no sea de Estados Unidos.
SELECT a.nombre, c.titulo, r.nombre artista FROM canciones c INNER JOIN artistas a ON c.artista=a.id INNER JOIN ratings r ON c.rating=r.id WHERE a.pais != 'US';