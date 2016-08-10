# dmBot

[![GitHub release](https://img.shields.io/github/release/dm94/dmbot.svg)](https://github.com/dm94/dmBot/releases)
[![Github All Releases](https://img.shields.io/github/downloads/dm94/dmBot/total.svg)](https://github.com/dm94/dmBot/releases)
[![Twitter Follow](https://img.shields.io/twitter/follow/dm94dani.svg?style=social&label=Follow&maxAge=1)](https://twitter.com/dm94dani)

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

<h2><a name="donating">Donaciones</a></h2>
[![Donate](https://www.paypalobjects.com/en_US/i/btn/btn_donate_LG.gif)](https://paypal.me/dm94dani)<br/>
