package Unites;
import civ.Case;
import joueur.Joueur;
import Batiment.BatProdUnit.typeUnite;
import Comportement.CombatEpee;



public class Milicien extends Personnage{
	 public Milicien(Joueur J){
		 
		 J.getPersonnages().add(this);
			this.joueur = J;
			
			this.setNOM("Milicien");
		 
		    this.attitudeCombative = new CombatEpee();
		    this.Attaque=8;
			this.PVMax=40;
			this.PV=PVMax;
			
			this.tempsProduction=1;
			this.coutNourriture=60;
			this.coutOr=20;
			J.setOr(J.getOr() - this.coutOr);
			J.setNourriture(J.getNourriture() - this.coutNourriture);
			
			this.setT(typeUnite.Milicien);
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
