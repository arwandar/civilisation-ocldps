package Unites;
import Comportement.*;


public class Healer extends Personnage {
	public Healer(){
		this.soin= new Soigneur();
	}
	public Healer(AttitudeCombative esprit, Soin soin, Deplacement dep, Construire cons) {
	    super(esprit, soin, dep, cons);
	  }
}
