## Enunciado

En una intersección con semáforos hay una situación
algo irregular ya una de las 4 vías que entra viene desde una autopista y la
concurrencia de automóviles de 5 veces mas que las otras vías.


Para resolver este problema se desea crear
un programa que simule mediante hilos esta situación para ello vas a tener 4
listas que simulen las entradas a la intersección donde se van a colocar coches,
una de estas listas se va a agregar un coche cada 100 milisegundos como máximo y
en las otras cada 500 milisegundos como máximo.


El semáforo mientras tenga luz verde en el
carril va a eliminar coches de la lista cada 200 milisegundos. Y según los cálculos
va a cambiar la luz cada 5 segundos excepto en la de alta concurrencia que va a
permanecer encendida por 10.


Ejecuta este proceso por 150 segundos y
muestra la cantidad de coches que hay en espera al terminar en cada carril.