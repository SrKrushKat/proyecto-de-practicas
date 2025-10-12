package resolucion;



public class Fraccion {
    int numerador;
    int denominador;
    
    public Fraccion(int numerador, int denominador) {
    	this.numerador = numerador;
    	this.denominador = denominador;
    }
    
    public void imprimir() {
    	System.out.println(this.numerador + "/" + this.denominador);
    }
    
    public void invertirSigno() {
    	Fraccion num = new Fraccion(this.numerador * - 1, this.denominador);
    	num.imprimir();
    }
    
    public void invertir() {
    	Fraccion num = new Fraccion(this.denominador, this.numerador);
    	num.imprimir();
    }
    
    public double aDouble() {
    	double num = this.numerador;
    	double den = this.denominador;
    	return num / den;
    }
    
    public void reducir() {
    	int num = MaxComDiv.mcd(this.numerador, this.denominador);
    	int numer = this.numerador / num;
    	int denom = this.denominador / num;
    	Fraccion nueva = new Fraccion(numer, denom);
    	nueva.imprimir();
    }
    
    public static Fraccion producto(Fraccion q1, Fraccion q2) {
    	int numerador = q1.numerador * q2.numerador;
    	int denominador = q1.denominador * q2.denominador;
    	Fraccion nueva = new Fraccion(numerador, denominador);
    	nueva.reducir();
    	return nueva;
    }
    
    public static Fraccion suma(Fraccion q1, Fraccion q2) {
    	int numerador = q1.numerador * q2.denominador + q2.numerador * q1.denominador;
    	int denominador = q1.denominador * q2.denominador;
    	Fraccion nueva = new Fraccion(numerador, denominador);
    	nueva.reducir();
    	return nueva;
    }
    
    public static void main(String[] args) {
    	//Fraccion num = new Fraccion(12,6);
    	//Fraccion num1 = new Fraccion(48,18);
    	//Fraccion num2 = new Fraccion(36,20);
    	//num.imprimir();
    	//num.invertirSigno();
    	//num.invertir();
    	//System.out.println(num.aDouble());
    	//num.reducir();
    	//num1.reducir();
    	//num2.reducir();
    	//producto(num1, num2);
    	//suma(num, num1);
    	
    }
}
