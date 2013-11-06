package Unites;
import joueur.Joueur;
import Batiment.BatProdUnit.typeUnite;
import Comportement.CombatArc;
import civ.Case;

public class Archer extends Personnage {
	public Archer(Joueur J){
		
		J.getPersonnages().add(this);
		this.joueur = J;
		
		this.attitudeCombative= new CombatArc();
		this.Attaque=8;
		this.PV=30;
		
		this.tempsProduction=1;
		this.coutOr=45;
		this.coutBois=25;
		J.setOr(J.getOr() - this.coutOr);
		J.setOr(J.getOr() - this.coutBois);
		
		this.setT(typeUnite.Archer);
	}
	
	//*************** M�thodes *******************
	public void destructionUnite(Case M, Joueur J)
	{
		if(this.PV <= 0)
		{
			J.getPersonnages().remove(this);
			M.setUnitesurcase(false);// � remplacer par lib�rer case
			J.setOs(30);
		}
	}
}
