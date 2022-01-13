import java.io.Serializable;

public class Calificacion implements Serializable{
	//	Attributes
	private static final long serialVersionUID = -3560450138959401202L;
	private String asignatura;
	private int nota;
	
	//	Constructors
	public Calificacion(String asignatura, int nota) {
		this.asignatura = asignatura;
		this.nota = nota;
	}
	
	//	Methods
	@Override
	public String toString() {
		return "Calificacion [asignatura=" + asignatura + ", nota=" + nota + "]";
	}
	
	//	Getters & Setters
	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}
	
}
