package Unites;
import civ.Case;
import joueur.Joueur;
import Batiment.BatProdUnit.typeUnite;
import Comportement.Bateau;
import Comportement.CombatArc;

public class Galere extends Personnage {
	public Galere(Joueur J){
		
		J.getPersonnages().add(this);
		this.joueur = J;
		
		this.setNOM("Galere");
		
		this.attitudeCombative= new CombatArc();
		this.deplacer = new Bateau();
		this.Attaque=12;
		this.Defense=20;
		this.PVMax=120;
		this.PV=PVMax;
		
		this.tempsProduction=3;
		this.coutOr=30;
		this.coutBois=90;
		J.setOr(J.getOr() - this.coutOr);
		J.setBois(J.getBois() - this.coutBois);
		
		this.setT(typeUnite.Galere);
	}
	
	//*************** Méthodes *******************
	@Override public void destructionUnite(Case M, Joueur J)
	{
		J.getPersonnages().remove(this);
		M.setUnitesurcase(false);// à remplacer par libérer case
	}
}
