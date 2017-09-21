package simulador;

public class QuadroLRU extends Quadro {
	// todo novo quadro começa com idade 0
	private int idade = 0;

	public void setZero() {
		idade = 0;
	}
	
	public void incIdade() {
		idade++;
	}
	
	public int getIdade() {
		return idade;
	}
}
