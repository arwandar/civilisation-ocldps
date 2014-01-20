package Unites;
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
		this.Defense=0.2;
		this.PVMax=50;
		this.PV=PVMax;
		
		this.tempsProduction=2;
		this.coutOr=70;
		this.coutBois=40;
		J.setOr(J.getOr() - this.coutOr);
		J.setBois(J.getBois() - this.coutBois);
		
		this.setT(typeUnite.CavalierArcher);
	}
	
	//*************** Méthodes *******************
	@Override public void destructionUnite(Joueur J)
	{
		if(this.getPV() > 0)
		{
			J.setOr(J.getOr() + this.coutOr/2);
			J.setBois(J.getBois() + this.coutBois/2);
		}
		
		J.getPersonnages().remove(this);
		J.setOs(J.getOs() + 100);
	}
}
