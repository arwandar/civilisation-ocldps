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
	      System.out.println("Ma défense est de " + tPers[i].getDefense());
	      System.out.println("Mes PV valent " + tPers[i].getPV());
	      System.out.println("Je mets " + tPers[i].getTempsProduction() + " tours et coûte " + tPers[i].getCoutNourriture() + " n, " + tPers[i].getCoutOr() + " o, " + tPers[i].getCoutBois() + " b, " + tPers[i].getCoutFer() + " f");
	      System.out.println("Je suis situé en " + tPers[i].getPositionHorizontale() + " ; " + tPers[i].getPositionVerticale() + " et ma portée est de " + tPers[i].getPortee());
	    } 
	    

	    
	    Personnage Attaquant = new Archer();
	    Fonctions.Creation(Attaquant);
	    Personnage Defenseur = new Milicien();
	    Fonctions.Creation(Defenseur);
	    
	    Attaquant.setPositionHorizontale(2); Attaquant.setPositionVerticale(2);
	    Defenseur.setPositionHorizontale(3);Defenseur.setPositionVerticale(4);
	    
	    Fonctions.isRange(Attaquant, Defenseur, Attaquant.getPortee());
	    System.out.println("Les pv du déf avant attaque sont : " + Defenseur.getPV());
	    Fonctions.Attaquer(Attaquant, Defenseur);
	    System.out.println("Les pv du déf après attaque sont : " + Defenseur.getPV());
	    
	}

}
