package Unites;

import java.awt.Color;

import civ.FntPrcpl;
import joueur.Joueur;
import Batiment.BatCaserne;
import Batiment.Batiment;
import Evenements.Fonctions;

public class Test {

	public static void main(String[] args) {
		System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
		Joueur[] lesJoueurs = new Joueur[2];
		Color[] couleursPossibles = { Color.black, Color.pink, Color.red };
		for (int i = 0; i < lesJoueurs.length; i++) {
			lesJoueurs[i] = new Joueur(couleursPossibles[i]);
		}
		FntPrcpl tmp = new FntPrcpl(lesJoueurs);
		Fonctions fonctions = new Fonctions(tmp.affichagejeu);
		
		
		Personnage[] tPers = {new Peon(lesJoueurs[0]), new Milicien(lesJoueurs[0]), new Magicien(lesJoueurs[0]), new Healer(lesJoueurs[0]), new Archer(lesJoueurs[0]), new CavalierArcher(lesJoueurs[0]), new Chevalier(lesJoueurs[0]), new Galere(lesJoueurs[0]), new Transporteur(lesJoueurs[0]), new Catapulte(lesJoueurs[0])};
  		
		
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
	    

	    
	    Personnage Attaquant = new Archer(lesJoueurs[0]);
	    Fonctions.Creation(Attaquant);
	    Personnage Defenseur = new Milicien(lesJoueurs[0]);
	    Fonctions.Creation(Defenseur);
	    
	    Attaquant.setPositionHorizontale(2); Attaquant.setPositionVerticale(2);
	    Defenseur.setPositionHorizontale(3);Defenseur.setPositionVerticale(4);
	    
	    Fonctions.isRange(Attaquant, Defenseur, Attaquant.getPortee());
	    System.out.println("Les pv du déf avant attaque sont : " + Defenseur.getPV());
	    Fonctions.Attaquer(Attaquant, Defenseur);
	    System.out.println("Les pv du déf après attaque sont : " + Defenseur.getPV());
	    
	    
	    
	    
	    
	    
	    
	    Personnage Attaquant1 = new Magicien(lesJoueurs[0]);
	    Fonctions.Creation(Attaquant1);
	    Personnage Defenseur1 = new Milicien(lesJoueurs[0]);
	    Fonctions.Creation(Defenseur1);
	 
	    System.out.println("Les pv du déf avant attaque sont : " + Defenseur1.getPV());
	    Fonctions.Attaquer(Attaquant1, Defenseur1);
	    System.out.println("Les pv du déf après attaque sont : " + Defenseur1.getPV());
	    
	    
	    
	    
	  /*  Personnage Attaquant2 = new Milicien(lesJoueurs[0]);
	    Fonctions.Creation(Attaquant2);
	    Batiment Defenseur2= new BatCaserne(null, null, lesJoueurs[0]);
	 
	    System.out.println("Les pv du déf avant attaque sont : " + Defenseur2.getPV());
	    Fonctions.Attaquer(Attaquant2, Defenseur2);
	    System.out.println("Les pv du déf après attaque sont : " + Defenseur2.getPV());*/
	    
	}

}
