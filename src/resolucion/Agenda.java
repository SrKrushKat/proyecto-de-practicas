package resolucion;

public class Agenda {
    Persona[] contactos;
    String[] telefonos;
    
    public Agenda(int tamanio) {
    	contactos = new Persona[tamanio];
    	telefonos = new String[tamanio];
    }
    
    void guardar(Persona contacto, String telefono) {
    	int i;
    	for (i = 0; i < contactos.length; i++) {
    		if (contactos[i] == null) {
    			contactos[i] = contacto;
    			telefonos[i] = telefono;
    			return;
    		}
    	}
    	int agrandar = contactos.length + 1;
    	
    	Persona[] expandirContactos = new Persona[agrandar];
    	String[] expandirTelefonos = new String[agrandar];
    	
    	for (i = 0; i < contactos.length; i++) {
    		expandirContactos[i] = contactos[i];
    		expandirTelefonos[i] = telefonos[i];
    	}
    	
    	contactos = expandirContactos;
    	telefonos = expandirTelefonos;
    	
    	contactos[i] = contacto;
    	telefonos[i] = telefono;
    }
    
    void eliminar(Persona contacto) {
    	for (int i = 0; i < contactos.length; i++) {
    		if (contactos[i].mismaPersona(contacto)) {
    			contactos[i] = null;
    			telefonos[i] = null;
    		}
    	}
    }
    
    boolean pertenece(Persona contacto) {
    	for (int i = 0; i < contactos.length; i++) {
    		if (contactos[i].mismaPersona(contacto)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    String dameTelefono(Persona contacto) {
    	if (pertenece(contacto) == true){
    		for (int i = 0; i < contactos.length; i++) {
    			if (contactos[i].mismaPersona(contacto)) {
    				return telefonos[i];
    			}
    		}
    	}
    	return "Contacto no encontrado";
    }
    
}
