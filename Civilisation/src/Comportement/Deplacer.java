package Comportement;

import Unites.Personnage;

/**
 * Classe m�re regroupant toutes les possibilit�s de d�placement possibles, actuellement Marche, Cheval, Bateau
 * @author isen
 *
 */
public interface Deplacer {
	public void deplacer(Personnage personnage);
}
