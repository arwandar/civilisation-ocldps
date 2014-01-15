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
		this.PV=120;
		
		this.tempsProduction=3;
		this.coutOr=30;
		this.coutBois=90;
		J.setOr(J.getOr() - this.coutOr);
		J.setOr(J.getOr() - this.coutBois);
		
		this.setT(typeUnite.Galere);
	}
	
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
