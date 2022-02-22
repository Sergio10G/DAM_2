package Simetrico;

public class Main {
	public static void main(String[] args) {
		Cifrado cif = new Cifrado("1234");
		byte[] cifrado = cif.encriptar("Hola que tal");
		System.out.println(new String(cifrado));
		System.out.println(new String(cif.desencriptar(cifrado)));

		ObjetoSimple os = new ObjetoSimple("Hola", 21);
		byte[] objeto = cif.encriptarObjeto(os);
		System.out.println(objeto.toString());
		ObjetoSimple osd = (ObjetoSimple) cif.desencriptarObjeto(objeto);
		System.out.println(osd);
	}
}
