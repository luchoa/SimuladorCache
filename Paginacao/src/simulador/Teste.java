package simulador;

import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String referencia = scanner.nextLine();
		String[] stringReferencia = referencia.split(";");
		
		
		// FIFO
		System.out.println("Tamanho da Cache (FIFO): ");
		AlgoritmoDeSubstituicao fifo = new FIFO(scanner.nextInt());

		for (int i = 0; i < (stringReferencia.length); i++) { //fazer ler de um arquivo
			fifo.inserir(stringReferencia[i]);
			fifo.imprimirQuadros();
		}
		
		System.out.println("Page Faults FIFO: " + fifo.getCacheMiss());
		System.out.println("Page Hits FIFO: " + fifo.getCacheHit());
		System.out.println("_______________________________________________");
		

		//LRU
		System.out.println("Tamanho da Cache (LRU): ");
		AlgoritmoDeSubstituicao lru = new LRU(scanner.nextInt());

		for (int i = 0; i < (stringReferencia.length); i++) { //fazer ler de um arquivo
			lru.inserir(stringReferencia[i]);
			lru.imprimirQuadros();

		}
		System.out.println("Page Faults LRU: " + lru.getCacheMiss());
		System.out.println("Page Hits LRU: " + lru.getCacheHit());
		System.out.println("_______________________________________________");
		
		//LFU
		System.out.println("Tamanho da Cache (LFU): ");
		AlgoritmoDeSubstituicao lfu = new LFU(scanner.nextInt());

		for (int i = 0; i < (stringReferencia.length); i++) { //fazer ler de um arquivo
			lfu.inserir(stringReferencia[i]);
			lfu.imprimirQuadros();

		}
		System.out.println("Page Faults LFU: " + lfu.getCacheMiss());
		System.out.println("Page Hits LFU: " + lfu.getCacheHit());
		System.out.println("_______________________________________________");
		
		
	}

}
