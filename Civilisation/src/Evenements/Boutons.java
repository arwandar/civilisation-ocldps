package Evenements;

import Unites.Personnage;
import civ.Case;

public class Boutons {

	
	public static void deplacement(Personnage personnage, int x, int y, Case cas){
		if(cas.isBatimentsurcase() || cas.isUnitesurcase())
			System.out.println("la case est pas vide");
		else{
			Evenements.Fonctions.testGps(personnage, y, x);
			if(Evenements.Fonctions.distanceTest>personnage.getMouvement())
				System.out.println("Trop loin !"); //rajouter un pop de bouton disant que c'est trop loin et mettant la distance max / pas par relief / distance dépassée
			else
				Evenements.Fonctions.deplacementReel(personnage);
		}
		

	}
	
	public static void attaque (Personnage personnage, int x, int y, Case cas){
		//tester ce qu'il y a sur la case visée
		//tester que la case est à portée
		//attaquer
		
		
		String str = new String ();
		
		if(cas.isBatimentsurcase())
			str="batiment";
		else if(cas.isUnitesurcase())
			str="unite";
		else
			str="rien";
			
		
		
		switch(str){
		
			case "batiment" :
				if(!Evenements.Fonctions.isRange(personnage,x,y))
					System.out.println("trop loin !");
				else
					cas.
					Evenements.Fonctions.Attaquer(personnage, defenseur);
			
				break;
				
			case "unite" :
				if(!Evenements.Fonctions.isRange(personnage,x,y))
					System.out.println("trop loin !");
				else
					Evenements.Fonctions.Attaquer(personnage, defenseur);
			
				break;
				
			default :
				System.out.println("personne à attaquer !");
		}
			
	}
	
}
