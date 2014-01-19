package Unites;
import civ.Case;
import joueur.Joueur;
import Batiment.BatProdUnit.typeUnite;
import Comportement.CombatMagie;


public class Magicien extends Personnage {
	public Magicien(Joueur J){
		
		J.getPersonnages().add(this);
		this.joueur = J;
		
		this.setNOM("Magicien");
		
		this.attitudeCombative= new CombatMagie();
		this.Attaque=14;
		this.PVMax=30;
		this.PV=PVMax;
		
		this.tempsProduction=2;
		this.coutNourriture=50;
		this.coutOr=40;
		J.setOr(J.getOr() - this.coutOr);
		J.setNourriture(J.getNourriture() - this.coutNourriture);
		
		this.setT(typeUnite.Magicien);
	}
	
	//*************** Méthodes *******************
	@Override public void destructionUnite(Joueur J)
	{
		if(this.getPV() > 0)
		{
			J.setOr(J.getOr() + this.coutOr/2);
			J.setNourriture(J.getNourriture() + this.coutNourriture/2);
		}
		
		J.getPersonnages().remove(this);
		J.setOs(J.getOs() + 30);
	}
}
