package simulador;

public class QuadroLFU {
	private String valor;
	private int frequencia;	
	
	public QuadroLFU(String valor) {
		this.valor = valor;
		this.frequencia = 1;
	}
	
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public int getFrequencia() {
		return frequencia;
	}
	public void incFrequencia() {
		this.frequencia = this.frequencia + 1;
	}
	
}
