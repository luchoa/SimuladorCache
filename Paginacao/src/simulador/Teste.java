package simulador;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {
		
		System.out.println("Por favor, digite o caminho do arquivo: ");		
		Scanner scanner = new Scanner(System.in);
		String caminho = scanner.nextLine();
		
		System.out.println("Digite o Tamanho da Cache: ");
		int tamCache = scanner.nextInt();
		scanner.close();
		
		try{			
	        FileInputStream inputStream = new FileInputStream(new java.io.File(caminho));	    
	        InputStreamReader isr = new InputStreamReader(inputStream);
	        BufferedReader br = new BufferedReader(isr);
	        	   
	        String[] stringReferencia = null;
	        String referencia = "";
	        //enquanto tiver linha para ser lida
	        
	        while (br.ready()) {
	        	
	        	referencia = referencia + br.readLine() + ";";	        	
	        }
	        br.close();
	        stringReferencia = referencia.split(";");        	
	        				
	        	// FIFO
	    		System.out.println("Páginas Armazenadas na Cache (FIFO): ");
	    		AlgoritmoDeSubstituicao fifo = new FIFO(tamCache);

	    		for (int i = 0; i < (stringReferencia.length); i++) { //fazer ler de um arquivo
	    			fifo.inserir(stringReferencia[i]);
	    			fifo.imprimirQuadros();
	    		}
	    		
	    		System.out.println("Page Faults FIFO: " + fifo.getCacheMiss());
	    		System.out.println("Page Hits FIFO: " + fifo.getCacheHit());
	    		System.out.println("_______________________________________________");
	    		

	    		//LRU
	    		System.out.println("Páginas Armazenadas na Cache (LRU): ");
	    		AlgoritmoDeSubstituicao lru = new LRU(tamCache);

	    		for (int i = 0; i < (stringReferencia.length); i++) { //fazer ler de um arquivo
	    			lru.inserir(stringReferencia[i]);
	    			lru.imprimirQuadros();

	    		}
	    		System.out.println("Page Faults LRU: " + lru.getCacheMiss());
	    		System.out.println("Page Hits LRU: " + lru.getCacheHit());
	    		System.out.println("_______________________________________________");
	    		
	    		//LFU
	    		System.out.println("Páginas Armazenadas na Cache (LFU): ");
	    		AlgoritmoDeSubstituicao lfu = new LFU(tamCache);

	    		for (int i = 0; i < (stringReferencia.length); i++) { //fazer ler de um arquivo
	    			lfu.inserir(stringReferencia[i]);
	    			lfu.imprimirQuadros();

	    		}
	    		System.out.println("Page Faults LFU: " + lfu.getCacheMiss());
	    		System.out.println("Page Hits LFU: " + lfu.getCacheHit());
	    		System.out.println("_______________________________________________");
	    		
	    		//Random
	    		System.out.println("Páginas Armazenadas na Cache (Random): ");
	    		AlgoritmoDeSubstituicao prandom = new PRandom(tamCache);

	    		for (int i = 0; i < (stringReferencia.length); i++) { //fazer ler de um arquivo
	    			prandom.inserir(stringReferencia[i]);
	    			prandom.imprimirQuadros();

	    		}
	    		System.out.println("Page Faults LFU: " + prandom.getCacheMiss());
	    		System.out.println("Page Hits LFU: " + prandom.getCacheHit());
	    		System.out.println("_______________________________________________");
	    		
	
			
		} catch (IOException e) {
	        System.out.println("Erro ao Manipular o Arquivo.");
	        System.out.println("msg: " + e.getMessage());
	    }	
		
	}//main

}//class
