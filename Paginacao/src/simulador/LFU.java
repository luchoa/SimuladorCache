package simulador;

import java.util.LinkedList;

public class LFU extends AlgoritmoDeSubstituicao {

	private LinkedList<QuadroLFU> quadrosLFU;
	
	public LFU(int numeroDeQuadros) {
		super(numeroDeQuadros);
		this.quadrosLFU = new LinkedList<QuadroLFU>();
	}

	
	
	 @SuppressWarnings("unchecked")
	@Override 
	 public void inserir(String valor) {
		 
		 int contem = 0;
		 QuadroLFU quadroHit = null;
		 for(QuadroLFU quadro : quadrosLFU){
			 if(quadro.getValor().equals(valor)){
				 contem = 1;
				 quadroHit = quadro;
				 break;
			 }	 
		 }
		 // se NÃO contem na cache
		 if(contem < 1) {
			 QuadroLFU quadro = new QuadroLFU(valor);
			 //se tem espaco
			 if (quadrosLFU.size() < numeroDeQuadros) {				 
				 insereOrdenado(quadro);			 
			 // cache cheia
			 }else {
				 // posicao 0 = menor frequencia, pois esta ordenado de forma crescente
				 quadrosLFU.remove(0);
				 this.insereOrdenado(quadro);
			 }
			 cacheMiss++;
			 
		 // se contem na cache	 
		 }else if(!(quadroHit == null)){  
			 cacheHit++;
			 quadroHit.incFrequencia();
			 quadrosLFU.remove(quadroHit);
			 this.insereOrdenado(quadroHit);
		 }
		 
	 }	 
	 
	 //insere em ordem crescente de frequencia
	 //Já estou ordenando para desempatar o LFU com FiFo, pois faço >=.
	 private void insereOrdenado(QuadroLFU quadro){
		 if(quadrosLFU.isEmpty()){
			 quadrosLFU.add(0, quadro);
		 }else{
			 int i = 0;
			 while(i<quadrosLFU.size() && quadro.getFrequencia()>= quadrosLFU.get(i).getFrequencia()){
				 i++;
			 }
			 //Caso - Freq Menor q todos
			 if(i==0)
				 quadrosLFU.add(0, quadro);
			 //Caso Contrário - Geral
			 else
				 quadrosLFU.add(i, quadro);
		 }	 
	 }
	 
	 @Override
	 public void imprimirQuadros() {
			System.out.print("Quadros:  ");
			for (int i = 0; i < quadrosLFU.size(); i++) {
				System.out.print("V:" + quadrosLFU.get(i).getValor() + " F:" + quadrosLFU.get(i).getFrequencia() + " ");
			}
			System.out.println();
		}
}
