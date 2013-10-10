package Unites;
import joueur.Joueur;
import Comportement.Bateau;

public class Transporteur extends Personnage {
	public Transporteur(Joueur J){
		
		J.getPersonnages().add(this);
		this.joueur = J;
		
		this.deplacer = new Bateau();
		this.Defense=15;
		this.PV=100;
		
		this.tempsProduction=3;
		this.coutBois=125;
	}
}
