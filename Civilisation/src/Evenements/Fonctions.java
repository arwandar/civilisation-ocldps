package Evenements;

import joueur.Joueur;
import civ.FntPrcpl;
import civ.PanelPrcpl;
import civ.Texture;
import Unites.Personnage;



public class Fonctions {
	
	static PanelPrcpl plateau = new PanelPrcpl();
	
	public Fonctions(PanelPrcpl plateau){
		this.plateau=plateau;
		
	}

	
	
	
	public static int decalageHorizontal = 0;
	public static int decalageVertical = 0;
	
	
	public static boolean isRange(Personnage Attaquant, Personnage Defenseur, int portee){
		int decalageHorizontal = Math.abs(Attaquant.getPositionHorizontale() - Defenseur.getPositionHorizontale());
		int decalageVertical = Math.abs(Attaquant.getPositionVerticale() - Defenseur.getPositionVerticale());
		
		if (decalageHorizontal <= portee && decalageVertical <= portee){			
			System.out.println("True");
			return true;
		}			
		else{			
			System.out.println("False");
			return false;
		}		
	}
	
	public static void Attaquer(Personnage attaquant, Personnage defenseur){
		defenseur.PV-= attaquant.getAttaque() -  Math.round(attaquant.getAttaque() * defenseur.getDefense());
	}
	public static void AttaquerMagie(Personnage attaquant, Personnage defenseur){
		defenseur.PV-= attaquant.getAttaque() ;
	}
	
	public static void Creation(Personnage personnage){
		 personnage.combattre();
		 personnage.seDeplacer();
		 personnage.soigner();
		 personnage.batir();
	}
	
	public static void Itineraire (Personnage personnage, int valeurHorizontale, int valeurVerticale){
		int deplacementRestant = personnage.getMouvement();
		boolean deplacementFini = false;
		decalageHorizontal = 0;
		decalageVertical = 0;
		
		CheckDecalages( personnage,  valeurHorizontale,  valeurVerticale);
		
		while (!deplacementFini && decalageHorizontal != 0){
			if(decalageHorizontal > 0){ //il doit aller à droite
				DeplacementDroite(personnage);
				DeplacementFini(deplacementRestant,deplacementFini);
				CheckDecalages( personnage,  valeurHorizontale,  valeurVerticale);
			}
			else { // il doit aller à gauche
				DeplacementGauche(personnage);		
				DeplacementFini(deplacementRestant,deplacementFini);
				CheckDecalages( personnage,  valeurHorizontale,  valeurVerticale);
			}			
		}
		
		while (!deplacementFini && decalageVertical != 0){
			if(decalageVertical > 0){ //il doit aller en bas
				DeplacementBas(personnage);
				DeplacementFini(deplacementRestant,deplacementFini);
				CheckDecalages( personnage,  valeurHorizontale,  valeurVerticale);
			}
			else { // il doit aller en haut
				DeplacementHaut(personnage);	
				DeplacementFini(deplacementRestant,deplacementFini);
				CheckDecalages( personnage,  valeurHorizontale,  valeurVerticale);
			}			
		}
		
	}
		
	public static void DeplacementHaut (Personnage personnage){
		personnage.setPositionVerticale(personnage.getPositionVerticale()-1);
	}
	public static void DeplacementBas (Personnage personnage){
		personnage.setPositionVerticale(personnage.getPositionVerticale()+1);
	}
	public static void DeplacementGauche (Personnage personnage){
		personnage.setPositionHorizontale(personnage.getPositionHorizontale()-1);
	}
	public static void DeplacementDroite (Personnage personnage){
		personnage.setPositionHorizontale(personnage.getPositionHorizontale()+1);
	}
	public static void DeplacementFini(int deplacementRestant ,	boolean deplacementFini ){ //soustrait au déplacement du perso une certaine valeur et regarde s'il peut encore bouger (modifiable plus tard en fct du terrain (rajouter un entier coeff))
		deplacementRestant--;
		if (deplacementRestant==0)
			deplacementFini=true;		
	}
	public static void CheckDecalages(Personnage personnage, int valeurHorizontale, int valeurVerticale){ //calcule le nombre de cases dont il faudrait se décaler pour arriver à la case voulue
		decalageHorizontal = valeurHorizontale - personnage.getPositionHorizontale(); //case arrivée - case du perso
		decalageVertical = valeurVerticale - personnage.getPositionVerticale();
	}
	
	public static int TestTerrain (int valeurHorizontale, int valeurVerticale){
		if ( plateau.getCarte(valeurHorizontale,valeurVerticale).isBatimentsurcase() || plateau.getCarte(valeurHorizontale,valeurVerticale).isUnitesurcase())
			return 0;
		else if ( plateau.getCarte(valeurHorizontale,valeurVerticale).getTexture() == Texture.foret)
			return 2;
		else if (plateau.getCarte(valeurHorizontale,valeurVerticale).getTexture() == Texture.montagne)
			return 3;
		else
			return 1;
	}
	
}
