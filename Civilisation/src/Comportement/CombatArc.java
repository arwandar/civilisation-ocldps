package Comportement;

import Unites.Personnage;

/**
 * Définit que l'unité utilise un arc pour se battre
 * @author isen
 *
 */
public class CombatArc implements AttitudeCombative {
	public void combat(Personnage personnage) {
	 //   System.out.println("Je combats à l'arc !");
	    personnage.setPortee(4);
	  }

}

