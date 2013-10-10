package Unites;
import Comportement.*;


public class Magicien extends Personnage {
	public Magicien(){
		this.attitudeCombative= new CombatMagie();
		this.Attaque=14;
		this.PV=30;
		
		this.tempsProduction=2;
		this.coutNourriture=50;
		this.coutOr=40;
	}
}
