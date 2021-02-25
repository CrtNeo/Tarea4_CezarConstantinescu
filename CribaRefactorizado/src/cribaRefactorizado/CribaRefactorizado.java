package cribaRefactorizado;

import java.util.Scanner;

public class CribaRefactorizado {

	public static void detector(int dim, boolean[] esPrimo) {
		for (int i = 0; i < dim; i++)
			esPrimo[i] = true;
		esPrimo[0] = esPrimo[1] = false;
		for (int i = 2; i < Math.sqrt(dim) + 1; i++) {
			if (esPrimo[i]) {
				for (int j = 2 * i; j < dim; j += i)
					esPrimo[j] = false;
			}
		}
	}

	public static int contador(int dim, boolean[] esPrimo) {
		int cuenta = 0;
		for (int i = 0; i < dim; i++) {
			if (esPrimo[i])
				cuenta++;
		}
		return cuenta;
	}

	public static int[] generarPrimos(int max) {
		int i, j;
		if (max >= 2) {
			
			int dim = max + 1;
			boolean[] esPrimo = new boolean[dim];
			
			detector(dim, esPrimo);
			int cuenta = contador(dim, esPrimo);

			int[] primos = new int[cuenta];

			for (i = 0, j = 0; i < dim; i++) {
				if (esPrimo[i])
					primos[j++] = i;
			}
			return primos;
		} else {
			return new int[0];
		}
	}

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el número para la criba de Erastótenes:");
		int dato = teclado.nextInt();
		
		int vector[] = new int[dato];
		
		System.out.println("\nVector inicial hasta :" + dato);
		vista1(vector);
		
		vector = generarPrimos(dato);
		
		System.out.println("\nVector de primos hasta:" + dato);
		vista2(vector);
		
		teclado.close();
	}

	public static void vista1(int[] vector) {
		for (int i = 0; i < vector.length; i++) {
			if (i % 10 == 0)
				System.out.println();
			System.out.print(i + 1 + "\t");
		}
	}
	
	public static void vista2(int[] vector) {
		for (int i = 0; i < vector.length; i++) {
			if (i % 10 == 0)
				System.out.println();
			System.out.print(vector[i] + "\t");
		}
	}

}