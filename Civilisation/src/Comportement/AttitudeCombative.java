package Comportement;

import Unites.Personnage;

/**
 * Classe m�re regroupant toutes les possibilit�s de combat possibles, actuellement Arc, Epee, Magie, Siege, Pacifiste
 * @author isen
 *
 */
public interface AttitudeCombative {
	public void combat(Personnage personnage);
}
