package Simetrico;

import java.io.Serializable;

public class ObjetoSimple implements Serializable{
	private static final long serialVersionUID = 3087657003198675810L;
	private String texto;
	private int numero;

	public ObjetoSimple(String texto, int numero) {
		this.texto = texto;
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "ObjetoSimple [numero=" + numero + ", texto=" + texto + "]";
	}
}
