package Comportement;

import Unites.Personnage;

/**
 * Définit que l'unité utilise la magie offensive pour se battre
 * @author isen
 *
 */
public class CombatMagie implements AttitudeCombative {
	public void combat(Personnage personnage) {
	    System.out.println("Je combats avec des sorts !");
	    personnage.setPortee(3);
	  }

}