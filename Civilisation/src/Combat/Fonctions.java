package Combat;

import Unites.Personnage;

public class Fonctions {

	public static boolean isRange(Personnage Attaquant, Personnage Defenseur, int portee){
		int decalageHorizontal = Math.abs(Attaquant.getPositionHorizontale() - Defenseur.getPositionHorizontale());
		int decalageVertical = Math.abs(Attaquant.getPositionVerticale() - Defenseur.getPositionVerticale());
		
		System.out.println(decalageHorizontal);
		System.out.println(decalageVertical);
		System.out.println(portee);
		
		if (decalageHorizontal <= portee && decalageVertical <= portee){			
			System.out.println("True");
			return true;
		}			
		else{			
			System.out.println("False");
			return false;
		}
			
		
	}
	
	public static void Attaquer(Personnage Attaquant, Personnage Defenseur){
		System.out.println(Attaquant.Attaque);
		System.out.println(Defenseur.Defense);
		int degatsInfliges= Math.round(Attaquant.Attaque * Defenseur.Defense/100)+1;
		System.out.println(degatsInfliges);
		Defenseur.PV-= degatsInfliges;
	}
	
	public static void Creation(Personnage personnage){
		 personnage.combattre();
		 personnage.seDeplacer();
		 personnage.soigner();
		 personnage.batir();
	}
	
}
