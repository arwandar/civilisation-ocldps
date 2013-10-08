package Comportement;

import Unites.Personnage;

/**
 * Définit que l'unité ne peut pas se battre
 * @author isen
 *
 */
public class Pacifiste implements AttitudeCombative{
	public void combat(Personnage personnage) {
	    System.out.println("Je ne combats pas !");
	  }
}
