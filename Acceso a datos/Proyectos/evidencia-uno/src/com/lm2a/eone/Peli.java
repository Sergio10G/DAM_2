package com.lm2a.eone;

public class Peli {
	private int nro;
	private String titulo;
	private int anio;
	String imdb;
	
	public Peli(int nro, String titulo, int anio, String imdb) {
		super();
		this.nro = nro;
		this.titulo = titulo;
		this.anio = anio;
		this.imdb = imdb;
	}

	public int getNro() {
		return nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getImdb() {
		return imdb;
	}

	public void setImdb(String imdb) {
		this.imdb = imdb;
	}

	@Override
	public String toString() {
		return "Peli [nro=" + nro + ", titulo=" + titulo + ", anio=" + anio + ", imdb=" + imdb + "]";
	}
	
	
	
}
