package Comportement;

import Unites.Personnage;

/**
 * Définit que l'unité utilise une épee pour se battre
 * @author isen
 *
 */
public class CombatEpee implements AttitudeCombative {
	public void combat(Personnage personnage) {
	    System.out.println("Je combats à l'épée !");
	  }

}
