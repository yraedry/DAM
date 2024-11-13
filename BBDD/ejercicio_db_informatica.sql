
# Crea una base de datos llamada Tienda
CREATE DATABASE tienda
DEFAULT CHARACTER SET utf8
DEFAULT COLLATE utf8_general_ci;


# Genera la tabla de “Fabricantes”
CREATE TABLE tienda.fabricantes (
	clave_fabricante INT auto_increment NOT NULL PRIMARY KEY,
	nombre VARCHAR(30) NULL
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;


# Genera la tabla de “Artículos”
CREATE TABLE tienda.articulos (
	clave_articulo INT auto_increment NOT NULL PRIMARY KEY,
	nombre varchar(30) NULL,
	precio INT NULL,
	clave_fabricante INT NULL
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb3
COLLATE=utf8mb3_general_ci;

#Cree una restricción de clave foranea entre la tabla padre Fabricantes y la tabla hija Articulos atraves del campo clave de fabricante.
ALTER TABLE tienda.articulos
ADD CONSTRAINT fk_clave_fabricante
FOREIGN KEY (clave_fabricante)
REFERENCES fabricantes (clave_fabricante);

# Introduce los siguientes datos en la tabla de Fabricantes:
INSERT INTO tienda.fabricantes (nombre) VALUES ('Kingston'), 
('Asus'), 
('Lexar'), 
('Nevir'), 
('Logitech');

#Introduce los siguientes datos en la tabla de “Artículos”:
INSERT INTO tienda.articulos (nombre, precio, clave_fabricante) VALUES ('Teclado', 100, 3),
('Disco Duro SSD', 370, 5),
('Memoria USB', 15, 4),
('Memoria RAM', 190, 1),
('Memoria USB', 27, 1),
('Lector tarjetas', 15, 2),
('Disco duro extraíble', 65, 5),
('DVD Rom', 85, 2),
('Mouse gaming', 45, 3),
('Tarjeta de red', 95, 3);

# Obtener todos los datos de los artículos de la tienda
SELECT * FROM tienda.articulos a;

# Obtener los nombres de los artículos de la tienda
SELECT nombre FROM tienda.articulos a;

# Obtener los nombres y precio de los artículos de la tienda
SELECT nombre, precio FROM tienda.articulos a;

# Obtener todos los datos del artículo cuya clave de producto es ‘5’
SELECT * FROM tienda.articulos a WHERE clave_articulo = 5;

# Obtener todos los datos del artículo cuyo nombre del producto es ‘’Teclado”
SELECT * FROM tienda.articulos a WHERE nombre ='Teclado';

# Obtener el nombre de los productos donde el precio sea 15€.
SELECT nombre FROM tienda.articulos a WHERE precio = 15;

# Obtener el nombre de los productos donde el precio sea mayor a 45€.
SELECT nombre FROM tienda.articulos a WHERE precio > 45;

# Obtener todos los datos de la Memoria RAM y memorias USB
SELECT * FROM tienda.articulos a WHERE nombre IN ('Memoria RAM', 'Memoria USB');

# Obtener todos los datos de los artículos cuyo precio este entre 45€ y 100€.
SELECT * FROM tienda.articulos a WHERE precio BETWEEN 45 AND 100;

# Obtener todos los datos de los artículos que empiezan con ‘M’
SELECT * FROM tienda.articulos a WHERE BINARY nombre LIKE '%M%';

# Obtener los nombres de los artículos sin repeticiones
SELECT DISTINCT nombre FROM tienda.articulos a;

# Obtener el nombre y precio de los artículos ordenados por Nombre
SELECT nombre, precio FROM tienda.articulos a ORDER BY nombre;

# Obtener todos los datos de los productos ordenados descendentemente por Precio
SELECT * from tienda.articulos a ORDER BY precio DESC;

# Obtener el nombre y precio de los artículos cuyo precio sea menor a 65€ y ordenarlos descendentemente por precio y luego ascendentemente por nombre
SELECT nombre, precio FROM tienda.articulos a WHERE precio < 65 ORDER BY precio DESC;
SELECT nombre, precio FROM tienda.articulos a WHERE precio < 65 ORDER BY nombre ASC;

# Obtener el precio medio de todos los productos.
SELECT AVG(precio) AS precio_medio FROM tienda.articulos a ;

# Obtener el precio medio de los artículos cuyo código de fabricante sea 3.
SELECT AVG(precio) AS precio_medio FROM tienda.articulos a WHERE clave_fabricante = 3;

# Obtener el nombre de los artículos y su precio medio
SELECT nombre, AVG(precio) AS precio_medio FROM tienda.articulos a GROUP BY nombre;

# Obtener un listado completo de los productos, incluyendo por cada artículo los datos del artículo y del fabricante
SELECT * FROM tienda.articulos a INNER JOIN tienda.fabricantes f ON a.clave_fabricante =f.clave_fabricante ;

# Obtener la clave de producto, nombre del producto y nombre del fabricante de todos los productos en venta
SELECT a.clave_articulo, a.nombre, f.nombre FROM tienda.articulos a INNER JOIN tienda.fabricantes f ON a.clave_fabricante =f.clave_fabricante ;

# Obtener el nombre y precio de los artículos donde el fabricante sea Logitech ordenarlos alfabéticamente por nombre del producto
SELECT a.nombre, a.precio from tienda.articulos a INNER JOIN tienda.fabricantes f ON a.clave_fabricante =f.clave_fabricante WHERE f.nombre ='Logitech' ORDER BY a.nombre ASC;

# Obtener el nombre, precio y nombre de fabricante de los productos que son marca Lexar o Kingston ordenados descendentemente por precio
SELECT a.nombre, a.precio, f.nombre from tienda.articulos a INNER JOIN tienda.fabricantes f ON a.clave_fabricante =f.clave_fabricante WHERE f.nombre IN ('Lexar', 'Kingston') ORDER BY a.precio DESC;

# Añade un nuevo artículo con clave 11, Altavoces de 55€ del fabricante 2.
INSERT INTO tienda.articulos (nombre, precio, clave_fabricante) VALUES ('Altavoces', 55, 2);

# Cambia el nombre del producto 8 a ‘Impresora Láser’
UPDATE tienda.articulos SET nombre ='Impresora Laser' WHERE clave_articulo = 8;

# Aplicar un descuento del 10% a todos los productos.
UPDATE tienda.articulos SET precio = precio * 0.9;

# Aplicar un descuento de 10€ a todos los productos cuyo precio sea igual o mayor a 100€.
UPDATE tienda.articulos SET precio = precio - 10 WHERE precio >=100;

# Borra el producto numero 6.
DELETE FROM tienda.articulos WHERE clave_articulo=6;