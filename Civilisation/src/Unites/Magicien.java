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
		J.setOr(J.getOr() - this.coutNourriture);
		
		this.setT(typeUnite.Magicien);
	}
	
	//*************** M�thodes *******************
	@Override public void destructionUnite(Case M, Joueur J)
	{
		if(this.PV <= 0)
		{
			J.getPersonnages().remove(this);
			M.setUnitesurcase(false);// � remplacer par lib�rer case
			J.setOs(30);
		}
	}
}
