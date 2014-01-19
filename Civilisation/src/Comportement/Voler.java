package Comportement;

import Unites.Personnage;

/**
 * D�finit que l'unit� se d�place sur l'eau
 * @author isen
 *
 */
public class Voler implements Deplacer {
	public void deplacer(Personnage personnage){
		//System.out.println("Je me d�place en flottant");
		personnage.setMouvement(60);
	}
}