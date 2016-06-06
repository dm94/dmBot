package data;

import java.io.IOException;
import java.util.Properties;
import data.*;

public class Idioma extends Properties{
    
    private static final long serialVersionUID = 1L;
	        
    public Idioma(String idioma){
    	
        //Modificar si quieres añadir mas idiomas
        //Cambia el nombre de los ficheros o añade los necesarios
    	switch(idioma){
	    	case "Español":
                    getProperties("espanol.properties");
                    break;
	    	case "English":
                    getProperties("english.properties");
                    break;
	    	default:
                    getProperties("espanol.properties");
	   	}

    }

    private void getProperties(String idioma) {
        try {
            this.load( getClass().getResourceAsStream(idioma) );
        } catch (IOException ex) {
        }
   }
}