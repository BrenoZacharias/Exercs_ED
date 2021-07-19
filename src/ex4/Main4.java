package ex4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main4 {

	public static void main(String[] args){
		
		
		String fileName =  "C:/Users/Higur/Desktop/Grafo.txt"; //Caminho do arquivo
		
		try {
			LerArquivo(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void LerArquivo(String fileName)throws IOException {
		String [] splitLinha;
		
		
		BufferedReader ler = new BufferedReader(new FileReader(fileName));
		
		String linha = ler.readLine();
		
		int pos = Integer.parseInt(linha);
		
		linha = ler.readLine();
		
		int v[][] = new int [pos][pos];
		for(int vertical = 0; vertical < pos;vertical++) {
			linha = ler.readLine();
			splitLinha = linha.split(" ");
			for(int horizontal = 0 ; horizontal < splitLinha.length; horizontal++) {
				v[horizontal][vertical] = Integer.parseInt(splitLinha[horizontal]);
				v[vertical][horizontal] = Integer.parseInt(splitLinha[horizontal]);
			}
		}
		for(int vertical = 0 ; vertical < pos ; vertical++) {
			for (int horizontal = 0 ; horizontal < pos ; horizontal++) {
				System.out.print("["+(v[vertical][horizontal])+"]");
			}
			System.out.println(" ");
		}
		ler.close();
	}
}