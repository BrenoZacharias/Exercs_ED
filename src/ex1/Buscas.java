package ex1;

public class Buscas {

	public static void main(String[] args) {

		int v[] = {7, 0, 9, 3, 15, 4};
		int n = v.length;
		int valor = 4;
		System.out.println("indice " + busca(v, valor));
		System.out.println("indice " + buscaRecursiva(v, n, valor));
		
		int v2[] = {1, 2, 3, 4, 5};
		n = v2.length;
		System.out.println("indice " + buscaBinaria(v2, valor));
		System.out.println("indice " + buscaBinariaRecursiva(v2, 0, v2.length - 1, valor));
	}
	
	public static int busca(int[] v, int valor) {
		for (int i = 0; i < v.length; i++) {
			if (v[i] == valor)
				return i;
		}
		return -1;
	}

	public static int buscaRecursiva(int[] v, int n, int valor) {
		if (n > 0) {
			if (v[n - 1] == valor)
				return n - 1;
			else
				return buscaRecursiva(v, n - 1, valor);
		}
		return -1;
	}
	
	public static int buscaBinaria(int v[], int valor){//vetor precisa estar ordenado
        int esq = 0;
        int dir = v.length-1;
        int meio;
       
        while(esq<=dir){
            meio=(esq+dir)/2;
            if(v[meio]==valor)  //se o valor pesquisado está no meio do vetor
                return meio;
            if(v[meio]>valor)   //se o valor pesquisado está a esquerda do vetor
                dir=meio-1;
            else                //se o valor pesquisado está a direita do vetor
                esq=meio+1;
        }
        return -1;
    }
	
	public static int buscaBinariaRecursiva(int v[], int esq, int dir, int valor){
        if (dir>=esq){
            int meio = esq+(dir-esq)/2;
            if (v[meio] == valor){
                return meio;
            }
            if (v[meio] > valor){
                return buscaBinariaRecursiva(v, esq, meio-1, valor);//busca no subvetor a esquerda
            }else{
                return buscaBinariaRecursiva(v, meio+1, dir, valor);//busca no subvetor a direita
            }
        }
        return -1;
    }
}
