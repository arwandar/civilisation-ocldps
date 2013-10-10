package Comportement;

import Unites.Personnage;

/**
 * D�finit que l'unit� se d�place sur une monture
 * @author isen
 *
 */
public class Cheval implements Deplacer {
	public void deplacer(Personnage personnage){
		//System.out.println("Je me d�place � cheval");
		personnage.setMouvement(6);
	}
}