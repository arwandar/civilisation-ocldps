package Unites;
import joueur.Joueur;
import Comportement.Constructeur;

public class Peon extends Personnage {
	public Peon(Joueur J){
		
		super(J);
		
		this.construire = new Constructeur();
		this.PV=25;
		
		this.tempsProduction=1;
		this.coutNourriture=50;
	}
}