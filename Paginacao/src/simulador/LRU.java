package simulador;

import java.util.LinkedList;

public class LRU extends AlgoritmoDeSubstituicao<QuadroLRU> {

	private int insere = 0;

	public LRU(int numeroDeQuadros) {
		super(numeroDeQuadros);
		this.quadros = new LinkedList<QuadroLRU>();
	}

	@Override
	public void inserir(String valor) {

		QuadroLRU quadro = new QuadroLRU(valor);
		int maior = numeroDeQuadros - 1;

		// Verifica se o quadro esta na cache
		if (!quadros.contains(quadro)) {//VERIFICAR PQ NUNCA ENTRA NO ELSE

			// Se ainda tem espaço na cache
			if (quadros.size() < numeroDeQuadros) {
				quadros.add(quadro);
				for (int i = 1; i < quadros.size(); i++) {
					quadros.get(i-1).setIdade(quadros.size()-i);
				}
				
			} else {

				for (int i = 0; i < numeroDeQuadros; i++) {
					if (quadros.get(i).getIdade() > quadros.get(maior).getIdade()) {
						maior = i;
					}
				}
				quadros.set(maior, quadro);
			}

			cacheMiss++;

		// Se a cache contem o valor
		} else {
			cacheHit++;
			for (int i = 0; i < quadros.size(); i++) {
				if (quadros.get(i).getValor() == valor)
					quadros.get(i).setZero();
				else
					quadros.get(i).incIdade();

			}

		}

	}

	@Override
	public void imprimirQuadros() {
		System.out.print("Quadros:  ");
		for (int i = 0; i < quadros.size(); i++) {
			System.out.print("[" + quadros.get(i).getValor() + " |" + quadros.get(i).getIdade() + " ]" + " ");
		}
		System.out.println();
	}
}
