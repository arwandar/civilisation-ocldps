package Comportement;

import Unites.Personnage;

/**
 * D�finit que l'unit� utilise une �pee pour se battre
 * @author isen
 *
 */
public class CombatEpee implements AttitudeCombative {
	public void combat(Personnage personnage) {
	    System.out.println("Je combats � l'�p�e !");
	  }

}
