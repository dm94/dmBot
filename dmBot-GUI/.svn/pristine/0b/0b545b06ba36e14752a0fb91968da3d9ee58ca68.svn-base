package gestion;

import interfaz.*;

public class gestionInterfazPrincipal {
	
	public static void pararPrograma(){
		Interfaz.guardarConfig();
		System.exit(1);
	}
	
	public static void pararVotacion(){
		Votacion.resulVotacion(TwitchBot.getCanal());
		Config.desactivarVotacion();
		Interfaz.actualizarEstados();
	}
	

}
