package Unites;
import civ.Case;
import joueur.Joueur;
import Batiment.BatProdUnit.typeUnite;
import Comportement.CombatArc;
import Comportement.Soigneur;


public class Healer extends Personnage {
	public Healer(Joueur J){
		
		J.getPersonnages().add(this);
		this.joueur = J;
		
		this.setNOM("Healer");
		
		this.soin= new Soigneur();
		this.attitudeCombative= new CombatArc();
		this.PVMax=30;
		this.PV=PVMax;
		
		this.tempsProduction=2;
		this.coutNourriture=40;
		this.coutOr=50;
		J.setOr(J.getOr() - this.coutOr);
		J.setNourriture(J.getNourriture() - this.coutNourriture);
		
		this.setT(typeUnite.Healer);
	}
	
	//*************** M�thodes *******************
	@Override public void destructionUnite(Case M, Joueur J)
	{
		J.getPersonnages().remove(this);
		M.setUnitesurcase(false);// � remplacer par lib�rer case
		J.setOs(30);
	}
}
