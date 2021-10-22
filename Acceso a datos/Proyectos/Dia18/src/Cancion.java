public class Cancion {
	//	Attributes
	String titulo;
	String autor;
	
	//	Constructors
	public Cancion(String titulo, String autor) {
		this.titulo = titulo;
		this.autor = autor;
	}
	
	//	Methods
	@Override
	public String toString() {
		return "Cancion [autor=" + autor + ", titulo=" + titulo + "]";
	}

	//	Getters & Setters
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
}
