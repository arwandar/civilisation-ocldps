package Evenements;

import java.util.ArrayList;

import joueur.Joueur;
import Batiment.BatHotelDeVille;
import Batiment.Batiment;
import Unites.Personnage;
import civ.Case;

public class Boutons {

	public static boolean isUniteOnCase(int x, int y, Joueur lesJoueurs[]){
		for(int i=0;i<lesJoueurs.length;i++){
			Joueur J = lesJoueurs[i];
			ArrayList<Personnage> perso = J.getPersonnages();
			for (Personnage celuiCi : perso){ 
				if (celuiCi.getPositionHorizontale()==x && celuiCi.getPositionVerticale()==y)
					return true;
			}
		}
		return false;
	}
	
	public static Personnage trouveUnite(int x, int y, Joueur lesJoueurs[]){
		Personnage celuiTROUVEOMG = new Personnage(){};
		for(int i=0;i<lesJoueurs.length;i++){
			Joueur J = lesJoueurs[i];
			ArrayList<Personnage> perso = J.getPersonnages();
			for (Personnage celuiCi : perso){ 
				if (celuiCi.getPositionHorizontale()==x && celuiCi.getPositionVerticale()==y)
					celuiTROUVEOMG=celuiCi;
					break;
			}
		}
		return celuiTROUVEOMG;
	}
	
	public static Batiment trouveBatiment(int x, int y, Joueur lesJoueurs[]){
		Batiment celuiTROUVEOMG = new BatHotelDeVille(null, null, null){};
		for(int i=0;i<lesJoueurs.length;i++){
			Joueur J = lesJoueurs[i];
			ArrayList<Batiment> bat = J.getBatiments();
			for (Batiment celuiCi : bat){ 
				if (celuiCi.getPOSITION(0)==x && celuiCi.getPOSITION(1)==y)
					celuiTROUVEOMG=celuiCi;
					break;
			}
		}
		return celuiTROUVEOMG;
	}
	
	
	public static void deplace(Personnage personnage, int x, int y, Case cas, Joueur lesJoueurs[]){
		
		if ( isUniteOnCase(x, y, lesJoueurs) || cas.isBatimentsurcase())
			System.out.println("la case est pas vide");
		else{
			Evenements.Fonctions.testGps(personnage, y, x);
			if(Evenements.Fonctions.distanceTest>personnage.getMouvement())
				System.out.println("Trop loin !"); //rajouter un pop de bouton disant que c'est trop loin et mettant la distance max / pas par relief / distance dépassée
			else{
				Evenements.Fonctions.deplacementReel(personnage);
				personnage.setUsed(true);
			}
		}
		

	}
	
	public static void attaque (Personnage personnage, int x, int y, Case cas, Joueur lesJoueurs[]){
		//tester ce qu'il y a sur la case visée
		//tester que la case est à portée
		//attaquer
		
		
		String str = new String ();
		
		if(cas.isBatimentsurcase())
			str="batiment";
		else if(isUniteOnCase(x, y, lesJoueurs))
			str="unite";
		else
			str="rien";
			
		
		
		switch(str){
		
			case "batiment" :
				if(!Evenements.Fonctions.isRange(personnage,x,y))
					System.out.println("trop loin !");
				else{					
					Evenements.Fonctions.Attaquer(personnage, trouveBatiment(x, y, lesJoueurs));
					personnage.setUsed(true);
				}
			
				break;
				
			case "unite" :
				if(!Evenements.Fonctions.isRange(personnage,x,y))
					System.out.println("trop loin !");
				else{
					Evenements.Fonctions.Attaquer(personnage, trouveUnite( x,  y,  lesJoueurs));
					personnage.setUsed(true);
					}
				break;
				
			default :
				System.out.println("personne à attaquer !");
		}
			
	}
	
	public static void attaqueTourelle (Batiment batiment, int x, int y, Case cas, Joueur lesJoueurs[]){
		//tester ce qu'il y a sur la case visée
		//tester que la case est à portée
		//attaquer
		
		
		String str = new String ();
		
		if(cas.isBatimentsurcase())
			str="batiment";
		else if(isUniteOnCase(x, y, lesJoueurs))
			str="unite";
		else
			str="rien";
			
		
		
		switch(str){
		
			case "batiment" :
				if(!Evenements.Fonctions.isRangeBat(batiment,x,y))
					System.out.println("trop loin !");
				else{					
					Evenements.Fonctions.Attaquer(batiment, trouveBatiment(x, y, lesJoueurs));
					batiment.setIsUsed(true);
				}
			
				break;
				
			case "unite" :
				if(!Evenements.Fonctions.isRangeBat(batiment,x,y))
					System.out.println("trop loin !");
				else{
					Evenements.Fonctions.Attaquer(batiment, trouveUnite( x,  y,  lesJoueurs));
					batiment.setIsUsed(true);
					}
				break;
				
			default :
				System.out.println("personne à attaquer !");
		}
			
	}
	
	
	public static void soigne(Personnage personnage, int x, int y, Case cas, Joueur lesJoueurs[]){
		if ( !isUniteOnCase(x, y, lesJoueurs))
			System.out.println("la case est  vide");
		else if(!Evenements.Fonctions.isRange(personnage,x,y))
					System.out.println("trop loin !");
		else{
			Evenements.Fonctions.Soigner(trouveUnite(x, y, lesJoueurs));
			personnage.setUsed(true);
			}
		}
	
	public static void cherche (Personnage personnage){
		Evenements.Fonctions.Chercher(personnage.getJoueur());
		personnage.setUsed(true);
		
	}
	
}
