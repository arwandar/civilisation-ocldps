package Unites;
import Comportement.*;

public class Gal�re extends Personnage {
	public Gal�re(){
		this.attitudeCombative= new CombatArc();
		this.deplacement = new Bateau();
		
	}
	public Gal�re(AttitudeCombative esprit, Soin soin, Deplacement dep, Construire cons) {
	    super(esprit, soin, dep, cons);
	  }
}
