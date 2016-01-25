# Repo/querier_threads_jdbc

### Ejercicio

Se necesita implementar un cliente JDBC en Java que reciba como argumentos/parámetros la URL, Usuario y Password de una Base de Datos (Puede ser cualquier BD, aunque de preferencia MySQL) y detecte el número óptimo de hilos que puede usar como máximo para conectarse con la BD, tomando como criterio el tiempo de respuesta de una consulta.

Por ejemplo, 

1. para 1 hilo, el tiempo de respuesta puede ser de 500ms,
2. para 2 de 450ms
3. para 3 hilos de 450ms
4. para 4 hilos de 550ms
5. para 5 hilos de 600ms

Vemos acá que el número óptimo sería 3, ya que de este valor en adelante el tiempo empieza a incrementarse.

### Para ejecutar el código

* Ejecutar los scripts de la carpeta [/scripts], por ahora en un Mysql
* Cambiar los properties del archivo [app.properties], con los parámetros de conexión pertinentes y el número de Threads que se desean probar.
* Ejecutar la clase [Initializer.java]

### HOWTO

La aplicación ejecuta un bucle de peticiones a la DB, en cada iteración se ejecuta una cantidad dinámica de hilos que se incrementan en 1 conforme la iteración avanza,es decir:

* Iteración 0 : 1 hilo
* Iteración 1 : 2 hilos
* ...
* Iteración n : n+1 hilos
 
cada hilo hace 1 consulta a base de datos y en cada iteración se suman los tiempos de respuesta de estos, luego estos resultados de todas las iteraciones se comparan, y se escoge la iteración (escenario) más óptima


[//]: # 
   [app.properties]: </src/main/resources/properties/app.properties>
   [/scripts]: </src/main/resources/scripts>
   [Initializer.java]: </src/main/java/com/gmc/devtest/Initializer.java>


