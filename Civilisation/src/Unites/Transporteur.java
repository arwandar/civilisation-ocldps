package Unites;
import Comportement.*;

public class Transporteur extends Personnage {
	public Transporteur(){
		this.deplacement = new Bateau();
		
	}
	public Transporteur(AttitudeCombative esprit, Soin soin, Deplacement dep, Construire cons) {
	    super(esprit, soin, dep, cons);
	  }
}
