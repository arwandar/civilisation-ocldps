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
		
		this.setNOM("Catapulte");
		
		this.attitudeCombative= new CombatSiege();
		this.deplacer = new Roue();
		this.Attaque=80;
		this.Defense=0.2;
		this.PVMax=50;
		this.PV=PVMax;
		
		this.tempsProduction=3;
		this.coutOr=135;
		this.coutBois=160;
		J.setOr(J.getOr() - this.coutOr);
		J.setBois(J.getBois() - this.coutBois);
		
		this.setT(typeUnite.Catapulte);
	}
	/*public Catapulte(AttitudeCombative esprit, Soin soin, Deplacement dep, Construire cons, int att, int def, int pv, int tProd, int cN, int cO, int cB, int cF, int posH, int posV, int portee) {
	    super(esprit, soin, dep, cons, att, def, pv, tProd, cN, cO, cB, cF, posH, posV, portee);
	}*/
	
	//*************** Méthodes *******************
	@Override public void destructionUnite(Joueur J)
	{
		if(this.getPV() > 0)
		{
			J.setOr(J.getOr() + this.coutOr/2);
			J.setBois(J.getBois() + this.coutBois/2);
		}
		
		J.getPersonnages().remove(this);
	}
}
