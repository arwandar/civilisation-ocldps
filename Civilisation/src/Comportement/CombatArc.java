package Comportement;

import Unites.Personnage;

/**
 * D�finit que l'unit� utilise un arc pour se battre
 * @author isen
 *
 */
public class CombatArc implements AttitudeCombative {
	public void combat(Personnage personnage) {
	 //   System.out.println("Je combats � l'arc !");
	    personnage.setPortee(4);
	  }

}

