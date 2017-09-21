package simulador;

import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String referencia = scanner.nextLine();
		String[] stringReferencia = referencia.split(";");

		// FIFO
		AlgoritmoDeSubstituicao fifo = new FIFO(3);

		for (int i = 0; i < (stringReferencia.length); i++) { //fazer ler de um arquivo
			fifo.inserir(stringReferencia[i]);
			fifo.imprimirQuadros();
		}
		System.out.println("Page Faults FIFO: " + fifo.getCacheMiss());
		System.out.println("Page Hits FIFO: " + fifo.getCacheHit());
		

		//LRU
		AlgoritmoDeSubstituicao lru = new LRU(3);

		for (int i = 0; i < (stringReferencia.length); i++) { //fazer ler de um arquivo
			lru.inserir(stringReferencia[i]);
			lru.imprimirQuadros();

		}
		System.out.println("Page Faults LRU: " + lru.getCacheMiss());
		System.out.println("Page Hits LRU: " + lru.getCacheHit());
		
		
	}

}
