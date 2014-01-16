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
		this.PV=50;
		
		this.tempsProduction=2;
		this.coutOr=70;
		this.coutBois=40;
		J.setOr(J.getOr() - this.coutOr);
		J.setOr(J.getOr() - this.coutBois);
		
		this.setT(typeUnite.CavalierArcher);
	}
	
	//*************** Méthodes *******************
	@Override public void destructionUnite(Case M, Joueur J)
	{
		if(this.PV <= 0)
		{
			J.getPersonnages().remove(this);
			M.setUnitesurcase(false);// à remplacer par libérer case
			J.setOs(100);
		}
	}
}
