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
}
