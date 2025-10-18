package resolucion;

import java.util.LinkedList;

public class Modulo7 {
	Laboratorio[] labos;

	public Modulo7(Laboratorio[] labos) {
		super();
		this.labos = labos;
	}
	
	public LinkedList<Componente> componentesPorMarca(Marca m){
		LinkedList<Componente> lista = new LinkedList<>();
		
		for (Laboratorio labo : labos) {
			if (labo != null && labo.computadoras != null) {
				for (PC pc : labo.computadoras) {
					if (pc != null && pc.componentes != null) {
						for (Componente c : pc.componentes) {
							if (c != null && c.marca != null && c.marca.equals(m)) {
								if (!lista.contains(c)) {
									lista.add(c);
								}
							}
						}
					}
				}
			}
		}
		
		return lista;
	}
	
	public int pcsConMinimaCalidad() {
		int cantidad = 0;
		
		for (Laboratorio labo : labos) {
			if (labo != null && labo.computadoras != null) {
				for (PC pc : labo.computadoras) {
					if (pc != null) {
						if (pc.calidadPromedio() == 1) {
							cantidad++;							
						}
					}
				}
			}
		}
		
		return cantidad;	
	}
	
	public boolean gamaAlta() {
		int cantidad = 0;
		
		for (Laboratorio labo : labos) {
			if (labo != null && labo.computadoras != null) {
				for (PC pc : labo.computadoras) {
					if (pc != null && pc.componentes != null) {
						boolean calidad = true;
						for (Componente c : pc.componentes) {
							if (c == null || c.marca == null || c.marca.calidad < 4) {
								calidad = false;
								break;
							}
						}
						if (calidad) {
							cantidad++;
						}
					}
				}
			}
		}
		return cantidad >= 1;
		
	}
	
	public LinkedList<PC> pcCompuestasPor(Marca[] ciertasMarcas){
		LinkedList<PC> lista = new LinkedList<>();
		
		for (Laboratorio labo : labos) {
			if (labo != null && labo.computadoras != null) {
				for (PC pc : labo.computadoras) {
					if (pc != null && pc.componentes != null && pc.componentes.length > 0) {
						boolean cumple = true;
						
						for (Componente c : pc.componentes) {
							if (c == null || c.marca == null || !estaEnMarcas(c.marca, ciertasMarcas)) {
								cumple = false;
								break;
							}
						}
						if (cumple && !lista.contains(pc)) {
							lista.add(pc);
						}
					}
				}
			}
		}
		return lista;
		
	}
	
	public boolean estaEnMarcas(Marca m, Marca[] ciertasMarcas) {
		for (Marca marca : ciertasMarcas) {
			if (marca != null && marca.equals(m)) {
				return true;
			}
		}
		
		return false;
	}
	
	public Marca marcaMasUsada() {
		LinkedList<Marca> marcas = new LinkedList<>();
        LinkedList<Integer> cantidades = new LinkedList<>();

        for (Laboratorio labo : labos) {
            if (labo != null && labo.computadoras != null) {
                for (PC pc : labo.computadoras) {
                    if (pc != null && pc.componentes != null) {
                        for (Componente c : pc.componentes) {
                            if (c != null && c.marca != null) {
                                int index = marcas.indexOf(c.marca);
                                if (index == -1) {
                                    marcas.add(c.marca);
                                    cantidades.add(1);
                                } else {
                                    cantidades.set(index, cantidades.get(index) + 1);
                                }
                            }
                        }
                    }
                }
            }
        }
        Marca masUsada = null;
        int max = -1;

        for (int i = 0; i < marcas.size(); i++) {
        	if (cantidades.get(i) > max) {
        		max = cantidades.get(i);
        		masUsada = marcas.get(i);
        	}
        }
        return masUsada;
        
    }


}
