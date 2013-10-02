package Unites;
import Comportement.*;



public class Milicien extends Personnage{
	 public Milicien(){
		    this.attitudeCombative = new CombatEpee();
		  }
	  public Milicien(AttitudeCombative esprit, Soin soin, Deplacement dep, Construire cons) {
	    super(esprit, soin, dep, cons);
	  }

}
