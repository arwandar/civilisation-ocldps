package Evenements;

import joueur.Joueur;
import Batiment.BatHotelDeVille;
import Unites.Archer;
import Unites.Catapulte;
import Unites.Peon;
import civ.FntPrcpl;

public class Initialisation {
	public static void unitesDuDebut (Joueur J, int x, int y, FntPrcpl laFenetre){
		int[] pos = {x,y};
	    new BatHotelDeVille(pos, laFenetre.affichagejeu.getCarte(y,x), J);
	    
	    Peon hellopeon = new Peon(J);
	    Fonctions.Creation(J.getPersonnages().get(J.getPersonnages().size()-1));
	    hellopeon.setPositionHorizontale(x-1);
	    hellopeon.setPositionVerticale(y);
	    hellopeon.setUsed(false);

	    
	    Peon hellopeon1 = new Peon(J);
	    Fonctions.Creation(J.getPersonnages().get(J.getPersonnages().size()-1));
	    hellopeon1.setPositionHorizontale(x+1);
	    hellopeon1.setPositionVerticale(y);
	    hellopeon1.setUsed(false);

	    Peon hellopeon2 = new Peon(J);
	    Fonctions.Creation(J.getPersonnages().get(J.getPersonnages().size()-1));
	    hellopeon2.setPositionHorizontale(x);
	    hellopeon2.setPositionVerticale(y-1);
	    hellopeon2.setUsed(false);
	    
	    Peon hellopeon3 = new Peon(J);
	    Fonctions.Creation(J.getPersonnages().get(J.getPersonnages().size()-1));
	    hellopeon3.setPositionHorizontale(x);
	    hellopeon3.setPositionVerticale(y+1);
	    hellopeon3.setUsed(false);
	    
	    Catapulte helloarcher = new Catapulte(J);
	    Fonctions.Creation(J.getPersonnages().get(J.getPersonnages().size()-1));
	    helloarcher.setPositionHorizontale(x);
	    helloarcher.setPositionVerticale(y+2);
	    helloarcher.setUsed(false);
	    
	}
}
