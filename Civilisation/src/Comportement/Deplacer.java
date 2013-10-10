package Comportement;

import Unites.Personnage;

/**
 * Classe mère regroupant toutes les possibilités de déplacement possibles, actuellement Marche, Cheval, Bateau
 * @author isen
 *
 */
public interface Deplacer {
	public void deplacer(Personnage personnage);
}
