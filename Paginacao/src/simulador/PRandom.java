package simulador;

import java.util.LinkedList;
import java.util.Random;

public class PRandom extends AlgoritmoDeSubstituicao {

	private int insere = 0;

	public PRandom(int numeroDeQuadros) {
		super(numeroDeQuadros);  
		this.quadros = new LinkedList<>();
	}

	@Override
	public void inserir(String valor) {
		
		//Verifica se o valor ja est� na cache
		if (!quadros.contains(valor)) {

			// se a quantidade de paginas na memoria for menor que o numero de quadros
			if (quadros.size() < numeroDeQuadros) {
				quadros.add(valor);
			} else {
				Random gerador = new Random();				
				insere = gerador.nextInt(numeroDeQuadros);
				quadros.remove(insere);
				quadros.add(insere, valor);				
			}
			cacheMiss++;

		}else
			cacheHit ++;
	}
}
