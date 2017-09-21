package simulador;

import java.util.LinkedList;

public abstract class AlgoritmoDeSubstituicao <T> {

	protected int cacheHit;
	protected int cacheMiss;
	protected int numeroDeQuadros;
	LinkedList <T> quadros;

	public AlgoritmoDeSubstituicao(int numeroDeQuadros) {
		if (numeroDeQuadros < 0)
			throw new IllegalArgumentException();
		this.numeroDeQuadros = numeroDeQuadros;
		cacheMiss = 0;
		cacheHit = 0;
	}

	public int getCacheMiss() {
		return cacheMiss;
	}
	
	public int getCacheHit() {
		return cacheHit;
	}

	public abstract void inserir(String numeroPagina);

	public void imprimirQuadros() {
		System.out.print("Quadros:  ");
		for (int i = 0; i < quadros.size(); i++) {
			System.out.print(quadros.get(i) + " ");
		}
		System.out.println();
	}

}
