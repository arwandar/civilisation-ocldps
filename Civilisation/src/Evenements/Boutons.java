package Evenements;

import java.util.ArrayList;

import joueur.Joueur;
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
	
	public static boolean isBatimentOnCase(int x, int y, Joueur lesJoueurs[]){
		for(int i=0;i<lesJoueurs.length;i++){
			Joueur J = lesJoueurs[i];
			ArrayList<Batiment> perso = J.getBatiments();
			for (Batiment celuiCi : perso){ 
				if (celuiCi.getPOSITION(0)==x && celuiCi.getPOSITION(1)==y)
					return true;
			}
		}
		return false;
	}
	
	public static Personnage trouveUnite(int x, int y, Joueur lesJoueurs[]){
		for(int i=0;i<lesJoueurs.length;i++){
			Joueur J = lesJoueurs[i];
			ArrayList<Personnage> perso = J.getPersonnages();
			for (Personnage celuiCi : perso){
				if (celuiCi.getPositionHorizontale()==x && celuiCi.getPositionVerticale()==y){
					return celuiCi;
				}
			}
		}
		return null;
	}
	
	public static Batiment trouveBatiment(int x, int y, Joueur lesJoueurs[]){
		for(int i=0;i<lesJoueurs.length;i++){
			Joueur J = lesJoueurs[i];
			ArrayList<Batiment> bat = J.getBatiments();
			for (Batiment celuiCi : bat){ 
				if (celuiCi.getPOSITION(0)==x && celuiCi.getPOSITION(1)==y)
					return celuiCi;
			}
		}
		return null;
	}
	
	
	public static boolean deplace(Personnage personnage, int x, int y, Case cas, Joueur lesJoueurs[]){

		if ( isUniteOnCase(x, y, lesJoueurs) ||isBatimentOnCase(x, y, lesJoueurs)){
			//System.out.println("la case est pas vide");
			return false;
		}
		else{
			Evenements.Fonctions.creationDeLaMatrice();
			Evenements.Fonctions.testGps(personnage, y, x);
			if(Evenements.Fonctions.distanceTest>personnage.getMouvement()){
				//System.out.println("Trop loin !"); //rajouter un pop de bouton disant que c'est trop loin et mettant la distance max / pas par relief / distance dépassée
				return false;
			}
			else{
				Evenements.Fonctions.deplacementReel(personnage, x, y);
				personnage.setUsed(true);
				return true;
			}
		}
		

	}
	
	public static boolean attaque (Personnage personnage, int x, int y, Case cas, Joueur lesJoueurs[]){
		String str = new String ();
		
		if(isBatimentOnCase(x, y, lesJoueurs))
			str="batiment";
		else if(isUniteOnCase(x, y, lesJoueurs))
			str="unite";
		else
			str="rien";	
		
		switch(str){
		
			case "batiment" :
				if(!Evenements.Fonctions.isRange(personnage,x,y)){
					System.out.println("trop loin !");
					return false;
				}
				else{					
					Evenements.Fonctions.Attaquer(personnage, trouveBatiment(x, y, lesJoueurs));
					personnage.setUsed(true);
					if (trouveBatiment( x,  y,  lesJoueurs).getPV()<=0){
						trouveBatiment( x,  y,  lesJoueurs).destructionBatiment(cas, trouveBatiment( x,  y,  lesJoueurs).getJoueur());
					}
				}			
				break;
				
			case "unite" :
				if(!Evenements.Fonctions.isRange(personnage,x,y)){
					System.out.println("trop loin !");
					return false;
				}
				else{
					Evenements.Fonctions.Attaquer(personnage, trouveUnite( x,  y,  lesJoueurs));
					personnage.setUsed(true);
					if (trouveUnite( x,  y,  lesJoueurs).getPV()<=0){
						trouveUnite( x,  y,  lesJoueurs).destructionUnite(trouveUnite( x,  y,  lesJoueurs).getJoueur());
					}
						
				}
				break;
				
			default :
				System.out.println("personne à attaquer !");
				return false;
		}
		return true;
			
	}
	
	public static boolean attaqueTourelle (Batiment batiment, int x, int y, Case cas, Joueur lesJoueurs[]){
		
		String str = new String ();
		
		if(isBatimentOnCase(x, y, lesJoueurs))
			str="batiment";
		else if(isUniteOnCase(x, y, lesJoueurs))
			str="unite";
		else
			str="rien";
		
		switch(str){
		
			case "batiment" :
				if(!Evenements.Fonctions.isRangeBat(batiment,x,y)){
					System.out.println("trop loin !");
					return false;
				}
				else{					
					Evenements.Fonctions.Attaquer(batiment, trouveBatiment(x, y, lesJoueurs));
					batiment.setIsUsed(true);
					if (trouveBatiment( x,  y,  lesJoueurs).getPV()<=0){
						trouveBatiment( x,  y,  lesJoueurs).destructionBatiment(cas, trouveBatiment( x,  y,  lesJoueurs).getJoueur());
					}
				}
			
				break;
				
			case "unite" :
				if(!Evenements.Fonctions.isRangeBat(batiment,x,y)){
					System.out.println("trop loin !");
					return false;
				}
				else{
					Evenements.Fonctions.Attaquer(batiment, trouveUnite( x,  y,  lesJoueurs));
					batiment.setIsUsed(true);
					if (trouveUnite( x,  y,  lesJoueurs).getPV()<=0){
						trouveUnite( x,  y,  lesJoueurs).destructionUnite(trouveUnite( x,  y,  lesJoueurs).getJoueur());
					}
					}
				break;
				
			default :
				System.out.println("personne à attaquer !");
				return false;
		}
		return true;
			
	}
	
	
	public static boolean soigne(Personnage personnage, int x, int y, Case cas, Joueur lesJoueurs[]){
		if ( !isUniteOnCase(x, y, lesJoueurs)){
			System.out.println("la case est  vide");
			return false;
		}
		else if(!Evenements.Fonctions.isRange(personnage,x,y)){
					System.out.println("trop loin !");
					return false;
		}
		else{
			Evenements.Fonctions.Soigner(trouveUnite(x, y, lesJoueurs));
			personnage.setUsed(true);
			}
		return true;
		}
	
	public static void cherche (Personnage personnage){
		Evenements.Fonctions.Chercher(personnage.getJoueur());
		personnage.setUsed(true);
		
	}
	
}
