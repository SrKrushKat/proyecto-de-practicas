package resolucion;

public class Punto {
	double x;
	double y;
	
	public Punto() {
		this.x = 0;
		this.y = 0;
	}
	
	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void imprimir() {
		System.out.println("(" + this.x + ", " + this.y + ")");
	}
	
	public void desplazar(double desplazarX, double desplazarY) {
		Punto mover = new Punto(this.x + desplazarX, this.y + desplazarY);
		mover.imprimir();
	}
	
	public static double distancia(Punto p1, Punto p2) {
		double disX = p1.x - p2.x;
		double disY = p1.y - p2.y;
		return Math.sqrt(disX * disX + disY * disY);
	}
	
	public static void main(String[] args) {
		//Punto p1 = new Punto(5.0, 10.0);
		//Punto p2 = new Punto(0.0, 0.0);
		//Punto p3 = new Punto(33.0, 27.0);
		//p1.imprimir();
		//p2.desplazar(10.0, 5.0);
		//System.out.println(distancia(p1, p3));
		//System.out.println(distancia(p2, p3));
		
	}
}
