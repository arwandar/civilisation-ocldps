package Evenements;

import joueur.Joueur;
import civ.FntPrcpl;
import civ.PanelPrcpl;
import civ.Texture;
import Batiment.BatProdUnit.typeUnite;
import Batiment.Batiment;
import Unites.Personnage;



public class Fonctions {
	
	static PanelPrcpl plateau;
	static int deplacementRestant = 0;
	static int decalageHorizontal = 0;
	static int decalageVertical = 0;
	static boolean deplacementFini = false;
	
	public Fonctions(PanelPrcpl plateau){
		this.plateau=plateau;
		
		
	}

	
	
	
	//public static int decalageHorizontal = 0;
	//public static int decalageVertical = 0;
	//private static int deplacementRestant = 0;
	
	
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
	public static boolean isRange(Personnage Attaquant, Batiment Defenseur, int portee){
		int decalageHorizontal = Math.abs(Attaquant.getPositionHorizontale() - Defenseur.getPOSITION(0));
		int decalageVertical = Math.abs(Attaquant.getPositionVerticale() - Defenseur.getPOSITION(1));
		
		if (decalageHorizontal <= portee && decalageVertical <= portee){			
			System.out.println("True");
			return true;
		}			
		else{			
			System.out.println("False");
			return false;
		}		
	}
	
	public static void Attaquer(Personnage attaquant, Personnage defenseur){ //attaque entre deux unités
		
		if (defenseur.getT()==typeUnite.Magicien)
			defenseur.setPV(defenseur.getPV() - attaquant.getAttaque()) ; // les magiciens ignorent l'armure
		else
			defenseur.setPV(defenseur.getPV() - (attaquant.getAttaque() -  Math.round(attaquant.getAttaque() * defenseur.getDefense())));
	}
	public static void Attaquer(Personnage attaquant, Batiment defenseur){ //attaque entre une unité et un bâtiment
		defenseur.setPV((int)(defenseur.getPV()- (attaquant.getAttaque() -  Math.round(attaquant.getAttaque() * defenseur.getDEF())) ));
	}
	public static void Attaquer(Batiment attaquant, Personnage defenseur){ //attaque entre une unité et un bâtiment
		defenseur.setPV(defenseur.getPV()- (attaquant.getATT() -  Math.round(attaquant.getATT() * defenseur.getDefense())) );
	}
	
	
	
	
	public static void Creation(Personnage personnage){
		 personnage.combattre();
		 personnage.seDeplacer();
		 personnage.soigner();
		 personnage.batir();
	}
	
	
	
	public static void Itineraire (Personnage personnage, int valeurHorizontale, int valeurVerticale){
		setDeplacementRestant(personnage.getMouvement());
		System.out.println("On peut se déplacer de " + getDeplacementRestant());
		setDeplacementFini(false);
		setDecalageHorizontal(0);
		setDecalageVertical(0);
		boolean direction = true;
		int coeff=0;
		
		CheckDecalages( personnage,  valeurHorizontale,  valeurVerticale);  //calcule le nombre de cases dont il faudrait se décaler pour arriver à la case voulue, dans les deux axes
		
		while (direction && !deplacementFini && decalageHorizontal != 0){
			
			if(decalageHorizontal > 0){ //il doit aller à droite				
				// on regarde si la case visée est traversable et combien de mouvement on doit utiliser			
				coeff=TestTerrain((personnage.getPositionHorizontale()+1), personnage.getPositionVerticale());	//renvoie la difficulté de franchissement du terrain
				System.out.println("le coeff est : " + coeff);
				if (coeff==0)
					direction = false; // si on peut pas traverser on change d'axe
				else {
					// on regarde si le joueur dispose d'assez de mouvement pour aller jusqu'à la case
					if(!PossibiliteDepla(coeff, getDeplacementRestant()))
						direction = false; // on ne peut pas y aller
					else{
						// on se déplace
						DeplacementDroite(personnage);
						System.out.println("Le personnage se déplace d'un cran vers la droite");
						// retire le nombre de mvts nécessaire pour se déplacer et indique si le mvt est terminé ou non
						DeplacementFini(getDeplacementRestant(),deplacementFini, coeff);
						System.out.println("dépla restant après la fonction depla fini : " + getDeplacementRestant());
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
					if(!PossibiliteDepla(coeff, getDeplacementRestant()))
						direction = false;
					else{
						DeplacementGauche(personnage);
						System.out.println("Le personnage se déplace d'un cran vers la gauche");
						DeplacementFini(getDeplacementRestant(),deplacementFini, coeff);
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
					if(!PossibiliteDepla(coeff, getDeplacementRestant()))
						direction = true;
					else{
						DeplacementBas(personnage);
						System.out.println("Le personnage se déplace d'un cran vers le bas");
						DeplacementFini(getDeplacementRestant(),deplacementFini, coeff);
					}					
				}
				CheckDecalages( personnage,  valeurHorizontale,  valeurVerticale);		
			}
			else { // il doit aller en haut
				coeff=TestTerrain((personnage.getPositionHorizontale()), personnage.getPositionVerticale()-1);				
				if (coeff==0)
					direction = true;
				else {
					if(!PossibiliteDepla(coeff, getDeplacementRestant()))
						direction = true;
					else{
						DeplacementHaut(personnage);
						System.out.println("Le personnage se déplace d'un cran vers le haut");
						DeplacementFini(getDeplacementRestant(),deplacementFini, coeff);
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
		setDeplacementRestant(getDeplacementRestant()-coeff);
		System.out.println("dépla restant dans la fonction depla fini : " + getDeplacementRestant());
		if (getDeplacementRestant()==0)
			setDeplacementFini(true);		
	}
	public static void CheckDecalages(Personnage personnage, int valeurHorizontale, int valeurVerticale){ //calcule le nombre de cases dont il faudrait se décaler pour arriver à la case voulue
		setDecalageHorizontal(valeurHorizontale - personnage.getPositionHorizontale()); //case arrivée - case du perso
		setDecalageVertical(valeurVerticale - personnage.getPositionVerticale());
	}
	
	public static int TestTerrain (int valeurHorizontale, int valeurVerticale){ //renvoie la difficulté de franchissement du terrain
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
		if (getDeplacementRestant() - coeff >=0)
			return true;
		else
			return false;
	}
	public static int getDeplacementRestant() {
		return deplacementRestant;
	}
	public static void setDeplacementRestant(int deplacementRestant1) {
		deplacementRestant = deplacementRestant1;
	}




	public static int getDecalageHorizontal() {
		return decalageHorizontal;
	}




	public static void setDecalageHorizontal(int decalageHorizontal) {
		Fonctions.decalageHorizontal = decalageHorizontal;
	}




	public static int getDecalageVertical() {
		return decalageVertical;
	}




	public static void setDecalageVertical(int decalageVertical) {
		Fonctions.decalageVertical = decalageVertical;
	}




	public static boolean isDeplacementFini() {
		return deplacementFini;
	}




	public static void setDeplacementFini(boolean deplacementFini) {
		Fonctions.deplacementFini = deplacementFini;
	}
	
}
