package Evenements;

import joueur.Joueur;
import civ.FntPrcpl;
import civ.PanelPrcpl;
import civ.Texture;
import Unites.Personnage;



public class Fonctions {
	
	static PanelPrcpl plateau;
	
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
		boolean direction = true;
		int coeff=0;
		
		CheckDecalages( personnage,  valeurHorizontale,  valeurVerticale);
		
		while (direction && !deplacementFini && decalageHorizontal != 0){
			
			if(decalageHorizontal > 0){ //il doit aller à droite				
				// on regarde si la case visée est traversable et combien de mouvement on doit utiliser			
				coeff=TestTerrain((personnage.getPositionHorizontale()+1), personnage.getPositionVerticale());				
				if (coeff==0)
					direction = false; // si on peut pas traverser on change d'axe
				else {
					// on regarde si le joueur dispose d'assez de mouvement pour aller jusqu'à la case
					if(!PossibiliteDepla(coeff, deplacementRestant))
						direction = false; // on ne peut pas y aller
					else{
						// on se déplace
						DeplacementDroite(personnage);
						// retire le nombre de mvts nécessaire pour se déplacer et indique si le mvt est terminé ou non
						DeplacementFini(deplacementRestant,deplacementFini, coeff);
					}					
				}
				// on actualise le décalage nécessaire
				CheckDecalages( personnage,  valeurHorizontale,  valeurVerticale);
			}
			else { // il doit aller à gauche				
				coeff=TestTerrain((personnage.getPositionHorizontale()-1), personnage.getPositionVerticale());				
				if (coeff==0)
					direction = false;
				else {
					if(!PossibiliteDepla(coeff, deplacementRestant))
						direction = false;
					else{
						DeplacementGauche(personnage);
						DeplacementFini(deplacementRestant,deplacementFini, coeff);
					}					
				}
				CheckDecalages( personnage,  valeurHorizontale,  valeurVerticale);
			}			
		}
		
		while (!direction && !deplacementFini && decalageVertical != 0){
			if(decalageVertical > 0){ //il doit aller en bas
				coeff=TestTerrain((personnage.getPositionHorizontale()), personnage.getPositionVerticale()+1);				
				if (coeff==0)
					direction = true;
				else {
					if(!PossibiliteDepla(coeff, deplacementRestant))
						direction = true;
					else{
						DeplacementBas(personnage);
						DeplacementFini(deplacementRestant,deplacementFini, coeff);
					}					
				}
				CheckDecalages( personnage,  valeurHorizontale,  valeurVerticale);		
			}
			else { // il doit aller en haut
				coeff=TestTerrain((personnage.getPositionHorizontale()), personnage.getPositionVerticale()-1);				
				if (coeff==0)
					direction = true;
				else {
					if(!PossibiliteDepla(coeff, deplacementRestant))
						direction = true;
					else{
						DeplacementHaut(personnage);
						DeplacementFini(deplacementRestant,deplacementFini, coeff);
					}					
				}
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
	public static void DeplacementFini(int deplacementRestant ,	boolean deplacementFini, int coeff ){ //soustrait au déplacement du perso une certaine valeur et regarde s'il peut encore bouger (modifiable plus tard en fct du terrain (rajouter un entier coeff))
		deplacementRestant-=coeff;
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
	public static boolean PossibiliteDepla(int coeff, int deplacementRestant){
		if (deplacementRestant - coeff >=0)
			return true;
		else
			return false;
	}
	
}
