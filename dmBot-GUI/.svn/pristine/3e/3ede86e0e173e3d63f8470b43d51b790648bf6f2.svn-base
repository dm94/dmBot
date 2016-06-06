package gestion;
import interfaz.Interfaz;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import org.jibble.pircbot.*;

/*
 * Esta Clase es el bot una vez iniciada siempre esta activada, se encarga de leer el chat y decidir que hacer
 * en funcion del comando que envien por el chat.
 */

public class TwitchBot extends PircBot{
	private static String canal;
	private static String admin;
	private static int i=0;
	private static String keyword="@gzone";
	
	//Para que cambien los !comandos solo hace falta que esos comandos no llegen a estar definidos.
	
	public TwitchBot(){
		this.setName("noname");
		canal="noname";
		admin="";
		keyword="@gzone";
	}
	

	public TwitchBot(String nombre, String canalconect,String admin){
		this.setName(nombre);
		this.canal=canalconect;
		this.admin=admin;
	}
	
	public static String getCanal(){
		return canal;
	}
	
	public void onMessage(String channel,String sender, String login, String hostname, String message) {
		//Caracteristica GneradorKeys
		if(message.contains("@gk-on")){
			if(sender.equalsIgnoreCase(admin) || sender.equalsIgnoreCase(canal)){
				Interfaz.mandarMensaje(canal, "GenKey Encendido");
				Config.activarGenKey();
				Interfaz.actualizarEstados();
			}else{
				Interfaz.mandarMensaje(canal, "No tienes permiso para realizar ese comando.");
			}
		}else if(message.contains("@gk-off")){
			if(sender.equalsIgnoreCase(admin) || sender.equalsIgnoreCase(canal)){
				Interfaz.mandarMensaje(canal, "GenKey Apagado");
				Config.desactivarGenKey();
				Interfaz.actualizarEstados();
			}else{
				Interfaz.mandarMensaje(canal, "No tienes permiso para realizar ese comando.");
			}
		}else if(message.contains("@genkey")){
			if(Config.isGenKey()){
				Interfaz.mandarMensaje(canal, "Clave Generada de forma aleatoria: "+GenKey.devolverKey().toUpperCase());
			}
		}
		//Apartado Sorteo
		else if(message.contains("@sorteo-on")){
			if(sender.equalsIgnoreCase(admin) || sender.equalsIgnoreCase(canal)){
				Interfaz.mandarMensaje(canal, "Sorteo en marcha para participar poned: "+keyword);
				Sorteo.inciarSorteo();
				Config.activarSorteo();
				Interfaz.actualizarEstados();
			}else{
				Interfaz.mandarMensaje(canal, "No tienes permiso para realizar ese comando.");
			}
		}else if(message.contains("@sorteo-off")){
			if(sender.equalsIgnoreCase(admin) || sender.equalsIgnoreCase(canal)){
				Sorteo.pararSorteo();
				Interfaz.mandarMensaje(canal, "Ya no es posible apuntarse, pon @ganador para elegir a un ganador.");
				Config.desactivarSorteo();
				Interfaz.actualizarEstados();
			}else{
				Interfaz.mandarMensaje(canal, "No tienes permiso para realizar ese comando.");
			}
		}else if(message.contains("@ganador")){
			if(sender.equalsIgnoreCase(admin) || sender.equalsIgnoreCase(canal)){
				String ganador;
				ganador=Sorteo.sacarGanador();
				Interfaz.mandarMensaje(canal, "El ganador del Sorteo es @"+ganador);
				Config.desactivarSorteo();
				Interfaz.actualizarEstados();
			}
		}else if(message.contains(keyword)){
			if(Config.isSorteo()){
				Sorteo.aniadirUsuario(sender);
			}
		}
		//Caracteristica Votacion
		else if(message.indexOf("@votacion")!=-1){
			if(sender.equalsIgnoreCase(admin) || sender.equalsIgnoreCase(canal)){
				Votacion.iniciarVotacion(message);
				Interfaz.mandarMensaje(canal, "La votacion por \""+Votacion.getMensaje()+"\" ha empezado");
				Interfaz.mandarMensaje(canal, "Poned +1 para Votos a favor");
				Interfaz.mandarMensaje(canal, "Poned -1 para Votos en contra");
				Config.activarVotacion();
				Interfaz.actualizarEstados();
			}
		}else if(message.contains("@resultado")){
			if(sender.equalsIgnoreCase(admin) || sender.equalsIgnoreCase(canal)){
				Votacion.resulVotacion(canal);
				Config.desactivarVotacion();
				Interfaz.actualizarEstados();
			}
		}else if(message.contains("+1")){
			if(Config.isVotacion()){
				Votacion.votoAFavor(sender);
			}
		}else if(message.contains("-1")){
			if(Config.isVotacion()){
				Votacion.votoEnContra(sender);
			}
		}
		//Moderacion de links
		else if(message.contains("http") && !(sender.equalsIgnoreCase(admin)) && !(sender.equalsIgnoreCase(canal))){
			if(Config.isModLinks()){
				Interfaz.mandarMensaje(canal, ".clear "+sender);
				Interfaz.mandarMensaje(canal, "Estan prohibidos el uso de links");
			}
		}else if(message.contains("www") && !(sender.equalsIgnoreCase(admin)) && !(sender.equalsIgnoreCase(canal))){
			if(Config.isModLinks()){
				Interfaz.mandarMensaje(canal, ".clear "+sender);
				Interfaz.mandarMensaje(canal, "Estan prohibidos el uso de links");
			}
		}else if(message.contains("@ml-on")){
			if(sender.equalsIgnoreCase(admin) || sender.equalsIgnoreCase(canal)){
				Config.activarModLinks();
				Interfaz.mandarMensaje(canal, "Se ha activado la moderacion de links");
				Interfaz.actualizarEstados();
			}else{
				Interfaz.mandarMensaje(canal, "No tienes permiso para realizar ese comando.");
			}
		}else if(message.contains("@ml-off")){
			if(sender.equalsIgnoreCase(admin) || sender.equalsIgnoreCase(canal)){
				Config.desactivarModLinks();
				Interfaz.mandarMensaje(canal, "Se ha desactivado la moderacion de links");
				Interfaz.actualizarEstados();
			}else{
				Interfaz.mandarMensaje(canal, "No tienes permiso para realizar ese comando.");
			}
		}
		//Apartado Global
		else if(message.contains("@exit")){
			if(sender.equalsIgnoreCase(admin) || sender.equalsIgnoreCase(canal)){
				Interfaz.guardarConfig();
				System.exit(1); 
			}else{
				Interfaz.mandarMensaje(canal, "No tienes permiso para realizar ese comando.");
			}
		}else if(message.contains("@status")){
			if(sender.equalsIgnoreCase(admin) || sender.equalsIgnoreCase(canal)){
				if(Config.isGenKey()){
					Interfaz.mandarMensaje(canal, "GenKey: ON");
				}else{
					Interfaz.mandarMensaje(canal, "GenKey: OFF");
				}
				if(Config.isSorteo()){
					Interfaz.mandarMensaje(canal, "Sorteo: ON");
				}else{
					Interfaz.mandarMensaje(canal, "Sorteo: OFF");
				}
				if(Config.isVotacion()){
					Interfaz.mandarMensaje(canal, "Votacion: ON");
				}else{
					Interfaz.mandarMensaje(canal, "Votacion: OFF");
				}
				if(Config.isModLinks()){
					Interfaz.mandarMensaje(canal, "Moderador Links: ON");
				}else{
					Interfaz.mandarMensaje(canal, "Moderador Links: OFF");
				}
			}else{
				Interfaz.mandarMensaje(canal, "No tienes permiso para realizar ese comando.");
			}
		}else if(message.contains("@help")){
			Interfaz.mandarMensaje(canal, "Los comandos disponibles son @online,@help,@autor,@genkey.");
			if(sender.equalsIgnoreCase(admin) || sender.equalsIgnoreCase(canal)){
				Interfaz.mandarMensaje(canal, "Comandos Globales: @status,@exit");
				Interfaz.mandarMensaje(canal, "Comandos de GeneradorKeys: @gk-(on|off).");
				Interfaz.mandarMensaje(canal, "Comandos de Sorteo: @sorteo-(on|off),@ganador.");
				Interfaz.mandarMensaje(canal, "Comandos de Votacion: @votacion,@resultado.");
				Interfaz.mandarMensaje(canal, "Comandos de Moderacon de Links: @ml-on,@ml-off.");
			}
		//Apartado para usuarios normales
		}else if(message.contains("@online")){
			Interfaz.mandarMensaje(canal, "Estoy conectado");
		}else if(message.contains("@autor")){
			Interfaz.mandarMensaje(canal, "El creador de este programa es Dm94 y es para uso exclusivo de la Comunidad GZone: http://gzone.es/");
		}else if(message.contains("hola") || (message.contains("hello"))){
			if(Config.isAutoSaludo()){
				Interfaz.mandarMensaje(canal, "Hola @"+sender);
			}
		}
		Interfaz.aniadirMensajeChat(sender,message);
	}
	
	public static void setKeyWord(String key){
		keyword=key;
	}
}
