import java.io.Serializable;
import java.util.ArrayList;

public class Alumno implements Serializable{
	//	Attributes
	private static final long serialVersionUID = 4854486451470258537L;
	private String nombre;
	private int edad;
	private ArrayList<Calificacion> calificaciones;

	//	Constructors
	public Alumno(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
		this.calificaciones = new ArrayList<>();
	}
	
	//	Methods
	public void calificar(String asignatura, int nota) {
		this.calificaciones.add(new Calificacion(asignatura, nota));
	}
	
	//	Getters & Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public ArrayList<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(ArrayList<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}
	
}
