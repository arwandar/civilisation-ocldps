package Unites;
import Comportement.*;

public class Galère extends Personnage {
	public Galère(){
		this.attitudeCombative= new CombatArc();
		this.deplacement = new Bateau();
		
	}
	public Galère(AttitudeCombative esprit, Soin soin, Deplacement dep, Construire cons) {
	    super(esprit, soin, dep, cons);
	  }
}
