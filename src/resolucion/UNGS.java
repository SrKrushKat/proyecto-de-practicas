package resolucion;

public class UNGS {
	Comision[] comisiones;

	public UNGS(Comision[] comisiones) {
		super();
		this.comisiones = comisiones;
	}
	
	boolean cursaCon(Estudiante e, Docente d) {
		for (Comision c : comisiones) {
			boolean estudiante = false;
			boolean docente = false;
			for (Estudiante inscripto : c.inscriptos) {
				if (inscripto != null && inscripto.legajo == e.legajo) {
					estudiante = true;
					break;
				}
			}
			for (Docente profesor : c.docentes) {
				if (profesor != null && profesor.dni == d.dni) {
					docente = true;
					break;
				}
			}
			if (estudiante && docente) {
				return true;
			}
		}
		return false;
	}
	
	boolean suficientesDocentes() {
		for (Comision c : comisiones) {
			if (c == null) continue;
			int cantDocentes = 0;
			int cantInscriptos = 0;
			for (Docente d : c.docentes) {
				if (d != null) {
					cantDocentes++;
				}
			}
			for (Estudiante e: c.inscriptos) {
				if (e!= null) {
					cantInscriptos++;
				}
			}
			int requeridos = (int) Math.ceil(cantInscriptos / 20);
			if (cantDocentes < requeridos) {
				return false;
			}
		}
		return true;
	}

}
