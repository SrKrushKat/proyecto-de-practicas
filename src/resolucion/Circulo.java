package resolucion;

public class Circulo {
	double radio;
	Punto centro;
	
	public Circulo(double centroX, double centroY, double radio) {
		this.centro = new Punto(centroX, centroY);
		this.radio = radio;
	}
	
	public void imprimir() {
		System.out.println("(" + this.centro.x + ", " + this.centro.y + ", " + this.radio + ")");
	}
	
	public double perimetro() {
		return 2.0 * Math.PI * this.radio;
	}
	
	public double superficie() {
		return Math.PI * (this.radio * this.radio);
	}
	
	public void escalar(double factor) {
		radio = radio * factor;
	}
	
	public void desplazar(double desplazarX, double desplazarY) {
		centro.x += desplazarX;
		centro.y += desplazarY;
	}
	
	public static double distancia(Circulo circulo1, Circulo circulo2) {
		double dist = Punto.distancia(circulo1.centro, circulo2.centro);
		double distTotal = dist - (circulo1.radio + circulo2.radio);
		return Math.max(distTotal, 0.0);
	}
	
	public static boolean seTocan(Circulo circ1, Circulo circ2) {
		double distEjes = Punto.distancia(circ1.centro, circ2.centro);
		double radios = circ1.radio + circ2.radio;
		double difRadios = circ1.radio - circ2.radio;
		return distEjes == radios || distEjes == difRadios;
	}
	
	public boolean estaDentro(Circulo otro) {
		double dist = Punto.distancia(this.centro, otro.centro);
		return dist + otro.radio < this.radio;
	}
	
	public static void dibujarCirculos(Dibujador dib, int x, int y, int r) {
		if (r < 10) {
			return;
		}
		Circulo circ = new Circulo(x,y,r);
		dib.dibujar(circ);
		dibujarCirculos(dib, x + r, y, r/2);
		dibujarCirculos(dib, x - r, y, r/2);
	}
	
	public static void dibujarCirculosEjeY(Dibujador dib, int x, int y, int r) {
		if (r < 10) {
			return;
		}
		Circulo circ = new Circulo(x,y,r);
		dib.dibujar(circ);
		dibujarCirculosEjeY(dib, x, y + r, r/2);
		dibujarCirculosEjeY(dib, x, y - r, r/2);
	}
	
	public static void main(String[] args) {
		Circulo c1 = new Circulo(10.0, 10.0, 3.0);
		Circulo c2 = new Circulo(20.0, 30.0, 5.0);
		Circulo c3 = new Circulo(20.0, 30.0, 10.0);
		Dibujador dib = new Dibujador();
		c1.imprimir();
		c2.imprimir();
		c3.imprimir();
		//System.out.println(c1.perimetro());
		//c1.escalar(2);
		//c1.imprimir();
		//System.out.println(c1.superficie());
		//c1.desplazar(20.0, 10.0);
		//c1.imprimir();
		//System.out.println(distancia(c1, c2));
		//System.out.println(seTocan(c3, c2));
		//System.out.println(c3.estaDentro(c2));
		dibujarCirculos(dib , 400, 400, 200);
		dibujarCirculosEjeY(dib , 400, 400, 200);
	}
}
