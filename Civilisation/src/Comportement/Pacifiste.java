package Comportement;

import Unites.Personnage;

/**
 * D�finit que l'unit� ne peut pas se battre
 * @author isen
 *
 */
public class Pacifiste implements AttitudeCombative{
	public void combat(Personnage personnage) {
	    System.out.println("Je ne combats pas !");
	  }
}
