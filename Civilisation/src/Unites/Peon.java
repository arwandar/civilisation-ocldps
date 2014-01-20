package Unites;
import joueur.Joueur;
import Batiment.BatProdUnit.typeUnite;
import Comportement.Constructeur;

public class Peon extends Personnage {
	public Peon(Joueur J){
		
		J.getPersonnages().add(this);
		this.joueur = J;
		
		this.setNOM("Peon");
		
		this.construire = new Constructeur();
		this.PVMax=25;
		this.PV=PVMax;
		
		this.tempsProduction=1;
		this.coutNourriture=10;
		J.setNourriture(J.getNourriture() - this.coutNourriture);
		
		this.setT(typeUnite.Peon);
	}
	
	//*************** Méthodes *******************
	@Override public void destructionUnite(Joueur J)
	{
		if(this.getPV() > 0)
		{
			J.setNourriture(J.getNourriture() + this.coutNourriture/2);
		}
		
		J.getPersonnages().remove(this);
		J.setOs(J.getOs() + 30);
	}
}