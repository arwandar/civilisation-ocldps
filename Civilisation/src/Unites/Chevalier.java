package Unites;
import Comportement.*;

public class Chevalier extends Personnage {
	public Chevalier(){
		this.attitudeCombative= new CombatEpee();
		this.deplacement = new Cheval();
		this.Attaque=14;
		this.Defense=25;
		this.PV=60;
		
		this.tempsProduction=2;
		this.coutNourriture=60;
		this.coutOr=50;

	}
}
