package simulador;

import java.util.LinkedList;

public class LRU extends AlgoritmoDeSubstituicao <QuadroLRU> {
	
	public LRU(int numeroDeQuadros) {
		super(numeroDeQuadros);
		this.quadros = new LinkedList<QuadroLRU>();
	}

	@Override
	public void inserir(String valor) {

		QuadroLRU quadro = new QuadroLRU();
		quadro.setValor(valor);

		// Se NÃO contem na cache o valor
		if (!quadros.contains(valor)) {

			// Se ainda tem espaço na cache
			if (quadros.size() < numeroDeQuadros) {
				quadros.add(quadro);
				// Se contem na cache o valor
			} else {

			}

			cacheMiss++;

		} else {
			for (int i = 0; i < quadros.size(); i++) {
				if(quadros.get(i).getValor().equals("0")) {
					
				}
				quadros.set(i, quadros.get(i).);
				cacheHit++;
			}
			
		}
	}

}
