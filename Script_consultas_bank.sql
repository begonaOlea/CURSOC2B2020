
-- consulta a dos tablas
-- Iban saldo y nombre apellidos del ciente de todas las cuentas

SELECT CB.IBAN, CB.SALDO, C.NOMBRE, C.APELLIDOS
FROM CUENTAS_BANCARIAS CB , CLIENTES  C
WHERE CB.ID_CLIENTE = C.ID_CLIENTE
ORDER BY SALDO, IBAN;


-- CAMBIO NOMBRE,APELLIDOS DEL CLIENTE ID 1
SELECT *  FROM CLIENTES C WHERE C.ID_CLIENTE = 1;
-- antes Laura Blando
-- nuevo Lauras Modificado

UPDATE CLIENTES
SET NOMBRE = 'Lauras', APELLIDOS = 'Modificado'
WHERE ID_CLIENTE = 1;

-- CONSULTAR LAS CUENTAS CON SALDO SUPERIOR A 1000 Y SALDO INFERIOR A 10000
SELECT IBAN, SALDO
FROM CUENTAS_BANCARIAS
WHERE SALDO >= 1000 AND SALDO <= 10000;

--ALIAS DE COLUMNA

SELECT  ID_CLIENTE AS  NUMERO_CLIENTE,
        NOMBRE || ' '  || APELLIDOS AS NOMBRE_APELLIDO_CLIENTE
FROM CLIENTES;

SELECT SALDO + 1000 AS SALDO_MEJORADO
FROM CUENTAS_BANCARIAS;


SELECT * FROM APP.BANCOS;
SELECT * FROM BANCOS;

-- ¿QUÉ CLIENTES TIENEN CUENTAS BANCARIAS?

SELECT DISTINCT C.NOMBRE, C.APELLIDOS
FROM CUENTAS_BANCARIAS CB , CLIENTES  C
WHERE CB.ID_CLIENTE = C.ID_CLIENTE ;

-------
Dime los clientes cuyo apellido comienze por "R";

SELECT * 
FROM CLIENTES
WHERE APELLIDOS LIKE 'R%';

-- Dime los clients cuyo nombre contenga la letra 'r' o 'R'

SELECT *
FROM CLIENTES
WHERE NOMBRE LIKE '%R%' OR  NOMBRE LIKE '%r%';

-- Dime los cliente que no tienen fecha de nacimientos
SELECT *
FROM CLIENTES
WHERE FECHA_NACIMIENTO IS NULL;

-- Dime las cuentas bancarias (iban y saldo)  de los clientes con id 2 y 3
-- ordenado por iban

select iban,saldo
from CUENTAS_BANCARIAS
where ID_CLIENTE in (2,3)
order by IBAN;
 

-- Dime las cuentas bancarias cuyo saldo esté entre 400 y 5000  ambos incluidos
select * 
from CUENTAS_BANCARIAS
where  saldo between 400 and 5000;


-- Dime los clientes que pertenecen al banco id 1 y tienen fecha de 
-- nacimiento
select *
from CLIENTES
where ID_BANCO = 1 and FECHA_NACIMIENTO IS NOT  NULL;



--  Dime las cuentas bancarias de lo saldos superiores a la media
--  funcion calcular la media avg()
select iban, saldo 
from CUENTAS_BANCARIAS 
where saldo > (
        select avg(saldo) as media
        from CUENTAS_BANCARIAS
        );

--select avg(saldo) as media from CUENTAS_BANCARIAS;


-- dime las cuenta bancarias de los clientes que
-- tiene en su nombre una letra r con SUBQUERYS

-- hay una forma mejor 
select iban
from CUENTAS_BANCARIAS
where id_cliente in ( select id_cliente 
                      from CLIENTES 
                      where nombre like '%r%' );

-- la subquery  1, 3

--select id_cliente from CLIENTES where nombre like '%r%';

--select iban from CUENTAS_BANCARIAS where id_cliente in (1,3)


-- dime el nombre del banco , nombre y apellidos de todos los clientes 
select b.NOMBRE, c.NOMBRE, c.APELLIDOS
from bancos b , clientes c
where  b.ID_BANCO =  c.ID_BANCO;



-- dime cuenta iban con el saldo mayor

