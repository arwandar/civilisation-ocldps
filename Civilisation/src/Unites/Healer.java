package Unites;
import joueur.Joueur;
import Comportement.Soigneur;


public class Healer extends Personnage {
	public Healer(Joueur J){
		
		J.getPersonnages().add(this);
		this.joueur = J;
		
		this.soin= new Soigneur();
		this.PV=30;
		
		this.tempsProduction=2;
		this.coutNourriture=40;
		this.coutOr=50;
	}
}
