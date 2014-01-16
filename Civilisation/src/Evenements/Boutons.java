package Evenements;

import Unites.Personnage;

public class Boutons {

	
	public static void deplacement(Personnage personnage, int x, int y){
		Evenements.Fonctions.testGps(personnage, y, x);
		if(Evenements.Fonctions.distanceTest>personnage.getMouvement())
			System.out.println("Trop loin !"); //rajouter un pop de bouton disant que c'est trop loin et mettant la distance max / pas par relief / distance dépassée
		else
			Evenements.Fonctions.deplacementReel(personnage);
	}
}
