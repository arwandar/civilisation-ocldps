package Unites;
import civ.Case;
import joueur.Joueur;
import Batiment.BatProdUnit.typeUnite;
import Comportement.Constructeur;

public class Peon extends Personnage {
	public Peon(Joueur J){
		
		J.getPersonnages().add(this);
		this.joueur = J;
		
		this.setNOM("Peon");
		
		this.construire = new Constructeur();
		this.PV=25;
		
		this.tempsProduction=1;
		this.coutNourriture=50;
		J.setOr(J.getOr() - this.coutNourriture);
		
		this.setT(typeUnite.Peon);
	}
	
	//*************** Méthodes *******************
	public void destructionUnite(Case M, Joueur J)
	{
		if(this.PV <= 0)
		{
			J.getPersonnages().remove(this);
			M.setUnitesurcase(false);// à remplacer par libérer case
			J.setOs(30);
		}
	}
}