package Comportement;

import Unites.Personnage;

/**
 * Définit que l'unité utilise des armes de siège pour se battre
 * @author isen
 *
 */
public class CombatSiege implements AttitudeCombative {
	public void combat(Personnage personnage) {
	  //  System.out.println("Je combats tel une machine de siège !");
	    personnage.setPortee(6);
	  }

}