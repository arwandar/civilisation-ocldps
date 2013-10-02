package Unites;
import Comportement.*;

public class Peon extends Personnage {
	public Peon(){
		this.construire = new Constructeur();
	}
	public Peon(AttitudeCombative esprit, Soin soin, Deplacement dep, Construire cons) {
	    super(esprit, soin, dep, cons);
	  }
}