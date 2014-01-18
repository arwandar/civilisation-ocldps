package Unites;
import civ.Case;
import joueur.Joueur;
import Batiment.BatProdUnit.typeUnite;
import Comportement.Bateau;

public class Transporteur extends Personnage {
	public Transporteur(Joueur J){
		
		J.getPersonnages().add(this);
		this.joueur = J;
		
		this.setNOM("Transporteur");
		
		this.deplacer = new Bateau();
		this.Defense=15;
		this.PVMax=100;
		this.PV=PVMax;
		
		this.tempsProduction=3;
		this.coutBois=125;
		J.setBois(J.getBois() - this.coutBois);
		
		this.setT(typeUnite.Transporteur);
	}
	
	//*************** Méthodes *******************
	@Override public void destructionUnite(Case M, Joueur J)
	{
		if(this.PV <= 0)
		{
			J.getPersonnages().remove(this);
			M.setUnitesurcase(false);// à remplacer par libérer case
		}
	}
}
