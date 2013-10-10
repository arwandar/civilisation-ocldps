package Unites;

import Combat.Fonctions;

public class Test {

	public static void main(String[] args) {
		Personnage[] tPers = {new Peon(), new Milicien(), new Magicien(), new Healer(), new Archer(), new CavalierArcher(), new Chevalier(), new Galere(), new Transporteur(), new Catapulte()};
  		
		
	    for(int i = 0; i < tPers.length; i++){
	      System.out.println("\nInstance de " + tPers[i].getClass().getName());
	      System.out.println("*****************************************");
	      Fonctions.Creation(tPers[i]);
	      System.out.println("Mon attaque est de " + tPers[i].getAttaque());
	      System.out.println("Ma d�fense est de " + tPers[i].getDefense());
	      System.out.println("Mes PV valent " + tPers[i].getPV());
	      System.out.println("Je mets " + tPers[i].getTempsProduction() + " tours et co�te " + tPers[i].getCoutNourriture() + " n, " + tPers[i].getCoutOr() + " o, " + tPers[i].getCoutBois() + " b, " + tPers[i].getCoutFer() + " f");
	      System.out.println("Je suis situ� en " + tPers[i].getPositionHorizontale() + " ; " + tPers[i].getPositionVerticale() + " et ma port�e est de " + tPers[i].getPortee());
	    } 
	    

	    
	    Personnage Attaquant = new Archer();
	    Fonctions.Creation(Attaquant);
	    Personnage Defenseur = new Milicien();
	    Fonctions.Creation(Defenseur);
	    
	    Attaquant.setPositionHorizontale(2); Attaquant.setPositionVerticale(2);
	    Defenseur.setPositionHorizontale(3);Defenseur.setPositionVerticale(4);
	    
	    Fonctions.isRange(Attaquant, Defenseur, Attaquant.getPortee());
	    System.out.println("Les pv du d�f avant attaque sont : " + Defenseur.getPV());
	    Fonctions.Attaquer(Attaquant, Defenseur);
	    System.out.println("Les pv du d�f apr�s attaque sont : " + Defenseur.getPV());
	    
	}

}
