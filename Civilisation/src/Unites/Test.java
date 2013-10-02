package Unites;

public class Test {

	public static void main(String[] args) {
		Personnage[] tPers = {new Peon(), new Milicien(), new Magicien(), new Healer(), new Archer(), new CavalierArcher(), new Chevalier(), new Galere(), new Transporteur(), new Catapulte()};
  
	    for(int i = 0; i < tPers.length; i++){
	      System.out.println("\nInstance de " + tPers[i].getClass().getName());
	      System.out.println("*****************************************");
	      tPers[i].combattre();
	      tPers[i].seDeplacer();
	      tPers[i].soigner();
	      tPers[i].batir();
	      System.out.println("Mon attaque est de " + tPers[i].Attaque);
	      System.out.println("Ma défense est de " + tPers[i].Defense);
	      System.out.println("Mes PV valent " + tPers[i].PV);
	      System.out.println("Je mets " + tPers[i].tempsProduction + " tours et coûte " + tPers[i].coutNourriture + " " + tPers[i].coutOr + " " + tPers[i].coutBois + " " + tPers[i].coutFer);
	    } 	    
	}

}
