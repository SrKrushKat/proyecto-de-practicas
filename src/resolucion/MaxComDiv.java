package resolucion;

public class MaxComDiv {

	public static void main(String[] args) {
		System.out.println(mcd(48,18));
		System.out.println(mcd(36,20));
		System.out.println(mcd(56,98));
	}
	public static int mcd(int num1, int num2) {
		if (num2 == 0) return num1;
		return mcd(num2, num1 % num2);
	}

}
