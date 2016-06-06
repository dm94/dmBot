package gestion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

//API para ver los usuarios y rangos: http://tmi.twitch.tv/group/user/CANAL/chatters
//API para sacar mucha informacion acerca de los streams https://api.twitch.tv/kraken/streams/CANAL

public class Canal {
    private static String canal;
    private static String admin;
    private static String usuarioIRC;
    private static String passIRC;
    private static String idiomaIRC;
    private static boolean online = false;
    private static String juego;
    private static String viewers;
    private static String titulo;
    private static String seguidores;
    private static String viewsTotales;
    private static URL url;
    private static BufferedReader reader;
    
    public Canal(){
    	canal="";
    	admin="";
    	usuarioIRC="";
    	passIRC="";
    	idiomaIRC="";
    	online=false;
    	juego="";
    	viewers="";
    	titulo="";
    	seguidores="";
    	viewsTotales="";
    }

	public Canal(String channel){
        this.canal = channel;
 
        refresh();
    }
 
    public static void refresh(){ //Para saber si esta online o no
    	String estadoAr="";
    	String juegoAr="";
    	String seguidoresAr="";
    	String viewsAr="";
    	String viewsTotalesAr="";
    	int inicio;
    	int fin;
    	
        try {
            url = new URL("http://api.azubu.tv/public/channel/"+canal+"/info"); //Bukkit automatically adds the URL tags, remove them when you copy the class
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
 
            String cad=reader.readLine();
            inicio=cad.indexOf("is_live");
            fin=cad.indexOf("category", inicio);
            estadoAr=cad.substring(inicio, fin);
            
            if(estadoAr.contains("true")){
            	online = true;
            }else{
            	online = false;
            }
            
          //Actualizar el juego
            inicio=cad.indexOf("title");
            fin=cad.indexOf("url_thumbnail", inicio);
            estadoAr=cad.substring(inicio+8, fin-4);
            
            if(estadoAr.length()>0){
            	juego=estadoAr;
            }
           
            //Actualizar los seguidores
            
            inicio=cad.indexOf("followers_count");
            fin=cad.indexOf("view_count", inicio);
            seguidoresAr=cad.substring(inicio+17, fin-2);
            
            if(seguidoresAr.length()>0){
            	 seguidores=seguidoresAr;
            }
            
            //Actualizar los viewers
            
            if(online){
            	inicio=cad.indexOf("view_count");
 	            fin=cad.indexOf("vods_view_count", inicio);
 	           viewsAr=cad.substring(inicio+12, fin-2);
 	            
 	            if(viewsAr.length()>0){
 	            	viewers=viewsAr;
 	            }
            }else{
            	viewers="0";
            }
            
            //Actualizar los viewers Totales
            
            inicio=cad.indexOf("vods_view_count");
            fin=cad.indexOf("}", inicio);
            viewsTotalesAr=cad.substring(inicio+17, fin);
            
            if(viewsTotalesAr.length()>0){
            	viewsTotales=viewsTotalesAr;
            }
            
        } catch (MalformedURLException e) {
        	online=false;
        	juego="";
        	viewers="";
        	titulo="";
        	seguidores="";
        	viewsTotales="";
        } catch (IOException e) {
        	online=false;
        	juego="";
        	viewers="";
        	titulo="";
        	seguidores="";
        	viewsTotales="";
        }
    }
    
    public static String getAdmin() {
		return admin;
	}

	public static void setAdmin(String admin) {
		Canal.admin = admin;
	}

	public static String getUsuarioIRC() {
		return usuarioIRC;
	}

	public static void setUsuarioIRC(String usuarioIRC) {
		Canal.usuarioIRC = usuarioIRC;
	}

	public static String getPassIRC() {
		return passIRC;
	}

	public static void setPassIRC(String passIRC) {
		Canal.passIRC = passIRC;
	}

    public static String getCanal() {
		return canal;
	}

	public static void setCanal(String canal) {
		Canal.canal = canal;
	}

	public static String getIdiomaIRC() {
		return idiomaIRC;
	}

	public static void setIdiomaIRC(String idiomaIRC) {
		Canal.idiomaIRC = idiomaIRC;
	}

	public URL getUrl(){
        return this.url;
    }
 
    public static boolean isOnline(){
        return online;
    }
    
    public void setSubs(String subs){
    	seguidores=subs;
    }

	public static String getJuego() {
		return juego;
	}

	public static String getViewers() {
		return viewers;
	}

	public static String getTitulo() {
		return titulo;
	}

	public static String getSeguidores() {
		return seguidores;
	}
	
    public static String getViewsTotales() {
		return viewsTotales;
	}
}
