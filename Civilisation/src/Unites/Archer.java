package Unites;
import Comportement.*;

public class Archer extends Personnage {
	public Archer(){
		this.attitudeCombative= new CombatArc();
		this.Attaque=8;
		this.PV=30;
		
		this.tempsProduction=1;
		this.coutOr=45;
		this.coutBois=25;
	}
}
