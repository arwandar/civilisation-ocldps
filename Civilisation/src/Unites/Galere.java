package Unites;
import Comportement.*;

public class Galere extends Personnage {
	public Galere(){
		this.attitudeCombative= new CombatArc();
		this.deplacer = new Bateau();
		this.Attaque=12;
		this.Defense=20;
		this.PV=120;
		
		this.tempsProduction=3;
		this.coutOr=30;
		this.coutBois=90;
	}
}
