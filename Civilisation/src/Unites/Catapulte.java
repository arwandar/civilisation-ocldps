package Unites;
import civ.Case;
import joueur.Joueur;
import Batiment.BatProdUnit.typeUnite;
import Comportement.CombatSiege;
import Comportement.Roue;

public class Catapulte extends Personnage {
	public Catapulte(Joueur J){
		
		J.getPersonnages().add(this);
		this.joueur = J;
		
		this.attitudeCombative= new CombatSiege();
		this.deplacer = new Roue();
		this.Attaque=80;
		this.Defense=20;
		this.PV=50;
		
		this.tempsProduction=3;
		this.coutOr=135;
		this.coutBois=160;
		J.setOr(J.getOr() - this.coutOr);
		J.setOr(J.getOr() - this.coutBois);
		
		this.setT(typeUnite.Catapulte);
	}
	/*public Catapulte(AttitudeCombative esprit, Soin soin, Deplacement dep, Construire cons, int att, int def, int pv, int tProd, int cN, int cO, int cB, int cF, int posH, int posV, int portee) {
	    super(esprit, soin, dep, cons, att, def, pv, tProd, cN, cO, cB, cF, posH, posV, portee);
	}*/
	
	//*************** Méthodes *******************
	public void destructionUnite(Case M, Joueur J)
	{
		if(this.PV <= 0)
		{
			J.getPersonnages().remove(this);
			M.setUnitesurcase(false);// à remplacer par libérer case
		}
	}
}
