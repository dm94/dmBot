Para usar este bot necesitas crear una cuenta IRC en https://www.quakenet.org/
config.txt = Aqui va la configuracion del bot y si no esta el archivo es recomendable abrir el bot para crearlo

El bot actualmente esta en alpha por lo que puede que tenga algunos fallos.

Fallos Conocidos y Soluciones:

Fallo en leer el archivo - Borrar el archivo config
Fallo en la conexion - Asegurate de no estar conectado mas de 2 veces al chat o IRC

Comandos disponibles para el bot:

@online : Dice si esta online o no
@help : Te muestra los comandos disponibles
@autor : Muestra informacion sobre el autor del bot
@genkey : Genera una key aleatoria si esta activa la funcion

--Funciones Globales
@exit :  Para por completo el bot
@status : Muestra las caracteristicas que estan activadas

--Caracteristica Mod Links

@ml-on: Enciende la moderacion de links
@ml-off: Apaga la moderacion de links

--Caracteristica GenKey

@gk-on : Activa esta funcion
@gk-off : Desactiva esta funcion

--Caracteristica Sorteo

@sorteo-on : Activa el sorteo y los usuarios pueden apuntarse
@sorteo-off : Los usuarios ya no podran apuntarse
@ganador : Para el sorteo y saca un ganador, si lo pones de nuevo vuelva a sacar otro ganador

--Caracteristica Votacion

@votacion "Texto": Inicia la votacion
@resultado: Para la votacion y muestra el resultado

El bot cadece de interfaz grafica por lo que se ejecuta poniendo en la consola/terminal:
java -mx30M -jar dmBot.jar

Log:

14/09/2015:
- Primera Versión.

v1.1 - 16/09/2015:
- Mejorada la estabilidad del programa.
- Arreglado un bug por el solo se comprobaba si los canales estaban online la primera vez.

v2 - 17/09/2015:
- Rediseñado el bot para mejorar la estabilidad y poder añadirle nuevas funciones
- Añadido un generador de keys aleatorias como nueva caracteristica
- Cambio del nombre de ahBot a dmBot (Ya no solo servira para hacer autohost).
- Añadido la funcion de sorteo

v2.1 - 18/09/2015:
- Añadido control de varias excepciones.
- Cambiado la captura del archivo de configuracion

v2.2 - 19/09/2015:
- Añadida la caracteristica de votaciones.

v2.3 - 22/09/2015:
-Mejorada la estabilidad del sistema.
-Cambio de comandos y adicion de nuevos.
-Añadida funcion auto saludar

v2.5 - 20/10/2015:
-Restructurado el bot para que funcione en Azubu.
-Desde ahora en adelante el bot tendra dos versiones la de Twitch y la de Azubu

v3.1 - 03/11/2015:

-Añadido interfaz lo que permite añadir mas funciones
-Añadido chat del bot
-Rediseñado el codigo para mejorar su rendimiento
-La versión de Twitch ha sido abandonada.
-Arreglados diferentes errores

v3.2 - 16/11/2015:

-Arreglados diferentes fallos
-Añadido una version Debug
-Mejora de la interfaz
