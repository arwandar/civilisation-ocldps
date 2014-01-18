package Unites;
import civ.Case;
import joueur.Joueur;
import Batiment.BatProdUnit.typeUnite;
import Comportement.Cheval;
import Comportement.CombatArc;

public class CavalierArcher extends Personnage {
	public CavalierArcher(Joueur J){
		
		J.getPersonnages().add(this);
		this.joueur = J;
		
		this.setNOM("Cavalier archer");
		
		this.attitudeCombative= new CombatArc();
		this.deplacer = new Cheval();
		this.Attaque=12;
		this.Defense=20;
		this.PVMax=50;
		this.PV=PVMax;
		
		this.tempsProduction=2;
		this.coutOr=70;
		this.coutBois=40;
		J.setOr(J.getOr() - this.coutOr);
		J.setBois(J.getBois() - this.coutBois);
		
		this.setT(typeUnite.CavalierArcher);
	}
	
	//*************** M�thodes *******************
	@Override public void destructionUnite(Case M, Joueur J)
	{
		J.getPersonnages().remove(this);
		M.setUnitesurcase(false);// � remplacer par lib�rer case
		J.setOs(100);
	}
}
