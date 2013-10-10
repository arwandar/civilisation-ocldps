package Combat;

import Unites.Personnage;

public class Fonctions {

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
	
}
