package resolucion;

public class Comision {
	String materia;
	int numero;
	Docente[] docentes;
	Estudiante[] inscriptos;
	int[] calificaciones;
	
	public Comision(String materia, int numero, Docente[] docentes, Estudiante[] inscriptos, int[] calificaciones) {
		super();
		this.materia = materia;
		this.numero = numero;
		this.docentes = docentes;
		this.inscriptos = inscriptos;
		this.calificaciones = calificaciones;
	}

}
