package tp03.ejercicio8;

import java.util.Scanner;
import tp03.ejercicio7.PilaGenerica;

public class TestBalanceo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String S;
		System.out.println("Introduzca el String: ");
		S= sc.nextLine();
		PilaGenerica<Character> pila = new PilaGenerica<Character>();
		Boolean balanceado= true;
		Character C;
		for (int i=0;i<S.length();i++){
			switch (S.charAt(i)){
				
			case '(': pila.apilar('(');
					  break;
					  
			case '{': pila.apilar('{');
					  break;
					  
			case '[': pila.apilar('[');
					  break;
					  
			case ')': if (!pila.esVacia()){
					  	C = pila.desapilar();
					  	if (!(C == '(')){
						  balanceado= false;
					  	}
					  }
					  else{ balanceado= false;}
					  break;
					  
			case '}': if (!pila.esVacia()){
				      	C = pila.desapilar();
				      	if (!(C == '{')){
				      		balanceado= false;
				      	}
				  	  }
				  	  else{ balanceado= false;}
				  	  break;
			  
			case ']':if (!pila.esVacia()){
				  	 	C = pila.desapilar();
				  	 	if (!(C == '[')){
				  	 		balanceado= false;
				  	 	}
				  	}
				  	else{ balanceado= false;}
				  	break;
			}
			
		}
		if ((balanceado == true)&&(pila.esVacia())){
			System.out.println("El String esta balanceado.");
		}
		else{
			System.out.println("El String no esta balanceado");
		}
	}
}
