package resolucion;

public class Aerolinea {
	Vuelo[] vuelos;

	public Aerolinea(Vuelo[] vuelos) {
		super();
		this.vuelos = vuelos;
	}
	
	public int vuelosEn(Tripulante t, String tipoAvion) {
		int contador = 0;
		for (Vuelo v : vuelos) {
			if (v != null && v.avion != null && tipoAvion.equals(v.avion.tipo)) {
				for (Tripulante tr : v.tripulacion) {
					if (tr != null && tr.equals(t)) {
						contador++;
						break;
					}
				}
			}
		}
		
		return contador;
	}
	
	public int antiguedadPromedio(String tipoAvion) {
		int total = 0, promedio = 0;
		
		for (Vuelo v : vuelos) {
			if (v != null && v.avion != null && tipoAvion.equals(v.avion.tipo)) {
				for (Tripulante t : v.tripulacion) {
					if (t != null) {
						promedio++;
						total = t.antiguedad;
					}
				}
			}
		}
		if (promedio == 0) {
			return 0;
		}
		
		return total / promedio;
	}
	
	public Vuelo elMasInspeccionado() {

		int[] cantInspectores = new int[vuelos.length];
		int num = 0;
		for (Vuelo v : vuelos) {
			if (v != null && v.avion != null) {
				int contador = 0;
				for (Tripulante t : v.tripulacion) {
					if (t != null && t.cargo.equals("Inspector")) {
						contador++;
					}
				}
				cantInspectores[num] = contador;
			}
			num++;
		}
		int indice = 0;
		for (int i = 0 ; i < cantInspectores.length; i++) {
			if (cantInspectores[i] > cantInspectores[indice]) {
				indice = i;
			}
		}
		return vuelos[indice];
		
	}
	
	public boolean hayVueloSobrecargado() {
		for (Vuelo v : vuelos) {
			if (v != null && v.avion != null) {
				int contador = 0;
				for (Tripulante t : v.tripulacion) {
					if (t != null && "Aeromozo".equals(t.cargo)) {
						contador++;
					}
				}
				int diezPorCiento = (v.avion.capacidad * 10) / 100;
				if (contador > diezPorCiento) {
					return true;
				}
			}
		}
		return false;
	}
	
	public Tripulante elMasViajero() {
	    if (vuelos == null || vuelos.length == 0) {
	    	return null;
	    }

	    Tripulante[] todos = new Tripulante[0];
	    int[] conteo = new int[0];
	    
	    for (Vuelo v : vuelos) {
	        if (v != null && v.tripulacion != null) {
	            for (Tripulante t : v.tripulacion) {
	                if (t != null) {
	                    int pos = -1;
	                    for (int i = 0; i < todos.length; i++) {
	                        if (todos[i].equals(t)) {
	                            pos = i;
	                            break;
	                        }
	                    }
	                    
	                    if (pos == -1) {
	                        Tripulante[] nuevosT = new Tripulante[todos.length + 1];
	                        int[] nuevosC = new int[conteo.length + 1];
	                        for (int i = 0; i < todos.length; i++) {
	                            nuevosT[i] = todos[i];
	                            nuevosC[i] = conteo[i];
	                        }
	                        nuevosT[todos.length] = t;
	                        nuevosC[conteo.length] = 1;
	                        todos = nuevosT;
	                        conteo = nuevosC;
	                    } else {
	                        conteo[pos]++;
	                    }
	                }
	            }
	        }
	    }
	    
	    if (todos.length == 0) {
	    	return null;
	    }
	    int maxPos = 0;
	    for (int i = 1; i < conteo.length; i++) {
	        if (conteo[i] > conteo[maxPos]) {
	            maxPos = i;
	        }
	    }
	    
	    return todos[maxPos];
	}


}
