package tp03.ejercicio6;

import tp03.ejercicio5.Mobile;
import tp03.ejercicio5.SmartPhone;
import tp03.ejercicio5.Tablet;

public class TestListaEnlazadaGenerica {

	public static void main(String[] args) {
			Mobile m1 = new Tablet("marca", "sistemaOperativo", "modelo", 1, 4);
			Mobile m2 = new Tablet("1", "2", "3", 4, 5);
			Mobile m3 = new SmartPhone("apple", "IOS", "5s", 100, 15344324);
			Mobile m4 = new SmartPhone("moto", "android", "X", 50, 15000001);
			Mobile m5 = new SmartPhone("espero", "que", "Funcione", 0, 0);
			
			ListaEnlazadaGenerica<Mobile> lista = new ListaEnlazadaGenerica<Mobile>();
			lista.agregarInicio(m1);
			lista.agregarInicio(m2);
			lista.agregarFinal(m3);
			lista.agregarEn(m4, 2);
		
			
			ListaEnlazadaGenerica<Mobile> lista2 = new ListaEnlazadaGenerica<Mobile>();
			lista2 = lista.clonar();
			lista2.eliminarEn (2);
			lista2.eliminarEn(1);
			lista2.agregarEn(m5, 2);
			
			System.out.println(lista);
			//DEBE DEVOLVER M2 ---> M4 ---> M1 ---> M3
			System.out.println(lista2);
			//DEBE DEVOLVER M5 ---> M1 ---> M3

	}

}
