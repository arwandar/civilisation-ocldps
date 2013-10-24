package Unites;
import joueur.Joueur;
import Batiment.BatProdUnit.typeUnite;
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
		J.setOr(J.getOr() - this.coutOr);
		J.setOr(J.getOr() - this.coutNourriture);
		
		this.t = typeUnite.Healer;
	}
}
