package gestion;

import interfaz.Interfaz;

import java.util.Timer;
import java.util.TimerTask;

public class ActualizadorEstado extends Thread{
	private static Timer timer = new Timer();
	
	public void run(){ 
		timer.scheduleAtFixedRate(timerTask, 0, 60000);
	}
	
	//Apartado del TimerTask
	
		public static TimerTask timerTask = new TimerTask(){ 
			public void run(){ 
				Canal.refresh();
				
				Interfaz.setTxtEstadoJuego(Canal.getJuego());
				
				if(Canal.isOnline()){
					Interfaz.setTxtEstadoCanal("Online");
				}else{
					Interfaz.setTxtEstadoCanal("Offline");
				}
				
				Interfaz.setTxtEstadoSeguidores(Canal.getSeguidores());
				Interfaz.setTxtEstadoViews(Canal.getViewers());
				Interfaz.setTxtEstadoViewsTotales(Canal.getViewsTotales());
				
		    }
		};
}
