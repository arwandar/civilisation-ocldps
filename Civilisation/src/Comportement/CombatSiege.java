package Comportement;

import Unites.Personnage;

/**
 * D�finit que l'unit� utilise des armes de si�ge pour se battre
 * @author isen
 *
 */
public class CombatSiege implements AttitudeCombative {
	public void combat(Personnage personnage) {
	  //  System.out.println("Je combats tel une machine de si�ge !");
	    personnage.setPortee(6);
	  }

}