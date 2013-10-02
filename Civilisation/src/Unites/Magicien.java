package Unites;
import Comportement.*;


public class Magicien extends Personnage {
	public Magicien(){
		this.attitudeCombative= new CombatMagie();
		
	}
	public Magicien(AttitudeCombative esprit, Soin soin, Deplacement dep, Construire cons) {
	    super(esprit, soin, dep, cons);
	  }
}
