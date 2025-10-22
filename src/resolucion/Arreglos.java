package resolucion;



public class Arreglos {
	
	public static boolean esSinRepetidos(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (cantApariciones(arr, arr[i]) > 1) {
				return false;
			}
		}
		return true;
	}
	
	public static int cantApariciones(int[] arr, int num) {
		int total = 0;
		for (int i = 0; i < arr.length; i++) {
			if (num == arr[i]) {
				total += 1;
			}
		}
		return total;
	}
	
	public static int[] pegar(int[] arr, int[] arr2) {
		int[] nuevo = new int[arr.length + arr2.length];
		for (int i = 0; i < arr.length; i++) {
			nuevo[i] = arr[i];
		}
		for (int j = 0; j < arr2.length; j++) {
			nuevo[arr.length + j] = arr2[j];
		}
		return nuevo;
	}
	
	public static int[] agregarAlFinal(int[] arr, int elem) {
		int[] nuevo = {elem};
		return pegar(arr, nuevo);
	}
	
	static int[] sinRepetidos(int[] arr) {
		int largo = 0;
		int[] sin = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			boolean repetido = false;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == sin[j]) {
					repetido = true;
					break;
				}
			}
			if (!repetido) {
				sin[largo] = arr[i];
				largo++;
			}
		}
		int[] resultado = new int[largo];
		for (int i = 0; i < largo; i++) {
			resultado[i] = sin[i];
		}
		
		return resultado;
	}
	
	static void invertir(int[] arr) {
		int[] nuevo = new int[arr.length];
		int aux = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			nuevo[aux] = arr[i];
			aux++;
		}
		imprimir(nuevo);
	}
	
	static void imprimir(int[] arr) {
		if (arr.length == 0) {
			return;			
		}
		System.out.print(arr[0]);
		if (arr.length > 1) {
			System.out.print(" ");
		}
		imprimir(resto(arr));
	}
	
	static int[] resto(int[] arr) {
		int[] arr2 = new int[arr.length - 1];
		if (arr.length < 1) {
			return arr2;
		}
		for (int i = 1; i <= arr2.length;i++) {
			arr2[i - 1] = arr[i];			
		}
		return arr2;
	}
}
