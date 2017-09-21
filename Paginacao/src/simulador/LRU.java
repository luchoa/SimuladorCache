package simulador;

import java.util.LinkedList;

public class LRU extends AlgoritmoDeSubstituicao<QuadroLRU> {

	private int topo = 0;
	private int base = numeroDeQuadros - 1;
	private boolean contem = false;

	public LRU(int numeroDeQuadros) {
		super(numeroDeQuadros);
		this.quadros = new LinkedList<QuadroLRU>();
	}

	
	
	 @Override 
	 public void inserir(String valor) {
		 QuadroLRU quadro = new QuadroLRU(valor);
		 
		 if(!quadros.contains(quadro)) {
			 if (quadros.size() < numeroDeQuadros) {
				 quadros.add(topo, quadro);
			 }else {
				 quadros.remove(base);
				 quadros.add(topo, quadro);
			 }
			 cacheMiss++;
		 }else {
			 cacheHit++;
			 quadros.remove(quadro);
			 quadros.add(topo, quadro);
		 }
	 }
	 
	 

	@Override
	public void imprimirQuadros() {
		System.out.print("Quadros:  ");
		for (int i = 0; i < quadros.size(); i++) {
			System.out.print(quadros.get(i).getValor()  + " ");
		}
		System.out.println();
	}
}
