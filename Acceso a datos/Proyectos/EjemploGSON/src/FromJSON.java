import com.google.gson.Gson;

public class FromJSON {

	public static void main(String[] args) {
		String textoJSON = "{\"direccion\":\"C/ Av. de las ciudades, 10\",\"plazas\":[{\"matricula\":\"1234ABC\",\"marca\":\"Ford\",\"modelo\":\"Fiesta\",\"color\":\"Rojo\",\"plaza\":12}]}";

		Gson gson = new Gson();

		Garaje g = gson.fromJson(textoJSON, Garaje.class);

		System.out.println(g);
	}
}
