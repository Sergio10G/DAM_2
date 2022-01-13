import java.sql.Connection;
import java.sql.DriverManager;

public class App {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Se ha cargado la movie.");
		String cadenaConexion = "jdbc:mysql://localhost:3306/TIENDA";
		String user = "root";
		String pass = "campusfp";
		Connection con = DriverManager.getConnection(cadenaConexion, user, pass);
		System.out.println("Nos hemos conectado");
    }
}
