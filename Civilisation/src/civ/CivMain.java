package civ;

import joueur.Joueur;

public class CivMain {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
		// supprimer la ligne suivante pour desactiver l'affichage
		Joueur[] lesJoueurs = new Joueur[2];
		for (int i = 0; i < lesJoueurs.length; i++) {
			lesJoueurs[i] = new Joueur();
		}
		FntPrcpl tmp = new FntPrcpl(lesJoueurs);
	}

}
