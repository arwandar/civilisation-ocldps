package Unites;

public class Test {

	public static void main(String[] args) {
		Personnage[] tPers = {new Milicien(), new Peon(), new Healer()};
  
	    for(int i = 0; i < tPers.length; i++){
	      System.out.println("\nInstance de " + tPers[i].getClass().getName());
	      System.out.println("*****************************************");
	      tPers[i].combattre();
	      tPers[i].seDeplacer();
	      tPers[i].soigner();
	      tPers[i].batir();
	    } 	    
	}

}
