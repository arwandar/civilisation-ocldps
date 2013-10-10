package Unites;
import joueur.Joueur;
import Comportement.Bateau;

public class Transporteur extends Personnage {
	public Transporteur(Joueur J){
		
		super(J);
		
		this.deplacer = new Bateau();
		this.Defense=15;
		this.PV=100;
		
		this.tempsProduction=3;
		this.coutBois=125;
	}
}
