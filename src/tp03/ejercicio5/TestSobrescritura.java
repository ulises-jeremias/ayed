package tp03.ejercicio5;

public class TestSobrescritura {

	public static void main(String[] args) {
		Tablet t1 = new Tablet();
		Tablet t2 = new Tablet ();
		
		t1.setCosto(1);
		t2.setCosto(1);
		t1.setMarca("a");
		t2.setMarca("a");
		t1.setSistemaOperativo("a");
		t2.setSistemaOperativo("a");		
		t1.setModelo("a");
		t2.setModelo("a");		
		t1.setPulgadas(4);
		t2.setPulgadas(4);
		System.out.println(t1.equals(t2));
		
		System.out.println(t1);

	}

}