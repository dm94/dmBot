package gestion;
import interfaz.Interfaz;

import java.util.ArrayList;

public class Sorteo {
	
	private static boolean sorteoEncendido;
	private static ArrayList<String> apuntados;
	
	public static void inciarSorteo(){
		sorteoEncendido=true;
		apuntados=new ArrayList<String>();
	}
	
	public static void pararSorteo(){
		sorteoEncendido=false;
	}

	public static void aniadirUsuario(String usuario){
		if(sorteoEncendido){
			if(!(estaUsuario(usuario))){
				apuntados.add(usuario);
				System.out.println("El usuario "+usuario+" ha sido apuntado al sorteo");
				Interfaz.aniadirApuntado(usuario);
			}
		}else{
			System.out.println("El sorteo no esta en marcha");
		}
	}
	
	public static String sacarGanador(){
		String ganador="";
		int totalApuntados;
		int numGanador=0;
		
		totalApuntados=apuntados.size();
		
		System.out.println("Hay un total de "+totalApuntados);
		if(totalApuntados>1){
			numGanador=(int)(Math.random()*totalApuntados);
			System.out.println("El ganador es "+numGanador);
			
			ganador=apuntados.get(numGanador).intern();
			pararSorteo(); //Apagamos el Sorteo
		}else{
			Interfaz.mostrarError("No ha nadie apuntado al sorteo");
			ganador="No ha nadie apuntado";
		}
		
		return ganador;
	}
	
	public static boolean estaUsuario(String usuario){
		boolean esta=false;
		
			for(int i=0;i<apuntados.size();i++){
				if(apuntados.get(i).equalsIgnoreCase(usuario)){
					esta=true;
				}else{
					esta=false;
				}
			}	
		
		return esta;
	}
}
