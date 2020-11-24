
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


