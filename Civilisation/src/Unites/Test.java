package Unites;

import java.awt.Color;

import joueur.Joueur;
import Evenements.Fonctions;

public class Test {

	public static void main(String[] args) {
		
		final Joueur j = new Joueur(Color.pink);
		
		Personnage[] tPers = {new Peon(j), new Milicien(j), new Magicien(j), new Healer(j), new Archer(j), new CavalierArcher(j), new Chevalier(j), new Galere(j), new Transporteur(j), new Catapulte(j)};
  		
		
	    for(int i = 0; i < tPers.length; i++){
	      System.out.println("\nInstance de " + tPers[i].getClass().getName());
	      System.out.println("*****************************************");
	      Fonctions.Creation(tPers[i]);
	      System.out.println("Mon attaque est de " + tPers[i].getAttaque());
	      System.out.println("Ma défense est de " + tPers[i].getDefense());
	      System.out.println("Mes PV valent " + tPers[i].getPV());
	      System.out.println("Je mets " + tPers[i].getTempsProduction() + " tours et coûte " + tPers[i].getCoutNourriture() + " n, " + tPers[i].getCoutOr() + " o, " + tPers[i].getCoutBois() + " b, " + tPers[i].getCoutFer() + " f");
	      System.out.println("Je suis situé en " + tPers[i].getPositionHorizontale() + " ; " + tPers[i].getPositionVerticale() + " et ma portée est de " + tPers[i].getPortee());
	      System.out.println("Je me déplace de " + tPers[i].getMouvement());
	    } 
	    

	    
	    Personnage Attaquant = new Archer(j);
	    Fonctions.Creation(Attaquant);
	    Personnage Defenseur = new Milicien(j);
	    Fonctions.Creation(Defenseur);
	    
	    Attaquant.setPositionHorizontale(2); Attaquant.setPositionVerticale(2);
	    Defenseur.setPositionHorizontale(3);Defenseur.setPositionVerticale(4);
	    
	    Fonctions.isRange(Attaquant, Defenseur, Attaquant.getPortee());
	    System.out.println("Les pv du déf avant attaque sont : " + Defenseur.getPV());
	    Fonctions.Attaquer(Attaquant, Defenseur);
	    System.out.println("Les pv du déf après attaque sont : " + Defenseur.getPV());
	    
	}

}
