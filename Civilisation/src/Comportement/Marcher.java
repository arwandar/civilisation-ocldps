package Comportement;

import Unites.Personnage;

/**
 * D�finit que l'unit� se d�place � pied
 * @author isen
 *
 */
public class Marcher implements Deplacer {
	public void deplacer(Personnage personnage){
		//System.out.println("Je me d�place � pied");
		personnage.setMouvement(3);
	}
}
