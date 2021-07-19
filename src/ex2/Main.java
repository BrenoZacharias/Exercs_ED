package ex2;

public class Main {

	public static void main(String[] args) {

		int numCompetidores = 7;
		int numClassificam = 2;
		int[] v = { 4, 9, 5, 9, 10, 4, 1 };
		quickSort(v, 0, v.length - 1);
		int c = 0;
		System.out.println(classificados(v, numCompetidores - 1, numClassificam - 1, c));
	}

	public static int classificados(int []v, int n, int nc, int c) {
		c++;
		if ((nc > 0)||(v[(n - c)] == v[((n - c) + 1)])) {
			return classificados(v, n, nc - 1, c);
		}
		return c;
	}

	private static void quickSort(int[] vetor, int inicio, int fim) {
		if (fim > inicio) {
			// Chamada da rotina que ira dividir o vetor em 3 partes.
			int indexPivo = dividir(vetor, inicio, fim);
			/*
			 * Chamada recursiva para redivisao do vetor de elementos menores
			 * que o pivô.
			 */
			quickSort(vetor, inicio, indexPivo - 1);
			/*
			 * Chamada recursiva para redivisao do vetor de elementos maiores
			 * que o pivô.
			 */
			quickSort(vetor, indexPivo + 1, fim);
		}
	}
	// Observe que nesta etapa, o algoritmo visa divider o vetor de entrada
	// utilizando o método private int dividir(int[] vetor, int inicio, int
	// fim), conforme a linha 32. Nesta etapa de divisão veremos como o
	// algoritmo se comporta para realizar a ordenação a cada etapa desta
	// divisão.

	/**
	 * Método que ira dividir o vetor e encontrar o indice do pivô.
	 * 
	 * @param vetor
	 *            - Vetor de inteiros
	 * @param inicio
	 *            - Indice inicial do vetor.
	 * @param fim
	 *            - Indice final do vetor.
	 * @return O indice do pivo.
	 */
	private static int dividir(int[] vetor, int inicio, int fim) {
		int pivo, pontEsq, pontDir = fim;
		pontEsq = inicio + 1;
		pivo = vetor[inicio];

		while (pontEsq <= pontDir) {
			/*
			 * Vai correr o vetor ate que ultrapasse o outro ponteiro ou ate que
			 * o elemento em questão seja menor que o pivô.
			 */
			while (pontEsq <= pontDir && vetor[pontEsq] <= pivo) {
				pontEsq++;
			}

			/*
			 * Vai correr o vetor ate que ultrapasse o outro ponteiro que o
			 * elemento em questão seja maior que o pivô.
			 */
			while (pontDir >= pontEsq && vetor[pontDir] > pivo) {
				pontDir--;
			}

			/*
			 * Caso os ponteiros ainda nao tenham se cruzado, significa que
			 * valores menores e maiores que o pivô foram localizados em ambos
			 * os lados. Trocar estes elementos de lado.
			 */
			if (pontEsq < pontDir) {
				trocar(vetor, pontDir, pontEsq);
				pontEsq++;
				pontDir--;
			}
		}

		trocar(vetor, inicio, pontDir);
		return pontDir;
	}

	private static void trocar(int[] vetor, int i, int j) {
		int temp = vetor[i];
		vetor[i] = vetor[j];
		vetor[j] = temp;
	}

}
