import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PruebaApiStreams {
    public static void main(String[] args) throws Exception {
        List<Cancion> canciones = new ArrayList<>(Arrays.asList(
		    new Cancion("Te Equivocas", "Jon Carlo"),
		    new Cancion("Solo tu", "Orlando Elizalde"),
		    new Cancion("La Mano de Dios","Jon Carlo"),
		    new Cancion("Como una hoja de papel", "Evelyn Vasquez"),
		    new Cancion("Siempre te amare", "Darwin Lechler"),
		    new Cancion("Brilla", "Darwin Lechler"),
		    new Cancion("Sin amor", "Carlos & Carito"),
		    new Cancion("Te amare", "Joan Sánchez"),
		    new Cancion("Cuanto me ama", "Orlando Elizalde")
	    ));
        
		PruebaApiStreams pas = new PruebaApiStreams();
		pas.filtroJ8(canciones);
	}

	public void imprimir(List<Cancion> canciones) {
		//Anterior a java 8
	    for(Cancion cancion : canciones){
	    	System.out.println("Java 7: " + cancion);
	    }
    
	    //Uso de lambdas en Java 8
	    canciones.forEach(c -> System.out.println("Java 8: " + c.getAutor()));
	}

	public void filtro(List<Cancion> canciones) {
		for(Cancion cancion : filtrarCantanteJava7(canciones, "Jon Carlo")){
			System.out.println("Java 7: "+cancion);
		}
		
	}

	public List<Cancion> filtrarCantanteJava7(List<Cancion> canciones, String cantante){
		List<Cancion> listaFiltrada = new LinkedList<>();
		for(Cancion cancion : canciones){
			if(cancion.getAutor().equals(cantante))
				listaFiltrada.add(cancion);
		}
		return listaFiltrada;
	}

	public void filtroJ8(List<Cancion> canciones){
		List<Cancion> listadoCanciones = filtrarCantanteJava8Map(canciones,"Jon Carlo");
		listadoCanciones.forEach(c -> System.out.println("Java 8: "+c));
	}

	public List<Cancion> filtrarCantanteJava8(List<Cancion> canciones, String cantante){
		return canciones.stream()
						.filter(c -> c.getAutor().equals(cantante))
						.collect(Collectors.toList());
	}

	public List<Cancion> filtrarCantanteJava8Map(List<Cancion> canciones, String cantante){
		return canciones.stream()
		.filter(c -> c.getAutor().equals(cantante))
		.map( c -> {
				c.setAutor(c.getAutor().toUpperCase());
				return c;
			}
		)
		.collect(Collectors.toList());
	}
}
