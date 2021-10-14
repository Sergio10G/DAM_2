package j8.lambda;

@FunctionalInterface
public interface IPrinter {
	//	Attributes
	
	
	//	Constructors
	
	
	//	Methods
	public void print(String x);
	
	public default void saludar() {
		System.out.println("Hola!");
	}
	//	Getters & Setters
	
	
}
