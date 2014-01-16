package Unites;
import civ.Case;
import joueur.Joueur;
import Batiment.BatProdUnit.typeUnite;
import Comportement.Soigneur;


public class Healer extends Personnage {
	public Healer(Joueur J){
		
		J.getPersonnages().add(this);
		this.joueur = J;
		
		this.setNOM("Healer");
		
		this.soin= new Soigneur();
		this.PV=30;
		
		this.tempsProduction=2;
		this.coutNourriture=40;
		this.coutOr=50;
		J.setOr(J.getOr() - this.coutOr);
		J.setOr(J.getOr() - this.coutNourriture);
		
		this.setT(typeUnite.Healer);
	}
	
	//*************** Méthodes *******************
	@Override public void destructionUnite(Case M, Joueur J)
	{
		if(this.PV <= 0)
		{
			J.getPersonnages().remove(this);
			M.setUnitesurcase(false);// à remplacer par libérer case
			J.setOs(30);
		}
	}
}
