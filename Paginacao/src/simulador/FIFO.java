package simulador;

import java.util.LinkedList;

public class FIFO extends AlgoritmoDeSubstituicao {

	private int insere = 0;

	public FIFO(int numeroDeQuadros) {
		super(numeroDeQuadros);
		this.quadros = new LinkedList<>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void inserir(String valor) {
		
		//Verifica se o valor ja está na cache
		if (!quadros.contains(valor)) {

			// se a quantidade de paginas na memoria for menor que o numero de quadros
			if (quadros.size() < numeroDeQuadros) {
				quadros.add(valor);
			} else {
				quadros.remove(insere);
				quadros.add(insere, valor);
				insere++;
				if (insere == numeroDeQuadros) {
					insere = 0;
				}
			}
			cacheMiss++;

		}
		
		cacheHit ++;
	}
	
	

}
