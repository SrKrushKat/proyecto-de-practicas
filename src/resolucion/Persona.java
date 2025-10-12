package resolucion;

public class Persona {
    String nombre;
    int edad;
    
    public Persona(String nombre, int edad) {
    	this.nombre = nombre;
    	this.edad = edad;
    }
    
    public boolean masJovenQue(Persona otro) {
    	if (this.edad < otro.edad) {
    		return true;
    	}
    	return false;
    }
    
    public boolean tocayo(Persona otro) {
    	if (this.nombre == otro.nombre) {
    		return true;
    	}
    	return false;
    }
    
    public boolean mismaPersona(Persona otro) {
    	if ((this.edad == otro.edad) && (this.tocayo(otro))) {
    		return true;
    	}
    	return false;
    }
    
    public static void main(String[] args) {
    	Persona uno = new Persona("Carlos", 27);
    	Persona dos = new Persona("Carla", 25);
    	Persona tres = new Persona("Carla", 25);
    	System.out.println(uno.masJovenQue(tres));
    	System.out.println(dos.masJovenQue(uno));
    	System.out.println(uno.tocayo(dos));
    	System.out.println(dos.tocayo(tres));
    	System.out.println(dos.mismaPersona(tres));
    	System.out.println(dos.mismaPersona(uno));
    }
}
