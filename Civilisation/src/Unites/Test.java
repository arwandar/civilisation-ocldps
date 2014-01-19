package Unites;

import java.awt.Color;
import java.util.ArrayList;

import joueur.Joueur;
import Batiment.BatProdRes;
import Batiment.Batiment;
import Evenements.Fonctions;
import civ.FntPrcpl;

public class Test {

	public static boolean partieEnCours = true;

	public static void debutDeTour(Joueur J) { // initialise un tour en rendant
												// les unit�s dispo et en
												// augmentant les ressource + en
												// avan�ant les constructions et
												// les technologies
		// parcourt la liste des b�timents de prod et ajoute les ressources
		ArrayList<Batiment> batimentPossible = J.getBatiments();
		for (Batiment celuiLa : batimentPossible) {
			if (celuiLa.getNOM().indexOf("mine") != -1) { // A VERIFIER
				// on a trouv� un b�timent de production de ressources
				((BatProdRes) celuiLa).productionDeRessources(J);
			}
		}

		// parcourt la liste des unit�s et les passe en notUsed
		ArrayList<Personnage> perso = J.getPersonnages();
		for (Personnage celuiCi : perso) {
			celuiCi.setUsed(false);
		}

		// parcourt la liste des batiments et les passe en notUsed
		ArrayList<Batiment> batimentPossible2 = J.getBatiments();
		for (Batiment celuiLa : batimentPossible2) {
			celuiLa.setIsUsed(false);
		}
	}

	public static boolean isFini(Joueur J) {
		ArrayList<Batiment> batimentPossible = J.getBatiments();
		for (Batiment celuiLa : batimentPossible) {
			if (celuiLa.getNOM() == "Hotel de ville") {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
		Joueur[] lesJoueurs = new Joueur[2];
		Color[] couleursPossibles = { Color.magenta, Color.pink, Color.red };
		for (int i = 0; i < lesJoueurs.length; i++) {
			lesJoueurs[i] = new Joueur(couleursPossibles[i], lesJoueurs);
		}
		FntPrcpl tmp = new FntPrcpl(lesJoueurs);
		Fonctions fonctions = new Fonctions(tmp.affichagejeu);
	}
}
