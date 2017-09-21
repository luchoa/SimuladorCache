package simulador;

import java.util.LinkedList;

public class LRU extends AlgoritmoDeSubstituicao {

	private int topo = 0;
	private int base = numeroDeQuadros - 1;
	
	public LRU(int numeroDeQuadros) {
		super(numeroDeQuadros);
		this.quadros = new LinkedList<>();
	}

	
	
	 @SuppressWarnings("unchecked")
	@Override 
	 public void inserir(String valor) {
		 
		 if(!quadros.contains(valor)) { 
			 if (quadros.size() < numeroDeQuadros) {
				 quadros.add(topo, valor);
			 }else {
				 quadros.remove(base);
				 quadros.add(topo, valor);
			 }
			 cacheMiss++;
		 }else {
			 cacheHit++;
			 quadros.remove(valor);
			 quadros.add(topo, valor);
		 }
		 
	 }
	 

}
