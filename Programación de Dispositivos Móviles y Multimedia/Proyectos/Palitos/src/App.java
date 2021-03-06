import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int num_palos = 21;
        int p_tachados = 0;
        boolean turno = false;
        int eleccion = 0;
        Scanner sc = new Scanner(System.in);

        Colors.printlnString(Colors.EColors.PURPLE, "Bienvenido al juego de los palos. Hay 21 palos, puedes elegir " +
        "tachar de 1 a 4 palos. Quién tache el último palo pierde.");
        pintar_palos(num_palos, p_tachados);
        while (p_tachados < 21)
        {
            eleccion = recoger_eleccion(sc, 21 - p_tachados);
            p_tachados += eleccion;
            pintar_palos(num_palos, p_tachados);
            if (p_tachados >= 21)
                break;
            turno = !turno;
            Colors.printlnString(Colors.EColors.YELLOW, "La máquina decide tachar " + (5 - eleccion) + " palo/s!");
            p_tachados += (5 - eleccion);
            pintar_palos(num_palos, p_tachados);
            if (p_tachados >= 21)
                break;
            turno = !turno;
            System.out.println();
        }
        if (turno)
            Colors.printlnString(Colors.EColors.GREEN_BACKGROUND, "Gana el jugador!");
        else
            Colors.printlnString(Colors.EColors.RED_BACKGROUND, "Gana la máquina!");
        System.out.println();
    }

    public static void pintar_palos(int num_palos, int p_tachados) {
        System.out.print("Palos (quedan " + (num_palos - p_tachados) + "): ");
        for (int i = 0; i < p_tachados && i < 21; i++)
            Colors.printChar(Colors.EColors.RED, '|');
        for (int j = 0; j < num_palos - p_tachados && j < 21; j++)
            Colors.printChar(Colors.EColors.GREEN, '|');
        System.out.println("\n");
    }

    public static int recoger_eleccion(Scanner sc, int p_restantes) {
        int eleccion = 0;
        boolean valido = false;

        while (!valido) {
            System.out.println("¿Cuántos palos quieres tachar? (1 - 4)");
            try {
                eleccion = sc.nextInt();
                System.out.println();
                if (eleccion < 1 || eleccion > 4 || eleccion > p_restantes)
                    throw new Exception();
                else
                    valido = true;
            } catch (Exception e) {
                Colors.printlnString(Colors.EColors.RED, "El número introducido es inválido, prueba otra vez!");
                sc.nextLine();
            }
        }
        Colors.printlnString(Colors.EColors.BLUE, "Has elegido tachar " + eleccion + " palo/s!");
        return eleccion;
    }

}
