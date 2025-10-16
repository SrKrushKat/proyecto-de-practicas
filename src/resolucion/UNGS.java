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
	
	public Estudiante elMasEstudioso() {
		Estudiante[] todos = estudiantes();
		int[] aprobados = new int[todos.length];
		for (Comision c : comisiones) {
			if (c == null || c.inscriptos == null || c.calificaciones == null) {
				continue;
			}
			for (int i = 0; i < c.inscriptos.length; i++) {
				Estudiante e = c.inscriptos[i];
				if (e == null) {
					continue;
				}
				int posicion = indiceDeEstudiante(todos, e);
				if (posicion != -1 && c.calificaciones[i] >= 4) {
					aprobados[posicion]++;
				}
			}
		}
		int max = 0;
		int indiceMax = -1;
		for (int i = 0; i < aprobados.length; i++) {
			if (aprobados[i] > max) {
				max = aprobados[i];
				indiceMax = i;
			}
		}
		if (indiceMax == -1) {
			return null;
		}
		return todos[indiceMax];
	}
	
	public Estudiante[] estudiantes() {
		Estudiante[] temporal = new Estudiante[500];
		int contador = 0;
		
		for (Comision c : comisiones) {
			if (c == null || c.inscriptos == null) {
				continue;
			}
			for (Estudiante e : c.inscriptos) {
				if (e == null) {
					continue;
				}		
				if (indiceDeEstudiante(temporal, e) == -1) {
					temporal[contador++] = e;
				}
			}
		}
	
		Estudiante[] resultado = new Estudiante[contador];
		for (int i = 0; i < contador; i++) {
			resultado[i] = temporal[i];
		}
		return resultado;
	}
	
	public int indiceDeEstudiante(Estudiante[] arr,Estudiante e) {
		for (int i = 0;i < arr.length; i++) {
			if (arr[i] != null && arr[i].legajo == e.legajo) {
				return i;
			}
		}
		return -1;
	}
	
	public int losMejores() {
		int total = 0;
		
		for (Comision c : comisiones) {
			if (c == null || c.inscriptos == null || c.calificaciones == null) {
				continue;
			}
			int notaMasAlta = 1;
			for (int nota : c.calificaciones) {
				if (nota > notaMasAlta) {
					notaMasAlta = nota;
				}
			}
			for (int nota : c.calificaciones) {
				if (nota == notaMasAlta) {
					total++;
				}
			}
		}
		return total;
	}
	
	public int estudiantesDe(Docente d) {
		Estudiante[] estudiantesUnicos = new Estudiante[500];
        int cantidad = 0;
        
        for (Comision c : comisiones) {
            if (c == null || c.docentes == null || c.inscriptos == null) {
            	continue;
            }
            boolean daEnEsta = false;
            for (Docente profe : c.docentes) {
                if (profe != null && profe.dni == d.dni) {
                    daEnEsta = true;
                    break;
                }
            }
            
            if (!daEnEsta) {
            	continue;
            }
            for (Estudiante e : c.inscriptos) {
                if (e == null) {
                	continue;
                }
                if (indiceDeEstudiante(estudiantesUnicos, e) == -1) {
                    estudiantesUnicos[cantidad++] = e;
                }
            }
        }
        return cantidad;
	}
	
	public int unicaComision() {
        int contador = 0;

        for (Comision c : comisiones) {
            if (c == null || c.materia == null) {
            	continue;
            }

            int repeticiones = 0;
            
            for (Comision otra : comisiones) {
                if (otra != null && otra.materia != null && c.materia.equals(otra.materia)) {
                    repeticiones++;
                }
            }
            if (repeticiones == 1) {
                contador++;
            }
        }
        
        return contador;
    }
	
}
