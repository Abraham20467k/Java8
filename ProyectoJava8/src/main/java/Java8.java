import interfaces.IPorDefecto;
import lambda.MiNombre;
import lambda.Sumar;

public class Java8 implements IPorDefecto {

	public static void main(String[] args) {

		
//		() -> "mi nombre es ";
//		(n) -> n*n;
//		(n) -> n==2;
		
		MiNombre miNombreAnonimo = new MiNombre() {
			
			@Override
			public String miNombre() {
				// TODO Auto-generated method stub
				return "Romero";
			}
		};
		
		System.out.println(miNombreAnonimo.miNombre());
		
		
		MiNombre miNombreAnonimoLambda = () 	->  "Roman";
		System.out.println(miNombreAnonimoLambda.miNombre());
		
		Sumar suma = new Sumar() {
			
			@Override
			public int suma(int a, int b) {
				// TODO Auto-generated method stub
				return a+b;
			}
		}; 
		System.out.println(suma.suma(1, 3));
		
		Sumar sumaLambda = (a,b) ->{
			a=b*b;
			a=a+b;
			System.out.println("Mensaje Lambda");
			return a;
		};
		
		System.out.println(sumaLambda.suma(8, 25));
		
	Java8 lambda8 = new Java8();
	System.out.println(lambda8.metodoPorDefeto("Defecto"));
	}

	@Override
	public void mostrarNombre(String nombre) {
		// TODO Auto-generated method stub
		
	}

}
