package resolucion;

public class PC {
	String serial;
	String modelo;
	String OS;
	Componente[] componentes;
	
	public PC(String serial, String modelo, String oS, Componente[] componentes) {
		super();
		this.serial = serial;
		this.modelo = modelo;
		OS = oS;
		this.componentes = componentes;
	}
	
	public int calidadPromedio() {
		int suma = 0;
		int promedio = componentes.length;
		
		for (Componente c : componentes) {
			if (c != null && c.marca != null) {
				suma += c.marca.calidad;
			}
		}
		if (promedio == 0) {
			return 0;
		}
		
		return suma / promedio;
	}

}