select  iban
from CUENTAS_BANCARIAS
where saldo = (select  max(saldo)
               from CUENTAS_BANCARIAS);

-- dime el nombre y apellido del cliente que tiene  el saldo mayor

select  iban, c.NOMBRE, c.APELLIDOS
from CUENTAS_BANCARIAS cb, CLIENTES c
where cb.ID_CLIENTE = c.ID_CLIENTE
      and saldo = (select  max(saldo)
               from CUENTAS_BANCARIAS);


-- dime saldo total  y total cuentas de todos los clientes del "Banco ZK"

select sum(saldo) as Saldo_Total, count(ID_CUENTA) as Total_cuentas
from CUENTAS_BANCARIAS cb, CLIENTES c, BANCOS b
where cb.ID_CLIENTE = c.ID_CLIENTE and c.ID_BANCO = b.ID_BANCO
      and b.NOMBRE = 'Banco ZK';

-- insertar bancos : 2  Banco AAA
-- insertar un cliente nuevo  4  Ainhoa Ramos null 2
-- insertar cuenta bancaria  4 ES6477474 5600 4

/*
insert into bancos (ID_BANCO, NOMBRE)
values (2 , 'Banco AAA');

insert into clientes 
values (4, 'Ainhora', 'Ramos', null, 2);

insert into CUENTAS_BANCARIAS 
values (4, 'ES6477474', 5600, 4);
*/

-- COUNT() ,  sum () no opera con campos null

-- dime el número total de clientes 
--  count(*) cuenta todos los registros con o sin nullos
select count(*) as total_clientes
from clientes;

select count(ID_CLIENTE) as total_clientes
from clientes;

-- dime el numero total de clientes  con fecha nacimiento
-- de dos formas distintas

select count(FECHA_NACIMIENTO) from clientes;  -- 2 . 
-- count(*) solo cuenta los no null

select count(*) from clientes where FECHA_NACIMIENTO is not null; -- 2
-- primero hace el where que filtra para darnos solo los clientes con fecha no null
-- luego hace el count(*) para contar los registros

-- dime el saldo total por cliente 
-- GROUP BY

SELECT ID_CLIENTE, COUNT(ID_CUENTA) AS TOTAL_CUENTAS, SUM(SALDO) AS TOTAL_SALDO
FROM CUENTAS_BANCARIAS
--WHERE
GROUP BY ID_CLIENTE;


-- MOSTRA EL SALDO TOTAL DE CADA BANCO
-- USA GROUP BY

--PASO 1
SELECT *
FROM BANCOS B, CLIENTES C , CUENTAS_BANCARIAS CB
WHERE B.ID_BANCO = C.ID_BANCO AND C.ID_CLIENTE = CB.ID_CLIENTE;

-- PASO 2

SELECT B.NOMBRE, SUM(CB.SALDO) AS SALDO_T, COUNT(*) AS NUM_CUENTAS_T
FROM BANCOS B, CLIENTES C , CUENTAS_BANCARIAS CB
WHERE B.ID_BANCO = C.ID_BANCO AND C.ID_CLIENTE = CB.ID_CLIENTE
GROUP BY B.NOMBRE:

-- MOSTRAR BANCOS , SALDO Y TOTAL CUENTAS 
-- QUE TENGAN UN SALDO TOTAL MAYOR QUE 15000

SELECT B.NOMBRE, SUM(CB.SALDO) AS SALDO_T, COUNT(*) AS NUM_CUENTAS_T
FROM BANCOS B, CLIENTES C , CUENTAS_BANCARIAS CB
WHERE B.ID_BANCO = C.ID_BANCO AND C.ID_CLIENTE = CB.ID_CLIENTE
      AND C.ID_CLIENTE <> 3
GROUP BY B.NOMBRE
HAVING SUM(CB.SALDO) > 15000;


-- Ejercicios


-- Mostrar  informes banco
--1   Total bancos   
--2   Total saldo por clientes (id, nombre, apellido) y banco (nombre)
--3   insertar un nuevo banco 3 con nombre 'Banco BBB'
--4   Mostrar bancos que no tienen clientes
--5   Mostrar los clientes que han nacido entre el año 1990 y 2000 


