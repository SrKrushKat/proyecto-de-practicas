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
    
    public static Persona masJoven(Persona[] grupo) {
    	Persona menor = new Persona(grupo[0].nombre, grupo[0].edad);
    	for (int i = 0; i < grupo.length - 1; i++) {
    		if (grupo[i].edad > grupo[i + 1].edad) {
    			menor = grupo[i+1];
    		}
    	}
    	return menor;
    }
    
    public static Persona buscar(Persona[] grupo, String nombre) {
    	Persona encontrado = new Persona(grupo[0].nombre, grupo[0].edad);
    	for (int i = 0; i < grupo.length; i++) {
    		if (grupo[i].nombre == nombre) {
    			encontrado = grupo[i];
    		}
    	}
    	return encontrado;
    }
    
    @Override
    public String toString() {
    	return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
    }
    
    public static void main(String[] args) {
    	Persona uno = new Persona("Carlos", 27);
    	Persona dos = new Persona("Carla", 25);
    	Persona tres = new Persona("Carla", 25);
    	Persona[] grupo = {uno, dos, tres};
    	System.out.println(uno.masJovenQue(tres));
    	System.out.println(dos.masJovenQue(uno));
    	System.out.println(uno.tocayo(dos));
    	System.out.println(dos.tocayo(tres));
    	System.out.println(dos.mismaPersona(tres));
    	System.out.println(dos.mismaPersona(uno));
    	System.out.println(masJoven(grupo));
    	System.out.println(buscar(grupo, "Carla"));
    }

}
