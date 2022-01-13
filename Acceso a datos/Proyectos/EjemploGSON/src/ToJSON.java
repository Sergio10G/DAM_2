import com.google.gson.Gson;

public class ToJSON {

	public static void main(String[] args) {
		Gson gson = new Gson();
		Coche c;

		Garaje g = new Garaje("C/ Av. de las ciudades, 10");
		c = new Coche("1234ABC", "Ford", "Fiesta", "Rojo");
		g.asignarPlaza(c, 12);
		c = new Coche("456JCB", "Opel", "Corsa", "Verde");

		String textoJSON = gson.toJson(g);
		System.out.println(textoJSON);
	}

}
