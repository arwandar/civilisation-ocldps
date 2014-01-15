package Evenements;

import joueur.Joueur;
import Batiment.BatHotelDeVille;
import Unites.Peon;
import civ.FntPrcpl;

public class Initialisation {
	public static void unitesDuDebut (Joueur J, int x, int y, FntPrcpl laFenetre){
		int[] pos = {x,y};
	    J.getBatiments().add(new BatHotelDeVille(pos, laFenetre.affichagejeu.getCarte(y,x), J));
	    
	    J.getPersonnages().add(new Peon(J));
	    Fonctions.Creation(J.getPersonnages().get(J.getPersonnages().size()-1));
	    J.getPersonnages().get(J.getPersonnages().size()-1).setPositionHorizontale(x-1);
	    J.getPersonnages().get(J.getPersonnages().size()-1).setPositionVerticale(y);
	      
	    J.getPersonnages().add(new Peon(J));
	    Fonctions.Creation(J.getPersonnages().get(J.getPersonnages().size()-1));
	    J.getPersonnages().get(J.getPersonnages().size()-1).setPositionHorizontale(x+1);
	    J.getPersonnages().get(J.getPersonnages().size()-1).setPositionVerticale(y);
	    
	    J.getPersonnages().add(new Peon(J));
	    Fonctions.Creation(J.getPersonnages().get(J.getPersonnages().size()-1));
	    J.getPersonnages().get(J.getPersonnages().size()-1).setPositionHorizontale(x);
	    J.getPersonnages().get(J.getPersonnages().size()-1).setPositionVerticale(y-1);
	    
	    J.getPersonnages().add(new Peon(J));
	    Fonctions.Creation(J.getPersonnages().get(J.getPersonnages().size()-1));
	    J.getPersonnages().get(J.getPersonnages().size()-1).setPositionHorizontale(x);
	    J.getPersonnages().get(J.getPersonnages().size()-1).setPositionVerticale(y+1);
	}
}
