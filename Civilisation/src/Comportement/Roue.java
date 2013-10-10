package Comportement;

import Unites.Personnage;

/**
 * D�finit que l'unit� se d�place sur des roues
 * @author isen
 *
 */
public class Roue implements Deplacer {
	public void deplacer(Personnage personnage){
		//System.out.println("Je me d�place sur des roues");
		personnage.setMouvement(2);
	}
}