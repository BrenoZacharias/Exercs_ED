package ex3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main3 {

	public static void main(String[] args) {

		String fileName = "C:/Users/Higur/Desktop/GrafoEx3.txt"; // Caminho do
																	// arquivo

		// Formatação do arquivo A B C D E F G
		// 0 1 2 3 4 5 6
		// A 0 0 7 0 5 0 0 0
		// B 1 7 0 8 9 7 0 0
		// C 2 0 8 0 0 5 0 0
		// D 3 5 9 0 0 8 6 0
		// E 4 0 7 5 8 0 8 9
		// F 5 0 0 0 6 8 0 5
		// G 6 0 0 0 0 9 5 0

		try {
			LerArquivo(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void LerArquivo(String fileName) throws IOException {
		String[] splitLinha;
		String linha;

		char Alfabeto[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
				'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

		BufferedReader ler = new BufferedReader(new FileReader(fileName));

		linha = ler.readLine();
		linha = ler.readLine();
		splitLinha = linha.split(" ");

		int tam = splitLinha.length - 2;
		int Matriz[][] = new int[tam][tam];

		for (int vertical = 2; vertical < tam; vertical++) {
			linha = ler.readLine();
			splitLinha = linha.split(" ");
			for (int horizontal = 2; horizontal < tam; horizontal++) {
				Matriz[horizontal - 2][vertical - 2] = Integer.parseInt(splitLinha[horizontal]);
				Matriz[vertical - 2][horizontal - 2] = Integer.parseInt(splitLinha[horizontal]);
			}
		}
		for (int vertical = 0; vertical < tam; vertical++) {
			for (int horizontal = 0; horizontal < tam; horizontal++) {
				if ((Matriz[vertical][horizontal] != 0) & (Matriz[horizontal][vertical] != 0)) {
					System.out.println("Aresta " + Alfabeto[vertical] + " --> " + Alfabeto[horizontal] + " peso = "
							+ Matriz[vertical][horizontal]);
				}
			}
			System.out.println(" ");
		}
		ler.close();
	}
}
